package ro.blackin.secretquiz.models;

import java.util.ArrayList;

/**
 * Created by Mihai on 1/9/14.
 */
public class Quiz {

    public ArrayList<Question> questions;

    private String title;
    private String description;

    public Quiz()
    {

    }

    /*
    GETTERS & SETTERS
     */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }

    public void addQuestion(Question question)
    {
        if(this.questions == null){
            this.questions = new ArrayList<Question>();
        }
        questions.add(question);
    }
}
