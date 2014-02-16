package ro.blackin.secretquiz.providers;

import ro.blackin.secretquiz.models.Answer;
import ro.blackin.secretquiz.models.Question;
import ro.blackin.secretquiz.models.Quiz;

/**
 * Created by Mihai on 1/9/14.
 */
public class HardCodedQuizProvider implements  QuizProvider
{
    Quiz quiz;
    Question question;
    Answer answer;

    public HardCodedQuizProvider()
    {
        //Create the questions and the answers and insert them in the quiz
        quiz = new Quiz();

        //Question 1
        question= new Question();
        question.setTitle("Unde traiesc ursii polari ?");
        question.setOrder(0);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("La Polul Sud");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("In jungla");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(2);
        answer.setTitle("La Polul Nord");
        answer.setCorrect(true);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(3);
        answer.setTitle("In savana africana");
        answer.setCorrect(false);
        question.addAnswer(answer);

        quiz.addQuestion(question);


        //Question 2
        question= new Question();
        question.setTitle("Unde traiesc ursii polari 2 ?");
        question.setOrder(1);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("La Polul Sud");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("In jungla");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(2);
        answer.setTitle("La Polul Nord");
        answer.setCorrect(true);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(3);
        answer.setTitle("In savana africana");
        answer.setCorrect(false);
        question.addAnswer(answer);

        quiz.addQuestion(question);


        //Question 3
        question= new Question();
        question.setTitle("Unde traiesc ursii polari 3 ?");
        question.setOrder(2);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("La Polul Sud");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("In jungla");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(2);
        answer.setTitle("La Polul Nord");
        answer.setCorrect(true);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(3);
        answer.setTitle("In savana africana");
        answer.setCorrect(false);
        question.addAnswer(answer);

        quiz.addQuestion(question);

        //Question 4
        question= new Question();
        question.setTitle("Unde traiesc ursii polari 4 ?");
        question.setOrder(2);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("La Polul Sud");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("In jungla");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(2);
        answer.setTitle("La Polul Nord");
        answer.setCorrect(true);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(3);
        answer.setTitle("In savana africana");
        answer.setCorrect(false);
        question.addAnswer(answer);

        quiz.addQuestion(question);

        //Question 5
        question= new Question();
        question.setTitle("Unde traiesc ursii polari 5 ?");
        question.setOrder(2);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("La Polul Sud");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("In jungla");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(2);
        answer.setTitle("La Polul Nord");
        answer.setCorrect(true);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(3);
        answer.setTitle("In savana africana");
        answer.setCorrect(false);
        question.addAnswer(answer);

        quiz.addQuestion(question);


        //Question 6
        question= new Question();
        question.setTitle("Ana are mere ?");
        question.setOrder(2);
        question.setFinalQuestion(true);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("Da");
        answer.setCorrect(true);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("Nu");
        answer.setCorrect(false);
        question.addAnswer(answer);


        quiz.addQuestion(question);

    }

    @Override
    public Quiz getQuiz()
    {
        return quiz;
    }
}
