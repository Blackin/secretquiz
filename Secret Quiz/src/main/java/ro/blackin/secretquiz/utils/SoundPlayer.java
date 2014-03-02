package ro.blackin.secretquiz.utils;

import android.content.Context;
import android.media.AudioManager;
import android.media.SoundPool;

import java.util.HashMap;

import ro.blackin.secretquiz.R;

/**
 * Created by Black on 2/28/14.
 */
public class SoundPlayer
{
    private static SoundPlayer instance;

    private SoundPool soundPool;
    private HashMap<Integer, Integer> soundPoolMap;
    private Context context;
    float curVolume;
    float maxVolume;
    float leftVolume;
    float rightVolume;
    float normal_playback_rate = 1f;
    private boolean isLoaded = false;
    private boolean muted = false;

    public int backgroundSoundId = -1;
    public int correctSoundId = -1;
    public int wrongSoundId = -1;


    private SoundPlayer(Context ctx)
    {
        context = ctx;
        initSoundPool();
    }

    public static SoundPlayer getInstance(Context ctx)
    {
        if(instance == null)
        {
            instance = new SoundPlayer(ctx);
        }

        return instance;
    }

    /**
     * Load sounds into memory
     */
    public void initSoundPool()
    {
        initSoundPool( false );
    }

    public void initSoundPool( final boolean playBackground )
    {
        //Init stuff
        soundPool = new SoundPool( 4, AudioManager.STREAM_MUSIC, 100);
        soundPoolMap = new HashMap<Integer, Integer>();
        AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
        curVolume = audioManager.getStreamVolume(AudioManager.STREAM_MUSIC);
        maxVolume = audioManager.getStreamMaxVolume(AudioManager.STREAM_MUSIC);
        leftVolume = curVolume/maxVolume;
        rightVolume = curVolume/maxVolume;

        //On Load Complete
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int i, int i2)
            {
                SoundPlayer.this.setIsLoaded(true);
                if(playBackground)
                {
                    playBackgroundMusic();
                }
            }
        });

        //Load Sounds
        backgroundSoundId = soundPool.load(context, R.raw.sound_background, 3);
        correctSoundId = soundPool.load(context, R.raw.sound_correct, 2);
        wrongSoundId = soundPool.load(context, R.raw.sound_wrong, 1);
    }

    public void onPause()
    {
        if(soundPool != null)
        {
            soundPool.autoPause();
            soundPool = null;
        }
    }

    public void onResume()
    {
        if(soundPool == null) {
            this.initSoundPool();
        }
    }

    public void muteSounds()
    {
        this.setMuted(true);
        this.soundPool.autoPause();
    }

    public void unmuteSounds()
    {
        this.setMuted(false);
        if(this.soundPool != null) {
            this.soundPool.autoResume();
        } else {
            this.initSoundPool(true);
        }
    }

    /**
     * Play background music
     */
    public void playBackgroundMusic()
    {
        soundPool.play(backgroundSoundId,leftVolume,rightVolume, 2 , -1 ,normal_playback_rate);
    }

    /**
     * Play correct sound
     */
    public void playCorrectSound()
    {
        if(soundPool == null) {
            this.initSoundPool();
        }
        if(!this.isMuted()){
            soundPool.play(correctSoundId,leftVolume,rightVolume, 1 , 0 ,normal_playback_rate);
        }
    }

    /**
     * Play wrong sound
     */
    public void playWrongSound()
    {
        if(soundPool == null) {
            this.initSoundPool();
        }
        if(!this.isMuted()){
            soundPool.play(wrongSoundId,leftVolume,rightVolume, 1 , 0 ,normal_playback_rate);
        }
    }


    /**
     * Getters and Setters
     */

    public boolean isIsLoaded() {
        return isLoaded;
    }

    public void setIsLoaded(boolean is_loaded) {
        this.isLoaded = is_loaded;
    }

    public boolean isMuted() {
        return muted;
    }

    public void setMuted(boolean muted) {
        this.muted = muted;
    }

}
