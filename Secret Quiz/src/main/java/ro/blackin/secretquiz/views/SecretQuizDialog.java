package ro.blackin.secretquiz.views;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.View;
import android.view.Window;

import ro.blackin.secretquiz.R;

/**
 * Custom dialog displayed when the user presses the back button during the quiz
 *
 * Created by Black on 2/19/14.
 */
public class SecretQuizDialog extends Dialog implements View.OnClickListener
{

    /**
     * Interface that handles the click events (Used in the parent Activity)
     */
    public interface QuitQuizDialogListener {
        public void onQuitDialogPositiveClick(SecretQuizDialog dialog);
        public void onQuitDialogNegativeClick(SecretQuizDialog dialog);
    }
    QuitQuizDialogListener listener;

    /*
    Members
     */
    public CustomFontButton btnYes, btnNo;
    public CustomFontTextView tvTitle;

    public Context ctx;

    /*
    Methods
     */
    public SecretQuizDialog(Context context) {
        super(context);
    }

    public SecretQuizDialog(Context context, QuitQuizDialogListener list) {
        super(context);
        this.listener = list;
        this.ctx = context;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.dialog_quit);

        initUI();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btnQDYes:
                listener.onQuitDialogPositiveClick(this);
                break;

            case R.id.btnQDNo:
                listener.onQuitDialogNegativeClick(this);
                break;
        }
    }

    private void initUI()
    {
        tvTitle = (CustomFontTextView) findViewById(R.id.tvQDTitle);
        tvTitle.setText( ctx.getResources().getString(R.string.back_dialog_message) );

        btnYes = (CustomFontButton) findViewById(R.id.btnQDYes);
        btnNo = (CustomFontButton) findViewById(R.id.btnQDNo);

        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);
    }

}
