package ro.blackin.secretquiz.fragments;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.support.v7.widget.GridLayout;
import android.widget.ViewFlipper;

import ro.blackin.secretquiz.R;
import ro.blackin.secretquiz.models.Answer;
import ro.blackin.secretquiz.models.Question;
import ro.blackin.secretquiz.views.NonSwipeableViewPager;

/**
 * Created by Black on 1/20/14.
 */
public class QuestionFragment extends Fragment
{
    Question question;
    NonSwipeableViewPager pager;

    public static QuestionFragment newInstance( Question q, NonSwipeableViewPager pg )
    {
        QuestionFragment fragment = new QuestionFragment();

        Bundle args = new Bundle();
        args.putSerializable("question", q);
        fragment.setArguments(args);

        fragment.question = q;
        fragment.pager = pg;

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

        /**
         * Normal Questions
         */
        if(!question.isFinalQuestion())
        {
            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_question, null);
            final ViewFlipper flipper = (ViewFlipper) rootView.findViewById(R.id.vfQuestionViewFlipper);
            //Answer Button click listener
            View.OnClickListener answerClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    try{
                        Button btn = (Button) view;
                        Answer answer = (Answer) btn.getTag();

                        if(answer.isCorrect()){
                            //Show CORRECT answer page
                            flipper.showNext();
                        } else {
                            //Show WRONG answer page
                            flipper.showNext();
                            flipper.showNext();
                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };

            //Question
            TextView tv = (TextView) rootView.findViewById(R.id.tvQuestionTitle);
            tv.setText(question.getTitle());

            //Pune butoanele cu raspunsurile in gridview
            Button answer1 = (Button) rootView.findViewById(R.id.btnAnswer1);
            answer1.setText(question.getAnswers().get(0).getTitle());
            answer1.setTag(question.getAnswers().get(0));
            answer1.setOnClickListener(answerClickListener);

            Button answer2 = (Button) rootView.findViewById(R.id.btnAnswer2);
            answer2.setText(question.getAnswers().get(1).getTitle());
            answer2.setTag(question.getAnswers().get(1));
            answer2.setOnClickListener(answerClickListener);

            Button answer3 = (Button) rootView.findViewById(R.id.btnAnswer3);
            answer3.setText(question.getAnswers().get(2).getTitle());
            answer3.setTag(question.getAnswers().get(2));
            answer3.setOnClickListener(answerClickListener);

            Button answer4 = (Button) rootView.findViewById(R.id.btnAnswer4);
            answer4.setText(question.getAnswers().get(3).getTitle());
            answer4.setTag(question.getAnswers().get(3));
            answer4.setOnClickListener(answerClickListener);


            //Next Question Buttons
            View.OnClickListener nextListener = new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    if(pager.getAdapter() != null)
                    {
                        if(pager.getCurrentItem() < pager.getAdapter().getCount() - 1 )
                        {
                            pager.setCurrentItem( pager.getCurrentItem() + 1 );
                        }
                    }
                }
            };

            Button btnNextCorrect = (Button) rootView.findViewById(R.id.btnCorrectNextQuestion);
            btnNextCorrect.setOnClickListener(nextListener);
            Button btnNextWrong = (Button) rootView.findViewById(R.id.btnWrongNextQuestion);
            btnNextWrong.setOnClickListener(nextListener);

            return rootView;
        }
        else
        {
            /**
             * Final question
             */

            return null;
        }
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

