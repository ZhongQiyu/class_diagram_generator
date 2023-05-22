package javafxdemo;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.canvas.Canvas;
import javafx.scene.paint.Paint;
import model.*;

import java.util.ArrayList;

/**
 * A Java class that model the window that handles everything
 * to show on the screen.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class DisplayDemo {

    Paint windowFillColor; //window background color
    Paint lineWidth; //width of border
    Paint font; //font for text
    Paint textAlignChoice; //align text Left/Center/Right
    ArrayList<Diagram> diagrams = new ArrayList<>();

    /**
     * Default constructor of a panel window.
     */
    public DisplayDemo() {
        this.windowFillColor = null;
        this.lineWidth = null;
        this.font = null;
        this.textAlignChoice = null;
        this.diagrams = null;
    }

    /**
     * A non-default constructor of a panel window.
     * @param windowFillColor the filling color that makes the window a bit different.
     * @param lineWidth the width of the lines that are separately working.
     * @param font the font that the text applied for display.
     * @param textAlignChoice the choice of alignment through the time.
     * @param diagrams the diagrams that make a bit further
     */
    public DisplayDemo(Paint windowFillColor, Paint lineWidth, Paint font, Paint textAlignChoice, ArrayList<Diagram> diagrams) {
        this.windowFillColor = windowFillColor;
        this.lineWidth = lineWidth;
        this.font = font;
        this.textAlignChoice = textAlignChoice;
        this.diagrams = diagrams;
    }

    /**
     * set window background color.
     * @param windowFillColor desired window background color.
     */
    private void setFill(Paint windowFillColor){
        DisplayDemo.setBackgroundColor("Blue");
    }

    /**
     * set window background color.
     * @param desiredColor desired background color
     * @return Paint variable for use in built-in Paint setFill method.
     */
    public static Paint setBackgroundColor(String desiredColor){
        Paint backgroundColor = Paint.valueOf(desiredColor);
        return backgroundColor;
    }

    /**
     * @return the diagrams stored for visualizing the window.
     */
    public ArrayList<Diagram> getDiagrams() {
        return diagrams;
    }

    /**
     * Load a single diagram from the collection of diagrams.
     * @param index: the index of the diagram to retrieve from the collection.
     */
    public void loadDiagram(int index, int canvasWidth, int canvasHeight) {
        Diagram toLoad = this.getDiagrams().get(index);
        ArrayList<ClassInfo> classes = (ArrayList<ClassInfo>) toLoad.getClasses();
        ArrayList<Relationship> relationships = (ArrayList<Relationship>) toLoad.getRelationships();
        for(ClassInfo info: classes) {
            String className = info.getClassName();

            ArrayList<Method> methods = (ArrayList<Method>) info.getMethods();

            ArrayList<model.Variable> instanceVariables = (ArrayList<model.Variable>) info.getInstanceVariables();

            Coordinate location = info.getLocation();
            double xLoc = (double) location.getX();
            double yLoc = (double) location.getY();

            Stereotype stereotype = info.getStereotype();

            Canvas basement = new Canvas();
            GraphicsContext context = basement.getGraphicsContext2D();
            context.strokeText(info.toString(), xLoc, yLoc);
        }
    }

    /**
     * Driver function of the panel window class.
     * @param args
     */
    public static void main(String[] args) {
        DisplayDemo window = new DisplayDemo();
        window.loadDiagram(1, 300, 300);
    }

}
