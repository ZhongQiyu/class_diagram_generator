package model;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.Group;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.control.MenuBar;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;

/**
 * A Java class that aims for building a reader-writer
 * of image-based files.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class FileIO extends Application{

    private final String filePath;

    /**
     * A non-default constructor that aims for putting up the file reader-writer.
     * @param filePath the path that directs to the image and file to load.
     */
    public FileIO(String filePath){
        this.filePath = filePath;
    }

    /**
     * The starting function for the reader-writer.
     * @param newStage the main window to catch up with for putting up the contents.
     */
    @Override
    public void start(Stage newStage)
    {
        // set up the image for import/export
        String imageURL = "/Users/allenzhong/Downloads/CSC270/proj3/maxresdefault.jpeg";
        Image image = new Image(imageURL);
        ImageView imageViewer = new ImageView(imageURL);
        imageViewer.setFitHeight(30);
        imageViewer.setFitWidth(30);
        Menu file = new Menu("File");
        MenuItem item = new MenuItem("Save...", imageViewer);
        file.getItems().addAll(item);
        //make new file chooser
        FileChooser chooseFile = new FileChooser();
        chooseFile.setTitle("Save...");
        chooseFile.getExtensionFilters().addAll(new ExtensionFilter("All file types", "****"));
        //allow actions on menu item
        item.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                //open save dialog box
                chooseFile.showSaveDialog(newStage);
            }
        });
    }

    /**
     * Create a new file for the reader-writer.
     */
    public void newFile(){
        try {
            java.io.File file = new java.io.File(filePath);
            if (file.createNewFile()){
                System.out.println("File Created: " + file.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Given a diagram that stores information to extract out from,
     * write the diagram so that the writing function can realize
     * its goal.
     * @param diagramToSave the diagram to save from the morning.
     */
    public void writeToFile(Diagram diagramToSave){
        try {
            FileWriter writer = new FileWriter(filePath);
            writer.write(diagramToSave.getInfo());
            writer.close();
            System.out.println("Successfully wrote to file");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * Read file from a source indicated externally.
     */
    public void readFile(){
        try {
            File file = new File(filePath);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String data = scanner.nextLine();
                if (Objects.equals(data, "Diagram:")){
                    Diagram diagram = new Diagram();
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    /**
     * The driver function that launches the application.
     * @param args the arguments that are passed and needed for the Application.
     */
    public static void main(String[] args) {
        launch(args);
    }

}
