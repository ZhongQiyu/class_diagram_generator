package controller;

import model.Diagram;

/**
 * An abstract Java class that applies the Factory pattern
 * to support the running status of the Command pattern.
 * For this point, it would be enough for all of us to have
 * a foundational understanding of the abstract commands.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
abstract public class AbstractCommand implements Command {

    private Memento memento;
    protected Diagram diagram;

    /**
     * Default constructor of the abstract command class.
     */
    public AbstractCommand(){
    }

    /**
     * A non-default constructor of the abstract command class.
     * Pass in a given diagram to store the information of commands
     * to run.
     * @param diagram the diagram to use for telling the system to run the programs
     */
    public AbstractCommand(Diagram diagram){
        this.diagram = diagram;
    }

    /**
     * Execute the command.
     */
    @Override
    public void execute() {
        this.memento = diagram.getMemento();
        transform();
    }

    /**
     * Change the status of a command.
     * If it is run, then marked as complete.
     */
    abstract protected void transform();

    /**
     * Undo the running status of a command.
     */
    @Override
    public void undo() {
        Memento redoMemento = diagram.getMemento();
        diagram.setMemento(memento);
        memento = redoMemento;
    }

    /**
     * Redo the running status of a command.
     */
    @Override
    public void redo() {
        Memento undoMemento = diagram.getMemento();
        diagram.setMemento(memento);
        memento = undoMemento;
    }

}
