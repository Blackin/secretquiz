package ro.blackin.secretquiz.adapters;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.view.View;

import ro.blackin.secretquiz.models.Quiz;

/**
 * Created by Black on 1/11/14.
 */
public class QuizPagerAdapter extends FragmentStatePagerAdapter
{
    Quiz quiz = null;
    FragmentActivity activity;

    public QuizPagerAdapter( FragmentActivity activity, Quiz qz )
    {
        super( activity.getSupportFragmentManager() );
        this.activity = activity;
        quiz = qz;
    }

    @Override
    public Fragment getItem(int i)
    {
       //TODO: Returneaza fragmentu` :D

        return new Fragment();
    }

    @Override
    public int getCount() {

        if(quiz != null)
        {
            return quiz.questions.size();
        }
        else
        {
            return 0;
        }
    }
}
