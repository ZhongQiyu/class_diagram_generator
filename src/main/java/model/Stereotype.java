package model;

import java.util.ArrayList;

/**
 * A Java class that models the labelling mechanism between each class diagram.
 * Usually, there is a source and there is a destination. But due to the variation
 * of relations, it might be an indicator of subtyping as well.
 * @author Brendan Pritkin, Tyler Nass, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class Stereotype {

    private String label;
    // private Coordinate location;

    /**
     * The non-default constructor of a stereotype.
     * @param label
     */
    public Stereotype(String label) {
        this.label = label;
    }

    /**
     * @return the value stored in the stereotype.
     */
    public String getLabel() {
        return this.label;
    }

    /**
     * @param newLabel the new value to get assigned to the stereotype.
     */
    private void setLabel(String newLabel) {
        this.label = newLabel;
    }

    /**
     * @return a complete representation of the stereotype.
     */
    public String getInfo(){
        return "Stereotype: " + label + "\n";
    }

    /**
     * @return a partial representation of the stereotype.
     */
    public String toString(){
        return "<<" + label + ">>";
    }

}
