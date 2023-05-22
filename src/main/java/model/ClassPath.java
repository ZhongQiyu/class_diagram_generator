package model;


import java.awt.*;
import java.awt.geom.*;

/**
 * Model class storing the coordinates for a class and other relevant info.
 * @author Brendan Pritikin, Tyler Nass, Qiyu "Allen" Zhong
 * @version 1.0
 */
public class ClassPath
{
    private GeneralPath thePath;
    //add variables for other types of data to store.

    /**
     * A non-default constructor that puts up the general class path.
     * @param thePath the general class path for the whole diagram to implement.
     */
    public ClassPath(GeneralPath thePath)
    {
        this.thePath = thePath;
    }

    /**
     * @return the path that is included and embedded in the path of the class.
     */
    public GeneralPath getGeneralPath()
    {
        return thePath;
    }

}
