package javafxdemo;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import javafx.scene.paint.*;
import javafx.scene.shape.*;

/**
 * A Java demo class that tries to demonstrate an application that
 * prints a line of 'Hello World' on the screen.
 */
public class HelloWorldDemo extends Application {

    @Override
    public void start(Stage stage) {
        Text text = new Text(40, 40, "Hello World!");
        text.setFont(new Font(40));
        Scene scene = new Scene(new Group(text));

        stage.setTitle("Welcome to JavaFX!");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();
    }

    /**
     * A test method that runs the group code that aggregates the
     * boxes together, to display on the screen.
     */
    public void runGroup() {
        Group g = new Group();
        for (int i = 0; i < 5; i++) {
            Rectangle r = new Rectangle();
            r.setY(i * 20);
            r.setWidth(100);
            r.setHeight(10);
            r.setFill(Color.RED);
            g.getChildren().add(r);
        }
    }

    /**
     * The driver function of the hello world.
     * @param args the arguments for launching the application.
     */
    public static void main(String[] args) {
        Application.launch(args);
        HelloWorldDemo testApp = new HelloWorldDemo();
        testApp.runGroup();
    }

}
