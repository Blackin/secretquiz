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
        question.setTitle("Cum ai defini conceptul \"femeia perfecta\" ? ");
        question.setOrder(0);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("Nu exista");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("Monica Tatoiu");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(2);
        answer.setTitle("Uite-ma !");
        answer.setCorrect(true);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(3);
        answer.setTitle("Ahahahaha");
        answer.setCorrect(false);
        question.addAnswer(answer);

        quiz.addQuestion(question);


        //Question 2
        question= new Question();
        question.setTitle("Sincer, crezi ca vei avea VREO lenjerie cu colturile intregi in viata asta ? ");
        question.setOrder(1);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("Spre binele tau");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("Nu vreau asa ceva");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(2);
        answer.setTitle("Ce ma ???");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(3);
        answer.setTitle("Ai belit-o");
        answer.setCorrect(true);
        question.addAnswer(answer);

        quiz.addQuestion(question);


        //Question 3
        question= new Question();
        question.setTitle("Ce proportie din suprafata dormibila a patului i se cuvine femeii ?");
        question.setOrder(2);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("98.23%");
        answer.setCorrect(true);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("40%");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(2);
        answer.setTitle("10%");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(3);
        answer.setTitle("50%");
        answer.setCorrect(false);
        question.addAnswer(answer);

        quiz.addQuestion(question);

        //Question 4
        question= new Question();
        question.setTitle("Pe ce continent te ador eu cel mai mult ? ");
        question.setOrder(2);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("Africa");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("Europa");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(2);
        answer.setTitle("Asia");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(3);
        answer.setTitle("Peste TOT");
        answer.setCorrect(true);
        question.addAnswer(answer);

        quiz.addQuestion(question);

        //Question 5
        question= new Question();
        question.setTitle("Cum trebuie sa fie barbatul perfect ?");
        question.setOrder(2);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("Destept");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("Ca Picu");
        answer.setCorrect(true);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(2);
        answer.setTitle("Romantic");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(3);
        answer.setTitle("Frumos");
        answer.setCorrect(false);
        question.addAnswer(answer);

        quiz.addQuestion(question);

        //Question 6
        question= new Question();
        question.setTitle("Mai reusesti sa ma suporti mult ? ");
        question.setOrder(2);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("Nu");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("Nuuu");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(2);
        answer.setTitle("Nu mai pot frate");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(3);
        answer.setTitle("Un pic asa");
        answer.setCorrect(true);
        question.addAnswer(answer);

        quiz.addQuestion(question);


        //Question 7
        question= new Question();
        question.setTitle("Ai idee care o sa fie urmatoarea intrebare ? (Daca ghicesti primesti un premiu!) :)");
        question.setOrder(2);

        answer = new Answer();
        answer.setOrder(0);
        answer.setTitle("Hmm..");
        answer.setCorrect(true);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(1);
        answer.setTitle("Mai e una ???");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(2);
        answer.setTitle("Hai frate..");
        answer.setCorrect(false);
        question.addAnswer(answer);

        answer = new Answer();
        answer.setOrder(3);
        answer.setTitle("Bai asta...");
        answer.setCorrect(false);
        question.addAnswer(answer);

        quiz.addQuestion(question);





        //Final Question
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
