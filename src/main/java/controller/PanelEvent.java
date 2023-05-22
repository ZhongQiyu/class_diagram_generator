package controller;

import javafx.event.Event;

/**
 * A Java class that models the Event series in the class.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class PanelEvent {

    private Event e;
    private String description;

    /**
     * A default constructor for modeling events going on in the panel.
     */
    public PanelEvent() {
        e = null;
        description = null;
    }

    /**
     * A non-default constructor for modeling events going on in the panel.
     * @param e the event object that wraps around the class of PanelEvent.
     * @param description the description that aims for illustrating the information of the PanelEvent.
     */
    public PanelEvent(Event e, String description) {
        this.e = e;
        this.description = description;
    }

    /**
     * The way of updating the event's dynamics.
     * @param e the new event that gets around for the update.
     */
    public void update(Event e) {

    }

}
