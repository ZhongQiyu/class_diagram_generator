package controller;

import model.Stereotype;
import javafx.beans.value.*;

import java.util.ArrayList;

/**
 * The listener that gets the feedback from the user operation and
 * test out the response of the whole system.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class PanelListener implements ChangeListener<String>{

    private boolean activated;
    private Stereotype name;

    /**
     * The default constructor of the panel listener.
     */
    public PanelListener() {

    }

    /**
     * The non-default constructor of the panel listener.
     * @param activated the status of activation for the listener.
     * @param name the label that is attached with the listener, to show its functionality.
     */
    public PanelListener(boolean activated, Stereotype name) {
        this.activated = activated;
        this.name = name;
    }

    /**
     * @return the status of the listener, in terms of whether it is activated or not.
     */
    public boolean isActivated() {
        return this.activated;
    }

    /**
     * Change the status of activation for the listener.
     * @param newActivatedStatus the new status of activation to set with.
     */
    private void changeActivated(boolean newActivatedStatus) {
        this.activated = newActivatedStatus;
    }

    /**
     * @return the functionality that the panel listener is doing.
     */
    public Stereotype getName() {
        return this.name;
    }

    /**
     * @param newName the new name to set for the listener, meaning a change of functionality.
     */
    private void setName(Stereotype newName) {
        this.name = newName;
    }

    /**
     * Change the status of the ChangeListener, based on the comparison between
     * the old value and a new value, in a sequence of observable values.
     * @param observable the sequence of observable values to check on the ChangeListener data structure.
     * @param oldValue the old value that the listener holds.
     * @param newValue the new value that the listener to hold.
     */
    @Override
    public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
        this.changeActivated(!oldValue.equals(newValue));//
    }

    /**
     * The driver function.
     * @param args the arguments to apply in the command lines.
     */
    public static void main(String[] args) {

    }

}
