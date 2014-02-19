package ro.blackin.secretquiz;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v4.app.DialogFragment;
import android.os.Bundle;
import android.support.v4.view.ViewPager;

import ro.blackin.secretquiz.adapters.QuizPagerAdapter;
import ro.blackin.secretquiz.dialogs.QuitQuizDialogFragment;
import ro.blackin.secretquiz.skeleton.BaseActivity;
import ro.blackin.secretquiz.utils.Statics;
import ro.blackin.secretquiz.views.NonSwipeableViewPager;
import ro.blackin.secretquiz.views.SecretQuizDialog;

/**
 * Created by Black on 1/11/14.
 */
public class TakeQuizActivity extends BaseActivity implements SecretQuizDialog.QuitQuizDialogListener
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
        QuitQuizDialogFragment quitDialogFragment = new QuitQuizDialogFragment(this);
        quitDialogFragment.show(getSupportFragmentManager(),"QuitDialog");
    }


    @Override
    public void onQuitDialogPositiveClick(SecretQuizDialog dialog) {
        Statics.CURRENT_SCORE = 0;
        Statics.CURRENT_QUESTION_NR = 0;
        this.finish();

    }

    @Override
    public void onQuitDialogNegativeClick(SecretQuizDialog dialog) {
        dialog.dismiss();
    }
}
