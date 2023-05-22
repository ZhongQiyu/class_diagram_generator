package model;

/**
 * A Java class that models the relationship between
 * two class diagrams.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class Instance implements Relationship{
    private ClassInfo origin, destination;
    private String label;
    private Stereotype stereotype;

    /**
     * Default constructor of the instance relation.
     */
    public Instance(){
        this.origin = null;
        this.destination = null;
        label = null;
        stereotype = null;
    }

    /**
     * Non-default constructor.
     * @param origin the class that has an instance of the other class
     * @param destination the class that there is an instance of
     */
    public Instance(ClassInfo origin, ClassInfo destination){
        this.origin = origin;
        this.destination = destination;
        label = null;
        stereotype = null;
    }

    /**
     * Non-default constructor with all parameters supplied.
     * @param origin the class that has an instance of the other class
     * @param destination the class that there is an instance of
     * @param label the label for the instance relationship
     */
    public Instance(ClassInfo origin, ClassInfo destination, String label){
        this(origin, destination);
        this.label = label;
        stereotype = null;
    }

    /**
     * gets origin of Instance, returns.
     * @return origin of Instance.
     */
    @Override
    public ClassInfo getOrigin() {
        return origin;
    }

    /**
     * sets origin of Instance.
     * @param newOrigin desired origin.
     */
    @Override
    public void setOrigin(ClassInfo newOrigin) {
        origin = newOrigin;
    }

    /**
     * gets label to be displayed for Instance, returns.
     * @return label.
     */
    public String getLabel() {
        return label;
    }

    /**
     * sets label of Instance.
     * @param newLabel desired label.
     */
    public void setLabel(String newLabel) {
        label = newLabel;
    }

    /**
     * gets destination of Instance, returns.
     * @return destination of Instance.
     */
    @Override
    public ClassInfo getDestination() {
        return destination;
    }

    /**
     * sets destination of Instance.
     * @param newDestination desired destination.
     */
    @Override
    public void setDestination(ClassInfo newDestination) {
        destination = newDestination;
    }

    /**
     * gets stereotype of Instance, returns.
     * @return stereotype.
     */
    @Override
    public Stereotype getRelation() {
        return stereotype;
    }

    /**
     * sets stereotype of Instance.
     * @param relation desired stereotype.
     */
    @Override
    public void setRelation(Stereotype relation) {
        this.stereotype = relation;
    }

    /**
     * @return a complete representation of the Instance class.
     */
    @Override
    public String getInfo(){
        return "Instance relationship:\n" + "Origin:\n" +
                origin.getInfo() + "\n" +
                "Destination:\n" +
                destination.getInfo() + "\n" +
                "Stereotype: " +
                stereotype.getInfo() + "\n" +
                "Label: " + label + "\n";
    }

    /**
     * a boolean function to determine whether this Instance relationship has a stereotype
     * @return true if stereotype exists, otherwise false
     */
    @Override
    public boolean hasStereotype() {
        return stereotype != null;
    }

    /**
     * @return a String that shows the complete information about an instance.
     */
    public String toString() {
        return "An instance relationship where " + origin.getClassName() + " is an instance of " + destination.getClassName();
    }

}
