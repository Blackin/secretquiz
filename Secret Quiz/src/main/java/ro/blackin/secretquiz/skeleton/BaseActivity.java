package ro.blackin.secretquiz.skeleton;

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

        try
        {
//            getSupportActionBar().hide();
            getSupportActionBar().show();
        }
        catch (Exception ex)
        {
            //There is no supportActionBar :)
            ex.printStackTrace();
        }
    }
}
