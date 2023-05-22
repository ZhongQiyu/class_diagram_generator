package controller;

import model.ClassInfo;
import model.Relationship;

import java.awt.geom.GeneralPath;
import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * A Java class that helps to implement the Memento pattern
 * for storing the different stages of the diagram builder.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class Memento {

    private ArrayList<ClassInfo> classInfos;
    private ArrayList<Relationship> relationships;

    /**
     * A non-default constructor of the memento object.
     * @param classInfos the information of classes to pass into the memento.
     * @param relationships the relations between classes to pass into the memento.
     */
    public Memento(ArrayList<ClassInfo> classInfos, ArrayList<Relationship> relationships)
    {
        this.classInfos = classInfos;
        this.relationships = relationships;
    }

    /**
     * Set the state of the memento object.
     * @param classInfos the information of classes to pass into the memento.
     * @param relationships the relations of the classes to pass into the memento.
     */
    public void setState(ArrayList<ClassInfo> classInfos, ArrayList<Relationship> relationships){
        this.setClassInfos(classInfos);
        this.setRelationships(relationships);
    }

    /**
     * Set the memento with new information of classes.
     * @param classInfos the new class information to set with.
     */
    public void setClassInfos(ArrayList<ClassInfo> classInfos) {
        this.classInfos = classInfos;
    }

    /**
     * Set the memento with new set of relations of classes.
     * @param relationships the new information of relations to set with.
     */
    public void setRelationships(ArrayList<Relationship> relationships) {
        this.relationships = relationships;
    }

    /**
     * @return the set of class information.
     */
    public ArrayList<ClassInfo> getClassInfos() {
        return classInfos;
    }

    /**
     * @return the set of relations between classes.
     */
    public ArrayList<Relationship> getRelationships()
    {
        return relationships;
    }

}
