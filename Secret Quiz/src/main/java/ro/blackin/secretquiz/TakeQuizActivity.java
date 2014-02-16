package ro.blackin.secretquiz;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import ro.blackin.secretquiz.adapters.QuizPagerAdapter;
import ro.blackin.secretquiz.skeleton.BaseActivity;
import ro.blackin.secretquiz.utils.Statics;
import ro.blackin.secretquiz.views.NonSwipeableViewPager;

/**
 * Created by Black on 1/11/14.
 */
public class TakeQuizActivity extends BaseActivity
{
    NonSwipeableViewPager vpTakeQuiz;
    QuizPagerAdapter quizAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_takequiz);

        if(Statics.currentQuiz == null)
        {
            //No quiz set - no use in continuing
            finish();
        }

        //Get quiz
        vpTakeQuiz = (NonSwipeableViewPager) findViewById(R.id.vpTakeQuiz);
        quizAdapter = new QuizPagerAdapter(this, Statics.currentQuiz, vpTakeQuiz);
        vpTakeQuiz.setAdapter( quizAdapter );

    }

    @Override
    public void onBackPressed()
    {
//        super.onBackPressed();

        //Nope
        return;
    }
}
