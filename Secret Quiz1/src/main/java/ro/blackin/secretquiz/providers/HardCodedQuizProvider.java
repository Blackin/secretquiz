package ro.blackin.secretquiz.providers;

import ro.blackin.secretquiz.models.Quiz;

/**
 * Created by Mihai on 1/9/14.
 */
public class HardCodedQuizProvider implements  QuizProvider
{
    Quiz quiz;

    public HardCodedQuizProvider()
    {
        //Create the questions and the answers and insert them in the quiz
        quiz = new Quiz();


        //First Question

    }

    @Override
    public Quiz getQuiz()
    {
        return quiz;
    }
}
