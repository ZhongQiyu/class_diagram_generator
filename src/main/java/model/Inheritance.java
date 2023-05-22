package model;

/**
 * A Java class that models the inheritance relation
 * between a class diagram and the other.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class Inheritance implements Relationship{
    private ClassInfo origin, destination;
    private Stereotype relation;

    /**
     * full constructor
     * @param origin the class that has an inheritance
     * @param destination the class being inherited
     */
    public Inheritance(ClassInfo origin, ClassInfo destination){
        this.origin = origin;
        this.destination = destination;
        this.relation = null;
    }

    /**
     * gets origin of class' inheritance, returns.
     * @return origin
     */
    @Override
    public ClassInfo getOrigin(){
        return origin;
    }

    /**
     * gets destination of class' inheritance, returns.
     * @return destination
     */
    @Override
    public ClassInfo getDestination(){
        return destination;
    }

    /**
     * gets stereotype of inheritance, returns.
     * @return Stereotype stereotype.
     */
    @Override
    public Stereotype getRelation() {
        return relation;
    }

    /**
     * sets origin of class' inheritance.
     * @param newOrigin desired new class origin.
     */
    @Override
    public void setOrigin(ClassInfo newOrigin){
        origin = newOrigin;
        notifyObservers();
    }

    /**
     * sets destination of class' inheritance.
     * @param newDestination desired new class destination.
     */
    @Override
    public void setDestination(ClassInfo newDestination){
        destination = newDestination;
        notifyObservers();
    }

    /**
     * sets stereotype of interitance.
     * @param relation desired stereotype.
     */
    @Override
    public void setRelation(Stereotype relation) {
        this.relation = relation;
    }

    /**
     * @return a complete representation of the inheritance relation.
     */
    @Override
    public String getInfo(){
        return "Inheritance relationship:\n" + "Origin:\n" +
                origin.getInfo() + "\n" +
                "Destination:\n" +
                destination.getInfo() + "\n" +
                "Stereotype: " +
                relation.getInfo() + "\n";
    }

    /**
     * a boolean function to determine whether this Inheritance relationship has a stereotype
     * @return true if stereotype exists, otherwise false
     */
    @Override
    public boolean hasStereotype() {
        return relation != null;
    }

    /**
     * @return a partial representation of the inheritance relation.
     */
    public String toString() {
        String toReturn = "An inheritance relationship where " + origin.getClassName() + " inherits " + destination.getClassName();
        if (this.hasStereotype()){
            toReturn += " with stereotype " + this.getRelation();
        }
        return toReturn;
    }

    /**
     * Update subscribers to the inheritance class one by one.
     */
    private void notifyObservers(){
        this.notify();
        //updates subscribers sequentially
    }
}
