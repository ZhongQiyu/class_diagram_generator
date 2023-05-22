package model;

/**
A Java class that models the delegation relationship between
a class diagram and another. In general, it would be an relation
that happens between classes, but it reserves the option of
using a method to delegate the other as well.
@author Tyler Nass, Brendan Pritikin, Qiyu (Allen) Zhong
@version 2.0
*/
public class Delegation implements Relationship {
    private ClassInfo delegator;
    private ClassInfo delegatee;
    private Stereotype relation;
    private Method operation;  // --> ArrayList<Method> operations?
    // either Class or Method can delegate

    /**
     Non-default constructor of a Delegation relationship between two class diagrams.
     @param delegator: the origin of delegation.
     @param delegatee: the destination of delegation.
     @param relation: the word that indicates the relation of delegation.
     @param operation: the method that is involved in the relationship of delegation.
     */
    public Delegation(ClassInfo delegator, ClassInfo delegatee, Stereotype relation, Method operation) {
        this.delegator = delegator;
        this.delegatee = delegatee;
        this.relation = relation;
        this.operation = operation;
    }

    /**
     * constructor without operation - operation will be null
     * @param delegator the origin of the delegation
     * @param delegatee the destination of the delegation
     * @param relation a stereotype for the delegation
     */
    public Delegation(ClassInfo delegator, ClassInfo delegatee, Stereotype relation){
        this.delegator = delegator;
        this.delegatee = delegatee;
        this.relation = relation;
        this.operation = null;
    }

    /**
     * constructor without stereotype - stereotype will be null
     * @param delegator the origin of the delegation
     * @param delegatee the destination of the delegation
     * @param operation an operation involved in the relationship
     */
    public Delegation(ClassInfo delegator, ClassInfo delegatee, Method operation){
        this.delegator = delegator;
        this.delegatee = delegatee;
        this.relation = null;
        this.operation = operation;
    }

    /**
     * a constructor without stereotype or operation - both will be null
     * @param delegator the origin of the delegation
     * @param delegatee the destination of the delegation
     */
    public Delegation(ClassInfo delegator, ClassInfo delegatee){
        this.delegator = delegator;
        this.delegatee = delegatee;
        this.relation = null;
        this.operation = null;
    }


    /**
     * @return the operation that is involved in the relationship of delegation.
     */
    public Method getOperation() {
        return this.operation;
    }


    /**
     * @param newOperation the new operation to set for the relationship of delegation.
     */
    public void setOperation(Method newOperation) {
        this.operation = newOperation;
    }


    /**
     * @param delegator the new delegator to set for the delegation relationship.
     * @param delegatee the new delegatee to set for the delegation relationship.
     * @param stereotype the new stereotype to use for illustrating the delegation relationship.
     * @param operation the new operation to use in the delegation relationship.
     */
    public void delegate(ClassInfo delegator, ClassInfo delegatee, Stereotype stereotype, Method operation) {
        // try to use the default parameters if needed
        this.setOrigin(delegator);
        this.setDestination(delegatee);
        this.setRelation(stereotype);
        this.setOperation(operation);
    }

    // since a method in a class A can delegate another one
    // in the same class, we attempt to overload delegate()
    // public void delegate(Method operation1, Method operation2)

    /**
     * @return a string that indicates the relationship of delegation.
     */
    public String toString() {
        String toReturn = "Delegator: ";
        toReturn += this.delegator.toString();
        toReturn += ", Delegatee: ";
        toReturn += this.delegatee.toString();
        toReturn += ", Stereotype: ";
        if (relation != null){
            toReturn += relation.toString();
        } else {
            toReturn += "No stereotype";
        }
        toReturn += ", Operation: ";
        if (operation != null){
            toReturn += operation.toString();
        } else {
            toReturn += "No operation";
        }
        return toReturn;
    }

    /**
     * @param other the other object to compare identity with.
     * @return true if the classes and the representations are exactly the same, false otherwise.
     */
    public boolean equals(Object other) {
        if(!this.getClass().toString().equals(other.getClass().toString())) {
            return false;
        }
        else {
            return this.toString().equals(other.toString());
        }
    }

    /**
     Return the origin of the relationship.
     */
    @Override
    public ClassInfo getOrigin() {
        return this.delegator;
    }

    /**
     Get the destination of the relationship.
     */
    @Override
    public ClassInfo getDestination() {
        return this.delegatee;
    }

    /**
     * @param newOrigin the new origin of the relationship.
     */
    @Override
    public void setOrigin(ClassInfo newOrigin) {
        this.delegator = newOrigin;
    }

    /**
     * @param newDestination the new destination of the relationship.
     */
    @Override
    public void setDestination(ClassInfo newDestination) {
        this.delegatee = newDestination;
    }

    /**
     * @return the stereotype of the relationship.
     */
    @Override
    public Stereotype getRelation() {
        return this.relation;
    }

    /**
     * @param relation the new stereotype of the relationship to set.
     */
    @Override
    public void setRelation(Stereotype relation) {
        this.relation = relation;
    }

    /**
     * @return a complete representation of the delegation.
     */
    @Override
    public String getInfo(){
        return "Delegation:\n" + "Origin:\n" +
                this.getOrigin().getInfo() + "\n" +
                "Destination:\n" +
                this.getDestination().getInfo() + "\n" +
                "Stereotype: " +
                this.getRelation().getInfo() + "\n" +
                "Method:\n" +
                this.getOperation().getInfo();
    }

    /**
     * a boolean function to determine whether this Delegation relationship has a stereotype
     * @return true if the stereotype exists, otherwise false.
     */
    @Override
    public boolean hasStereotype() {
        return this.getRelation() != null;
    }

    /**
     * The driver function.
     * @param args ignored for now.
     */
    public static void main(String[] args) {

    }

}
