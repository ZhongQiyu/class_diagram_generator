package model;


/**
 * A Java class that models the note to include in a class diagram.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class Note{

    private String body; //whatever goes inside the note

    /**
     * Constructor
     * @param body the body of the note
     */
    public Note(String body) {
        this.body = body;
    }

    /**
     * returns the body of the note
     * @return the body of the note
     */
    public String getBody(){
        return body;
    }

    /**
     * sets the body of the note
     * @param newBody a string to replace the body of the note with
     */
    public void setBody(String newBody) {
        body = newBody;
        notifyObservers();
    }

    /**
     * @return a complete representation of a note.
     */
    public String getInfo(){
        return "Note: " + getBody() + "\n";
    }

    /**
     * @return a partial representation of a note.
     */
    public String toString(){
        return "Note with body: " + getBody();
    }

    /**
     * Update the observers correspondingly to pass the data for class diagrams.
     */
    private void notifyObservers(){
        this.notify();//updates subscribers
    }
}
