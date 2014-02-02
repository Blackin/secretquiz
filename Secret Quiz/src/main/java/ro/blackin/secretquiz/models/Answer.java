package ro.blackin.secretquiz.models;

import java.io.Serializable;

/**
 * Created by Mihai on 1/9/14.
 */
public class Answer implements Serializable {

    private String title;
    private boolean correct;
    private int order;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getOrder() {
        return order;
    }

    public void setOrder(int order) {
        this.order = order;
    }
}
