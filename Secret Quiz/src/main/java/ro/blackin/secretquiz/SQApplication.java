package ro.blackin.secretquiz;

import android.app.Application;
import android.media.AudioManager;
import android.os.Handler;

import ro.blackin.secretquiz.utils.SoundPlayer;

/**
 * Created by Black on 3/1/14.
 */
public class SQApplication extends Application
{
    public SoundPlayer soundPlayer;

    @Override
    public void onCreate() {
        super.onCreate();

        //Sounds
        soundPlayer = SoundPlayer.getInstance(this.getApplicationContext());

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
//                soundPlayer.playBackgroundMusic();
//                setActionBarTitle("Secret Quiz");
//                showActionBar();
            }
        }, 2000);

    }

    @Override
    public void onTerminate()
    {
        super.onTerminate();

    }


}
