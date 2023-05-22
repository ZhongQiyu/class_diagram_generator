package javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;  //导入方法依赖的package包/类
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 * A Java demo class that shows how to add a button to the window.
 *
 */
public class WindowDemoOne extends Application {

    public static final String NEW_GAME= "/Users/allenzhong/Downloads/CSC270/proj3/maxresdefault.jpeg";

    /**
     * Driver function of the tutorial's window.
     * @param args the arguments to launch the application.
     */
    public static void main(String[] args) {
        launch(args);
    }

    /**
     * Driver function that launches the application.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setTitle("Window for application");
        Button button = new Button();
        button.setText("Say Hello World");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("Hello World");
            }
        });
        StackPane root = new StackPane();
        root.getChildren().add(button);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

}
