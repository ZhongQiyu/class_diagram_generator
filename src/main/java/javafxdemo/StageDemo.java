package javafxdemo;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


/**
 A Java class that creates a display window
 of default size and shape. This allows for the display
 of Canvases (Classes) within the window.
 @author Brendan Pritikin, Tyler Nass, Qiyu 'Allen' Zhong
 @version 1.0
 */
public class StageDemo extends Application {

    public String windowTitle;
    public int windowWidth;
    public int windowHeight;
    public int fontSize;
    public PropertyChangeListener signal;
    public Label response;
    // bunch of items over here

    /**
     * default constructor that creates a stage with default parameters.
     */
    public StageDemo() {
        this.windowTitle = "The Rise of Class Diagram Builder Pro";
        this.windowWidth = 600;  // 800
        this.windowHeight = 600;  // 450
        this.fontSize = 75;  // 100
        this.signal = new PropertyChangeListener() {
            @Override
            public void propertyChange(PropertyChangeEvent evt) {

            }
        };
        this.response = new Label("AYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
    }

    /**
     * default constructor creates Stage with locally-set values.
     * @param windowTitle title bar text
     * @param windowWidth window width
     * @param windowHeight window height
     * @param fontSize size of title font
     * @param response the text to display in the center of the window
     */
    public StageDemo(String windowTitle, int windowWidth, int windowHeight,
                     int fontSize, Label response) {
        this.windowTitle = windowTitle;
        this.windowWidth = windowWidth;
        this.windowHeight = windowHeight;
        this.fontSize = fontSize;  // should we define this locally?
        this.response = response;
    }

    /**
     * @return the title of the window.
     */
    public String getWindowTitle() { return this.windowTitle; }

    /**
     * @return the width of the window.
     */
    public int getWindowWidth() { return this.windowWidth; }

    /**
     * @return the height of the window.
     */
    public int getWindowHeight() { return this.windowHeight; }

    /**
     * @return the size of the font applied in the window.
     */
    public int getFontSize() { return this.fontSize; }

    /**
     * @return the response of the window
     */

    // setters?

    /**
     * creates and runs JavaFX program with above default window parameters.
     * @param newStage the stage to start the application from.
     */
    public void start(Stage newStage) throws Exception {
        StageDemo viewer = new StageDemo("Hello World Application", 800, 500,
                10, new Label(""));

        ObservableList<String> options = FXCollections.observableArrayList("Option 1", "Option 2", "Option 3");
        final ComboBox<String> comboBox = new ComboBox<>(options);
        comboBox.getItems().addAll("Option 4", "Option 5", "Option 6");

        // Use a BorderPane for the root node.
        BorderPane rootNode = new BorderPane();
        Scene myScene = new Scene(rootNode, viewer.getWindowWidth(), viewer.getWindowHeight());
        newStage.setScene(myScene);
        // Create the menu bar.
        MenuBar mb = new MenuBar();
        // Create the File menu.
        Menu fileMenu = new Menu("File");
        MenuItem create = new MenuItem("New");
        MenuItem open = new MenuItem("Load");
        MenuItem save = new MenuItem("Save");
        MenuItem close = new MenuItem("Export");
        MenuItem exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(open, close, save, new SeparatorMenuItem(), exit);
        // Add File menu to the menu bar.
        mb.getMenus().add(fileMenu);

        Menu optionMenu = new Menu("File");

        rootNode.setTop(mb);
        rootNode.setCenter(response);
        newStage.show();
//        Button button = new Button();
//        button.setText("Say Hello World");
//        button.setTranslateX(100);
//        button.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent event) {
//                System.out.println("Hello World");
//            }
//        });
//        Pane root = new Pane();
//        root.getChildren().add(button);
//        newStage.setScene(new Scene(root, viewer.getWindowWidth(), viewer.getWindowHeight()));
//        newStage.setTitle(viewer.getWindowTitle());
//        newStage.sizeToScene();
//        newStage.show(); //display Stage viewer window.
    }

    /**
     * set dimensions of new Stage with passed-in values.
     * @param width width of Stage window
     * @param height height of Stage window
     */
    public void setStageDimensions(int width, int height) {
        this.windowWidth = width;
        this.windowHeight = height;
    }

    /**
     * set Stage (window) title.
     * @param title desired title.
     */
    public void setStageTitle(String title){
        this.windowTitle = title;
    }

    /**
     * set Stage (window) font size.
     * @param fontSize desired font size.
     */
    public void setFontSize(int fontSize){
        this.fontSize = fontSize;
    }

    /**
     * Add a button that can go directly to the screen
     * @param button the button to add.
     */
    public void addButton(Button button) {
        button.setText("Say Hello World");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(button);
    }

    /**
     * Notify the listeners.
     */
    public void notifyObservers(ArrayList<Observable> observers) {
        for(Observable observer: observers) {
            notify();
        }
    }

    /**
     * Driver function of the stage viewer.
     * @param args the arguments to use for launching the application.
     */
    public static void main(String[] args) {
        Application.launch(args);
//        Application.launch(StageViewer.class); // launch the StageViewer class to start the app.
    }

}