package model;
import java.util.ArrayList;
import java.util.Iterator;


/**
 * A Java class which defines all class instance information.
 * @author Brendan Pritikin, Tyler Nass, Qiyu "Allen" Zhong
 * @version 2.0
 */
public class ClassInfo {
    private String className; // name of the class
    private ArrayList<Method> methods; // list of methods
    private ArrayList<Variable> instanceVariables;
    private Coordinate location; // physical location on screen
    private Stereotype stereotype; // class-defined stereotype ONLY.

    /**
     * Default constructor of the class that displays the information of the class.
     */
    public ClassInfo()
    {
        this.className = "";
        this.methods = new ArrayList<Method>();
        this.instanceVariables = new ArrayList<Variable>();
        this.location = null;
        this.stereotype = null;
    }

    /**
     * Non-default constructor of the class that displays the information of the class.
     * @param className the name of the class to assign with.
     * @param location the location of the stuff to put things around at.
     */
    public ClassInfo(String className, Coordinate location)
    {
        this.className = className;
        this.methods = new ArrayList<Method>();
        this.instanceVariables = new ArrayList<Variable>();
        this.location = location;
        this.stereotype = null;
    }

    /**
     * Non-default constructor of the class that displays the information of the class.
     * @param className the name of the class to assign with.
     * @param x the horizontal location of the stuff to put things around at.
     * @param y the vertical location of the stuff to put things around at.
     */
    public ClassInfo(String className, int x, int y){
        this.className = className;
        this.methods = new ArrayList<>();
        this.instanceVariables = new ArrayList<>();
        this.location = new Coordinate(x,y);
        this.stereotype = null;
    }

    /**
     * gets the name of this class and returns it.
     * @return name of the class
     */
    public String getClassName(){
        return className;
    }

    /**
     * sets the name of this class.
     * @param newClassName this class' new name.
     */
    public void setClassName(String newClassName){
        className = newClassName;
        notifyObservers();
    }

    /**
     * gets current location in x-y plane, returns.
     * @return (x, y) coordinate pair
     */
    public Coordinate getLocation(){
        return location;
    }

    /**
     * shifts class from current position by amount passed-in.
     * @param xShift desired shift on x-axis in relation to current position
     * @param yShift desired shift on y-axis in relation to current position
     */
    public void shiftPosition(int xShift, int yShift){
        location.setX((int) location.getX() + xShift);
        location.setY((int) location.getY() + yShift);
        notifyObservers();
    }

    /**
     * sets (i.e. "moves") class to passed-in x- and y-coordinates.
     * @param xNew new desired position on graph, x-coordinate.
     * @param yNew new desired position on graph, y-coordinate.
     */
    public void setPosition(int xNew, int yNew){
        location.setX(xNew);
        location.setY(yNew);
        notifyObservers();
    }

    /**
     * sets position to the coordinate of the class diagram.
     * @param location new desired location Coordinate
     */
    public void setPosition(Coordinate location){
        this.location = location;
    }

    /**
     * @return the instance variables in the class diagram.
     */
    public Iterable<Variable> getInstanceVariables(){
        return instanceVariables;
    }

    /**
     * creates new instanceVariable for class, updates list of IVs.
     * @param variableType new variable's type
     * @param variableName new variable's name
     */
    public void addInstanceVariable(String variableType, String variableName){
        instanceVariables.add(new Variable(variableType, variableName));
    }

    /**
     * add a new instance variable to the list of variables
     * in the collection of class information.
     * @param newVar the new variable to add to the list.
     */
    public void addInstanceVariable(Variable newVar) {
        instanceVariables.add(newVar);
    }

    /**
     * removes an instance variable requested, if it exists.
     * @param variableType the type of the variable.
     * @param variableName the name of the variable.
     */
    public void removeInstanceVariable(String variableType, String variableName)
    {
        for (Iterator<Variable> iterator = this.getInstanceVariables().iterator(); iterator.hasNext();){
            Variable variable = iterator.next();
            if (variable.getName().equals(variableName)){
                iterator.remove();
            }
        }
        //Instance variable does not exist! Exiting without doing anything.
    }

    /**
     * Remove the instance variables stored in the class.
     */
    public void removeInstanceVariable(Variable var) {
        removeInstanceVariable(var.getType(), var.getName());
    }

    /**
     * @return the collection of methods included in the class diagram.
     */
    public Iterable<Method> getMethods(){
        return methods;
    }

    /**
     * Add a method to show in the class info
     * @param method the method of adding the method.
     */
    public void addMethod(Method method){
        methods.add(method);
    }

    /**
     * Remove a method from the class diagram, given its name.
     * @param methodName the name of the method to remove.
     */
    public void removeMethod(String methodName){
        for (Iterator<Method> iterator = this.getMethods().iterator(); iterator.hasNext();){
            Method method = iterator.next();
            if (method.getMethodName().equals(methodName)){
                iterator.remove();
            }
        }
    }

    /**
     * gets contents of stereotype, returns.
     * @return string of stereotype's contents
     */
    public Stereotype getStereotype() {
        return stereotype;
    }

    /**
     * sets contents of stereotype.
     * @param stereotype desired stereotype for class
     */
    public void setStereotype(Stereotype stereotype) {
        this.stereotype = stereotype;
    }

    /**
     * removes stereotype by setting stereotype to null
     */
    public void removeStereotype(){
        setStereotype(null);
    }

    /**
     * @return if there is anything in the stereotype.
     */
    public boolean hasStereotype(){
        return this.getStereotype() != null;
    }

    /**
     * Update the subscribers to the class of ClassInfo.
     */
    private void notifyObservers(){
        this.notify(); //updates subscribers
    }

    /**
     * A general way of appending the String representation to the classInfo
     * @param currentInfo the representation of the current information to add on.
     * @param infoCollection the collection of information to get around with.
     * @return the information of the whole collection to display.
     */
    private StringBuilder genericGetInfo(StringBuilder currentInfo, ArrayList<?> infoCollection) {
        if (infoCollection.isEmpty()){
            currentInfo.append("\n");
        } else {
            for (Method m : methods){
                currentInfo.append(m.getInfo()).append("\n");
            }
        }
        return currentInfo;
    }

    /**
     * @return a complete representation of a class diagram.
     */
    public String getInfo(){
        StringBuilder info = new StringBuilder("Class: ").append(getClassName()).append("\n");
        info.append("Location: ").append(getLocation()).append("\n");
        info.append("Methods:\n");
        this.genericGetInfo(info, (ArrayList<Method>) this.getMethods());
        info.append("Instance Variables:\n");
        this.genericGetInfo(info, (ArrayList<Variable>) this.getInstanceVariables());
        return info.toString();
    }

    /**
     * @return a partial representation of a class diagram.
     */
    public String toString(){
        StringBuilder toPrint = new StringBuilder("A class called " + getClassName());
        toPrint.append(" located at coordinate ").append(location);
        if (!methods.isEmpty()) {
            toPrint.append("\n").append("containing methods:");
            for (Method m : getMethods()){
                toPrint.append("\n").append(m.toString());
            }
        }
        if (!instanceVariables.isEmpty()){
            toPrint.append("\n").append("containing variables:");
            for (Variable v : getInstanceVariables()){
                toPrint.append("\n").append(v.toString());
            }
        }
        if (stereotype != null){
            toPrint.append("\n").append("with stereotype ").append(stereotype);
        }
        return toPrint.toString();
    }
}
