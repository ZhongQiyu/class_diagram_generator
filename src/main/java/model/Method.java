package model;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;

/**
 * A Java class that models for the methods included in a class diagram.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class Method{
    private String methodName; //name of method
    private ArrayList<Parameter> parameters; //list of parameters for method - should also contain type somehow(?)
    private String returnType; //type method returns
    private Note note; //a note about this method - if no note, will be null

    /**
     * A non-default constructor that constructs a method instance.
     * @param methodName the name of the method.
     * @param returnType the type of the method.
     */
    public Method(String methodName, String returnType) {
        this.methodName = methodName;
        this.parameters = new ArrayList<>();
        this.returnType = returnType;
        this.note = null;
    }

    /**
     * A non-default constructor that constructs a method instance.
     * @param methodName the name of the method.
     * @param parameters the type of the method.
     * @param returnType the return type of the method.
     * @param note the note for illustrating the method.
     */
    public Method(String methodName, ArrayList<Parameter> parameters, String returnType, Note note) {
        this.methodName = methodName;
        this.parameters = parameters;
        this.returnType = returnType;
        this.note = note;
    }

    /**
     * @return the name of the method.
     */
    public String getMethodName(){
        return methodName;
    }

    /**
     * @param methodName the new name for the method to get assigned to.
     */
    public void setMethodName(String methodName){
        this.methodName = methodName;
        notifyObservers();
    }

    /**
     * @return the return type of the method.
     */
    public String getReturnType(){
        return returnType;
    }

    /**
     * @param returnType the new return type of method within the class diagram.
     */
    public void setReturnType(String returnType){
        this.returnType = returnType;
        notifyObservers();
    }

    /**
     * @return the note from the class diagram.
     */
    public Note getNote(){
        return note;
    }

    /**
     * @param newNote the new note to illustrate the class diagram.
     */
    public void setNote(Note newNote){
        note = newNote;
        notifyObservers();
    }

    /**
     * @return if the note contains any information yet or not.
     */
    public boolean hasNote(){
        return this.getNote() != null;
    }

    /**
     * Remove the note from the class diagram.
     */
    public void removeNote(){
        this.setNote(null);
        notifyObservers();
    }

    /**
     * The parameter to add for the class diagram.
     * @param paramType the type of the parameter to add.
     * @param paramName the name of the parameter to set.
     */
    public void addParameter(String paramType, String paramName){
        parameters.add(new Parameter(paramName, paramType));
        notifyObservers();
    }

    /**
     * An overloading method of adding the parameter to the method.
     * @param parameter the whole parameter to add.
     */
    public void addParameter(Parameter parameter){
        parameters.add(parameter);
        notifyObservers();
    }

    /**
     * The parameter to remove from the class diagram.
     * @param paramType the type of the parameter for removal.
     * @param paramName the name of the parameter for removal.
     */
    public void removeParameter(String paramName, String paramType){
        for (Iterator<Parameter> iterator = this.getParameters().iterator(); iterator.hasNext();){
            Parameter parameter = iterator.next();
            if (parameter.getName().equals(paramName) && parameter.getType().equals(paramType)){
                iterator.remove();
            }
        }
        notifyObservers();
    }

    /**
     * @return the collection of parameters stored in the method.
     */
    public Iterable<Parameter> getParameters(){
        return parameters;
    }

    /**
     * @return the number of parameters in the method.
     */
    public int parameterCount(){
        return parameters.size();
    }

    /**
     * @return if there is any parameter in the method.
     */
    public boolean hasParameters(){
        return parameterCount() != 0;
    }

    /**
     * Change the name of the method, given a new name.
     * @param name the new name of the method to set.
     */
    public void changeName(String name){
        this.methodName = name;
    }

    /**
     * Notify the subscribers so that they will update their data correspondingly.
     */
    private void notifyObservers(){
        this.notify();//updates subscribers
    }

    /**
     * Change the name of the parameter given a new name.
     * @param paramName the old name of the parameter.
     * @param newParamName the new name of the parameter to set.
     */
    public void changeParamName(String paramName, String newParamName){
        for (Parameter p : parameters) {
            if (Objects.equals(p.getName(), paramName)) {
                p.setName(newParamName);
            }
        }
    }

    /**
     * Change the type of the parameter given a new name.
     * @param paramType the old type of the parameter.
     * @param newParamType the new type of the parameter.
     */
    public void changeParamType(String paramType, String newParamType){
        for (Parameter p : parameters) {
            if (Objects.equals(p.getType(), paramType)) {
                p.setType(newParamType);
            }
        }
    }

    /**
     * @return the representation of a method.
     */
    public String getInfo(){
        StringBuilder info = new StringBuilder("Method: ").append(getMethodName()).append("\n");
        info.append("Return type: ").append(getReturnType()).append("\n");
        info.append("Parameters:\n");
        if (parameters.isEmpty()){
            info.append("\n");
        } else {
            for (Parameter p : parameters){
                info.append(p.getInfo()).append("\n"); // there is already a newline in Parameter.toString()
            }
        }
        info.append("Note");
        if (note == null){
            info.append("\n");
        } else {
            info.append(note.getInfo()).append("\n");
        }
        return info.toString();
    }

    /**
     * @return a partial representation of the method.
     */
    public String toString(){
        StringBuilder toReturn = new StringBuilder("Method: " + getReturnType() + " " + getMethodName());
        if (!parameters.isEmpty()){
            toReturn.append("\n").append("with parameters:");
            for (Parameter p : parameters){
                toReturn.append("\n").append(p.toString());
            }
        }
        if (note != null){
            toReturn.append("\n").append("With ").append(note);
        }
        return toReturn.toString();
    }

}
