package ro.blackin.secretquiz.fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ro.blackin.secretquiz.R;
import ro.blackin.secretquiz.models.Question;

/**
 * Created by Black on 1/20/14.
 */
public class QuestionFragment extends Fragment
{
    Question question;

    public static QuestionFragment newInstance( Question q )
    {
        QuestionFragment fragment = new QuestionFragment();

        Bundle args = new Bundle();
        args.putSerializable("question", q);
        fragment.setArguments(args);

        fragment.question = q;
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        if(getArguments() != null)
        {
            fetchQuestion(getArguments());
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState)
    {
        //Fetch the question in case we don't have it
        if(question == null)
        {
            fetchQuestion(savedInstanceState);
        }

        ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_question, null);
        TextView tv = (TextView) rootView.findViewById(R.id.tvQuestionTitle);
        tv.setText(question.getTitle());

        return rootView;
    }


    private void fetchQuestion(Bundle savedInstanceState)
    {
        try
        {
            question = (Question) savedInstanceState.get("question");
        }
        catch (Exception ex)
        {
            ex.printStackTrace();
        }
    }

}
