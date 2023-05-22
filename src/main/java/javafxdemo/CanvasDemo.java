package javafxdemo;

import javafx.scene.paint.Color;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import model.ClassInfo;
import model.Coordinate;

/**
 * A Java Class which models a viewer window (a "Canvas").
 * Canvases will be displayed WITHIN the main window (a "Stage") and filled
 * with class diagram data.
 */
public class CanvasDemo {

    private Canvas canvas;
    public int canvasWidth; //default initial
    public int canvasHeight; //default initial
    private static ClassInfo classLocation; // x- and y-coordinates for class.

    /**
     * default CanvasViewer object. Takes constant size.
     */
    public CanvasDemo() {


        canvas = new Canvas(canvasWidth, canvasHeight); //default instance of canvas dimensions.

        GraphicsContext canvasGraphics = canvas.getGraphicsContext2D(); //allow setting of graphical info.
        canvasGraphics.setFill(Color.BLUE); // background color.
        canvasGraphics.fillRect(50.0, 50.0, 100.0, 100.0); //default class display rectangle dimensions
        canvasGraphics.setStroke(Color.BLACK); //black border
        canvasGraphics.setLineWidth(1.0); //border width

        Coordinate myClassCoordinates = new Coordinate(3, 3); //default for testing with buttons
        ClassInfo classInformationObject = new ClassInfo("myNewClass", myClassCoordinates); //default for testing with buttons

        canvasGraphics.drawImage(null, (int) classInformationObject.getLocation().getX(), (int) classInformationObject.getLocation().getY()); //default for testing with buttons
    }


    /**
     * @return the current canvas of the viewer.
     */
    public Canvas getCanvas() {
        return this.canvas;
    }

    /**
     * set width of Canvas.
     * @param newWidth the new width of the canvas.
     */
    public void setWidth(int newWidth) {
        canvasWidth = newWidth;
    }


    /**
     * returns canvas width.
     * @return width.
     */
    public int getWidth(){
        return this.canvasWidth;
    }

    /**
     * returns canvas height.
     * @return height.
     */
    public int getHeight(){
        return this.canvasHeight;
    }



    /**
     * set height of Canvas.
     * @param newHeight the new height of the canvas.
     */
    public void setHeight(int newHeight) {
        canvas.setHeight(newHeight);
    }


    /**
     * The driver function of the Canvas class.
     * @param args the arguments to include for the mode running in command lines.
     */
    public static void main(String[] args) {

    }

}
