package ro.blackin.secretquiz;

import android.os.Bundle;
import android.support.v4.view.ViewPager;

import ro.blackin.secretquiz.skeleton.BaseActivity;
import ro.blackin.secretquiz.utils.Statics;

/**
 * Created by Black on 1/11/14.
 */
public class TakeQuizActivity extends BaseActivity
{

    ViewPager vpTakeQuiz;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_takequiz);

        if(Statics.currentQuiz == null)
        {
            //No quiz set - no use in continuing
            finish();
        }
    }

    private void initUI()
    {
        vpTakeQuiz = (ViewPager) findViewById(R.id.vpTakeQuiz);


    }



}
