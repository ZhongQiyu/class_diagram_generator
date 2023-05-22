package javafxdemo;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.SeparatorMenuItem;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

/**
 * A Java class that gives a demonstration of the border pane.
 */
public class BorderPaneDemo extends Application {

    private Label response;

    public static void main(String[] args) {
        launch(args);/*from   w  w w . ja va  2 s .  c  om*/
    }

    public void start(Stage myStage) {
        myStage.setTitle("Menus from java2s.com");

        // Use a BorderPane for the root node.
        BorderPane rootNode = new BorderPane();

        Scene myScene = new Scene(rootNode, 300, 300);

        myStage.setScene(myScene);

        response = new Label("Menu Demo");

        // Create the menu bar.
        MenuBar mb = new MenuBar();

        // Create the File menu.
        Menu fileMenu = new Menu("File");
        MenuItem open = new MenuItem("Open");
        MenuItem close = new MenuItem("Close");
        MenuItem save = new MenuItem("Save");
        MenuItem exit = new MenuItem("Exit");
        fileMenu.getItems().addAll(open, close, save, new SeparatorMenuItem(), exit);
        // Add File menu to the menu bar.
        mb.getMenus().add(fileMenu);

        // Create the Options menu.
        Menu optionsMenu = new Menu("Options");
        // Create the Colors sub menu.
        Menu colorsMenu = new Menu("Colors");
        MenuItem red = new MenuItem("Red");
        MenuItem green = new MenuItem("Green");
        MenuItem blue = new MenuItem("Blue");
        colorsMenu.getItems().addAll(red, green, blue);
        optionsMenu.getItems().add(colorsMenu);
        // Create the Priority sub menu.
        Menu priorityMenu = new Menu("Priority");
        MenuItem high = new MenuItem("High");
        MenuItem low = new MenuItem("Low");
        priorityMenu.getItems().addAll(high, low);
        optionsMenu.getItems().add(priorityMenu);
        // Add a separator. Separate the Colors and Priority sub menu.
        optionsMenu.getItems().add(new SeparatorMenuItem());
        // Create the Reset menu item. Add it to the Options menu.
        MenuItem reset = new MenuItem("Reset");
        optionsMenu.getItems().add(reset);
        // Add Options menu to the menu bar.
        mb.getMenus().add(optionsMenu);

        // Create the Help menu.
        Menu helpMenu = new Menu("Help");
        MenuItem about = new MenuItem("About");
        helpMenu.getItems().add(about);
        // Add Help menu to the menu bar.
        mb.getMenus().add(helpMenu);

        // the response label to the center position.
        rootNode.setTop(mb);
        rootNode.setCenter(response);

        myStage.show();
    }


}
