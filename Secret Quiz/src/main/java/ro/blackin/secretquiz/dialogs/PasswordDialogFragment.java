package ro.blackin.secretquiz.dialogs;

import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.TextView;

import ro.blackin.secretquiz.R;

/**
 * Created by Black on 3/3/14.
 */
public class PasswordDialogFragment extends DialogFragment implements EditText.OnEditorActionListener
{
    private EditText mEditText;

    public PasswordDialogFragment() {
        // Empty constructor required for DialogFragment
    }

    public interface EditNameDialogListener {
        void onFinishEditDialog(String inputText);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        View view = inflater.inflate(R.layout.dialog_parola,container);
        mEditText = (EditText) view.findViewById(R.id.etParolaDialog);
        getDialog().setTitle("Parola!");

        mEditText.requestFocus();
        getDialog().getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE);
        mEditText.setOnEditorActionListener(this);

        return view;
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent)
    {
        EditNameDialogListener activity = (EditNameDialogListener) getActivity();
        activity.onFinishEditDialog(mEditText.getText().toString());
        this.dismiss();
        return true;
    }
}
