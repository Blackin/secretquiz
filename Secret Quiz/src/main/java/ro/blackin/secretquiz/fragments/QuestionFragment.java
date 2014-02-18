package ro.blackin.secretquiz.fragments;

import android.content.DialogInterface;
import android.content.Intent;
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
import ro.blackin.secretquiz.YesActivity;
import ro.blackin.secretquiz.models.Answer;
import ro.blackin.secretquiz.models.Question;
import ro.blackin.secretquiz.skeleton.BaseActivity;
import ro.blackin.secretquiz.utils.Statics;
import ro.blackin.secretquiz.views.NonSwipeableViewPager;
import ro.blackin.secretquiz.views.SAutoBgButton;

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

            //Action Bar Title
            try {
                BaseActivity activity = (BaseActivity) getActivity();
                activity.setActionBarTitle("Question No." + String.valueOf(pager.getCurrentItem() + 1) );
            } catch (Exception ex) {
                ex.printStackTrace();
            }

            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_question, null);
            final ViewFlipper flipper = (ViewFlipper) rootView.findViewById(R.id.vfQuestionViewFlipper);
            //Answer Button click listener
            View.OnClickListener answerClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    try{
                        SAutoBgButton btn = (SAutoBgButton) view;
                        Answer answer = (Answer) btn.getTag();

                        if(answer.isCorrect()){
                            //Increment Score
                            Statics.CURRENT_SCORE++;

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
            SAutoBgButton answer1 = (SAutoBgButton) rootView.findViewById(R.id.btnAnswer1);
            answer1.setText(question.getAnswers().get(0).getTitle());
            answer1.setTag(question.getAnswers().get(0));
            answer1.setOnClickListener(answerClickListener);

            SAutoBgButton answer2 = (SAutoBgButton) rootView.findViewById(R.id.btnAnswer2);
            answer2.setText(question.getAnswers().get(1).getTitle());
            answer2.setTag(question.getAnswers().get(1));
            answer2.setOnClickListener(answerClickListener);

            SAutoBgButton answer3 = (SAutoBgButton) rootView.findViewById(R.id.btnAnswer3);
            answer3.setText(question.getAnswers().get(2).getTitle());
            answer3.setTag(question.getAnswers().get(2));
            answer3.setOnClickListener(answerClickListener);

            SAutoBgButton answer4 = (SAutoBgButton) rootView.findViewById(R.id.btnAnswer4);
            answer4.setText(question.getAnswers().get(3).getTitle());
            answer4.setTag(question.getAnswers().get(3));
            answer4.setOnClickListener(answerClickListener);


            //Next Question SAutoBgButtons
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

            SAutoBgButton btnNextCorrect = (SAutoBgButton) rootView.findViewById(R.id.btnCorrectNextQuestion);
            btnNextCorrect.setOnClickListener(nextListener);
            SAutoBgButton btnNextWrong = (SAutoBgButton) rootView.findViewById(R.id.btnWrongNextQuestion);
            btnNextWrong.setOnClickListener(nextListener);

            return rootView;
        }
        else
        {
            /**
             * Final question
             */
            ViewGroup rootView = (ViewGroup) inflater.inflate(R.layout.fragment_final_question, null);
            final ViewFlipper flipper = (ViewFlipper) rootView.findViewById(R.id.vfQuestionViewFlipper);
            //Answer Button click listener
            View.OnClickListener answerClickListener = new View.OnClickListener() {
                @Override
                public void onClick(View view)
                {
                    try{
                        SAutoBgButton btn = (SAutoBgButton) view;
                        Answer answer = (Answer) btn.getTag();

                        if(answer.isCorrect())
                        {
                            //A zis DA !!! :D
                            Intent intent = new Intent(getActivity(), YesActivity.class);
                            startActivity(intent);
                        }
                        else
                        {
                            //Nu exista asa ceva!

                        }

                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            };

            //Pune butoanele cu raspunsurile in gridview
            SAutoBgButton answer1 = (SAutoBgButton) rootView.findViewById(R.id.btnAnswer1);
            answer1.setText(question.getAnswers().get(0).getTitle());
            answer1.setTag(question.getAnswers().get(0));
            answer1.setOnClickListener(answerClickListener);

            SAutoBgButton answer2 = (SAutoBgButton) rootView.findViewById(R.id.btnAnswer2);
            answer2.setText(question.getAnswers().get(1).getTitle());
            answer2.setTag(question.getAnswers().get(1));
            answer2.setOnClickListener(answerClickListener);

            return rootView;
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

