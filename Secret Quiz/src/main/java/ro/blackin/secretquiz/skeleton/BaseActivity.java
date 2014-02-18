package ro.blackin.secretquiz.skeleton;

import android.app.ActionBar;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

/**
 * Created by Black on 1/10/14.
 */
public class BaseActivity extends ActionBarActivity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

    }




    /**
     * Action Bar Methods
     */
    protected void hideActionBar()
    {
        try
        {
            getSupportActionBar().hide();
        }
        catch (Exception ex)
        {
            //There is no supportActionBar :)
            ex.printStackTrace();
        }
    }

    protected void showActionBar()
    {
        try
        {
            getSupportActionBar().show();
        }
        catch (Exception ex)
        {
            //There is no supportActionBar :)
            ex.printStackTrace();
        }
    }

    public void setUpActionBar()
    {
        try
        {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

    public void setActionBarTitle(String text)
    {
        try
        {
            if(text != null)
            {
                android.support.v7.app.ActionBar ab = getSupportActionBar();
                ab.setTitle(text);
            }
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
