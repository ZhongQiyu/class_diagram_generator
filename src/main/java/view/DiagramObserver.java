package view;

import java.awt.event.ActionListener;
import java.util.EventListener;
import javafx.beans.InvalidationListener;
import javafx.beans.Observable;
import javafx.event.EventHandler;
import model.Diagram;

/**
 * A Java class that handles the observers in the diagram so that
 * the diagram would be notified and updated correspondingly.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class DiagramObserver implements Observable {

    private Diagram source;

    /**
     * A default constructor that
     */
    public DiagramObserver(Diagram realSource) {
        this.source = realSource;
    }

    /**
     *
     */
    @Override
    public void addListener(InvalidationListener listener) {

    }

    /**
     *
     */
    @Override
    public void removeListener(InvalidationListener listener) {

    }

}
