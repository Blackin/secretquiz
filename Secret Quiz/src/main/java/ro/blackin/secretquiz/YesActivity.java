package ro.blackin.secretquiz;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

import ro.blackin.secretquiz.skeleton.BaseActivity;

public class YesActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_yes);
        hideActionBar();

        //TODO: Play sound
        SQApplication app = (SQApplication) getApplication();
        app.soundPlayer.playFinalSound();

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}
