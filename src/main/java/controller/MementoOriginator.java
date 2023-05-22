package controller;

/**
 * A Java interface that shunts the getter and setter
 * of the memento for the class diagrams.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public interface MementoOriginator {
    Memento getMemento();
    void setMemento(Memento memento);
}
