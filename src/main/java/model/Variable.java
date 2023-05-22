package model;

/**
 * A Java class that models the variable to get
 * stored in a class diagram.
 * @author Brendan Pritkin, Tyler Nass, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class Variable {
    private String name;
    private String type;

    /**
     * Non-default constructor for the variable class.
     * @param type the type of the variable.
     * @param name the name of the variable.
     */
    public Variable(String type, String name){
        this.name = name;
        this.type = type;
    }

    /**
     * @return the name of the variable.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the type of the variable.
     */
    public String getType() { return type; }

    /**
     * @param name the new name of the variable.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param type the new type of the variable.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return a complete representation of the variable.
     */
    public String getInfo(){
        return "Variable: " + getType() + " " + getName() + "\n";
    }
    // the new liners seem to be a bit problematic

    /**
     * @return a partial representation of the variable.
     */
    public String toString(){
        return type + " " + name;
    }

}
