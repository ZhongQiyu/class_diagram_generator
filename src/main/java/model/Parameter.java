package model;

/**
 * A Java class that represents the parameter to use in the project.
 * @author Brendan Pritkin, Tyler Nass, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class Parameter {
    private String name;
    private String type;

    /**
     * A non-default constructor for the parameter to construct.
     * @param name the name of the parameter.
     * @param type the type of the parameter.
     */
    public Parameter(String name, String type){
        this.name = name;
        this.type = type;
    }

    /**
     * @return the name of the parameter.
     */
    public String getName() {
        return name;
    }

    /**
     * @return the type of the parameter.
     */
    public String getType() {
        return type;
    }

    /**
     * @param name the new name for the parameter to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param type the new type for the parameter to set.
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return a complete representation of the parameter.
     */
    public String getInfo(){
        return "Parameter: " + getType() + " " + getName() + "\n";
    }

    /**
     * @return a partial representation of the parameter.
     */
    public String toString(){
        return type.toString() + " " + name.toString();
    }

}
