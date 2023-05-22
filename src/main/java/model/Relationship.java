package model;

/**
 * A Java interface that handles different types of relations
 * between class diagrams. Mainly, there are delegation, subtyping,
 * and containment. In our project, we use inheritance to mean
 * subtyping and instance for containment.
 * @author Brendan Pritkin, Tyler Nass, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public interface Relationship{
    ClassInfo getOrigin();
    ClassInfo getDestination();
    void setOrigin(ClassInfo newOrigin);
    void setDestination(ClassInfo newDestination);
    Stereotype getRelation();
    void setRelation(Stereotype relation);
    String getInfo();
    boolean hasStereotype();
}
