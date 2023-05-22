package controller;

/**
 * Interface which assists in implementing Undo/Redo functions for menu bar.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public interface Command
{
    void execute();
    void undo();
    void redo();
}
