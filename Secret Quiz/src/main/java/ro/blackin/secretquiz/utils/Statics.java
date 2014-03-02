package ro.blackin.secretquiz.utils;

import ro.blackin.secretquiz.models.Quiz;

/**
 * Created by Black on 1/11/14.
 */
public class Statics {

    public static int CURRENT_QUESTION_NR = 0;

    public static int CURRENT_SCORE = 0;

    public static Quiz currentQuiz = null;

    public static boolean PLAY_SOUNDS = true;

    /**
     * Score
     */
    public void resetScore()
    {
        CURRENT_SCORE = 0;
    }


}
