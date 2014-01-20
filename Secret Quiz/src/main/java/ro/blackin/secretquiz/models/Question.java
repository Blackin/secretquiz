package ro.blackin.secretquiz.models;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Mihai on 1/9/14.
 */
public class Question implements Serializable
{
    private String title;
    private int order;
    private ArrayList<Answer> answers;


    

    /*
    GETTERS & SETTERS
     */

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }

    public ArrayList<Answer> getAnswers() {
        return answers;
    }

    public void setAnswers(ArrayList<Answer> answers) {
        this.answers = answers;
    }

    public void addAnswer( Answer answer )
    {
        if(this.answers == null){
            this.answers = new ArrayList<Answer>();
        }

        this.answers.add(answer);
    }
}
