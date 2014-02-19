package ro.blackin.secretquiz.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;

import ro.blackin.secretquiz.R;
import ro.blackin.secretquiz.views.SecretQuizDialog;

/**
 * Created by Black on 2/19/14.
 */
public class QuitQuizDialogFragment extends DialogFragment
{
    SecretQuizDialog.QuitQuizDialogListener listener;

    public QuitQuizDialogFragment(SecretQuizDialog.QuitQuizDialogListener list)
    {
        this.listener = list;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState)
    {
        SecretQuizDialog dialog = new SecretQuizDialog(getActivity(),this.listener);
        return dialog;
    }
}