package model;

import controller.Memento;
import controller.MementoOriginator;

import java.util.ArrayList;
import java.util.EventListener;
import java.util.Observable;

/**
 * A Java class that models the diagram to use.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class Diagram extends Observable implements MementoOriginator {
    private ArrayList<ClassInfo> classes;
    private ArrayList<Relationship> relationships;
    private EventListener diagramListener;

    /**
     * The default constructor for the class of Diagram.
     */
    public Diagram(){
        this.classes = new ArrayList<ClassInfo>();
        this.relationships = new ArrayList<Relationship>();
        this.diagramListener = new EventListener() {
            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        };
    }

    /**
     * The non-default constructor for the Diagram class.
     * @param classes the classes to get assigned for the diagram.
     * @param relationships the relationships to get included for constructing a diagram.
     */
    public Diagram(ArrayList<ClassInfo> classes, ArrayList<Relationship> relationships) {
        this.classes = classes;
        this.relationships = relationships;
        this.diagramListener = new EventListener() {
            @Override
            public boolean equals(Object obj) {
                return super.equals(obj);
            }
        };
    }

    /**
     * @return the classes stored in the diagram.
     */
    public Iterable<ClassInfo> getClasses() {
        return classes;
    }

    /**
     * @return the set of relationships stored in the diagram.
     */
    public Iterable<Relationship> getRelationships() {
        return relationships;
    }

    /**
     * @return the listener for the diagram class.
     */
    public EventListener getDiagramListener() {
        return this.diagramListener;
    }

    /**
     * @param toAdd the class to add into the class diagram.
     */
    public void addClass(ClassInfo toAdd){
        classes.add(toAdd);
    }

    /**
     * @param toAdd the relationship to add into the class diagram.
     */
    public void addRelationship(Relationship toAdd){
        relationships.add(toAdd);
    }

    /**
     * @param toRemove the class to remove from the class diagram.
     */
    public void removeClass(ClassInfo toRemove){
        classes.remove(toRemove);
    }

    /**
     * @param toRemove the relationship to remove from the class diagram.
     */
    public void removeRelationship(Relationship toRemove){
        relationships.remove(toRemove);
    }

    /**
     *
     * @return a window-wise representation of the diagram.
     */
    public String getInfo(){
        StringBuilder info = new StringBuilder("Diagram:\n");
        info.append("Classes:\n");
        if (classes.isEmpty()){
            info.append("\n");
        } else {
            for (ClassInfo c : classes){
                info.append(c.getInfo()).append("\n");
            }
        }
        info.append("Relationships:\n");
        if (relationships.isEmpty()){
            info.append("\n");
        } else {
            for (Relationship r : relationships){
                info.append(r.getInfo()).append("\n");
            }
        }
        return info.toString();
    }

    /**
     * @return a test-wise representation of the diagram.
     */
    public String toString(){
        StringBuilder toReturn = new StringBuilder("A diagram containing:");
        if (classes.isEmpty() && relationships.isEmpty()){
            toReturn.append("\nnothing");
        }
        if (!classes.isEmpty()){
            toReturn.append("\nClasses:");
            for (ClassInfo c : classes){
                toReturn.append("\n").append(c.toString());
            }
        }
        if (!relationships.isEmpty()){
            toReturn.append("\nRelationships:");
            for (Relationship r : relationships){
                toReturn.append("\n").append(r.toString());
            }
        }
        return toReturn.toString();
    }

    /**
     * @return an Memento object that gets around with the pace of
     * storing the stages of the window.
     */
    @Override
    public Memento getMemento() {
        ArrayList<ClassInfo> classInfoCopies = new ArrayList<ClassInfo>(classes);
        ArrayList<Relationship> relationshipCopies = new ArrayList<Relationship>(relationships);
        return new Memento(classInfoCopies, relationshipCopies);
    }

    /**
     * Set a clear and shape-based Memento object for the diagram.
     * @param memento the memento object that is all-set with information.
     */
    @Override
    public void setMemento(Memento memento) {
        classes.clear();
        relationships.clear();
        classes.addAll(memento.getClassInfos());
        relationships.addAll(memento.getRelationships());
        changed();
    }

    /**
     * Apply the Observer pattern that gets along with the
     * changing diagram. Notify the observers i.e. the DiagramObserver
     * to apply the changes to the theme mainly.
     */
    private void changed(){
        setChanged();
        notifyObservers();
    }

}
