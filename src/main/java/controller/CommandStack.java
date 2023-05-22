package controller;

import controller.Command;

import java.util.*;

/**
 * creates a stack for implementing the undo/redo procedure.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class CommandStack
{
    private LinkedList<Command> commandStack = new LinkedList<Command>();
    private LinkedList<Command> redoStack = new LinkedList<Command>();

    /**
     * A method that attempts to run the command
     * from a command that is completely implemented.
     * @param commandGiven the command to run.
     */
    public void execute(Command commandGiven)
    {
        commandGiven.execute();
        commandStack.addFirst(commandGiven);
        redoStack.clear();;
    }

    /**
     * implements the undo operation.
     */
    public void undo()
    {
        if(commandStack.isEmpty())
        {
            return; // nothing to undo.
        }

        Command command = commandStack.removeFirst();
        command.undo();
        redoStack.addFirst(command);
    }

    /**
     * implements the redo operation.
     */
    public void redo()
    {
        if (redoStack.isEmpty())
        {
            return;
        }
        Command command = redoStack.removeFirst();
        command.redo();
        commandStack.addFirst(command);
    }

}
