package javafxdemo;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Scene;

import static javafx.application.Application.launch;

/**
 * A demo of the BooleanProperty class that aims for setting up
 * the control logic for the whole program.
 */
public class BooleanPropertyDemo {

    private BooleanProperty booleanProperty = new SimpleBooleanProperty(true);

    public static void main(String[] args) {
        launch(args);
    }

    public void myFunc() {
        System.out.println("Hello World");
    }

    public void start(Stage primaryStage) {

        // Add change listener
        booleanProperty.addListener(new ChangeListener<Boolean>() {
            @Override
            public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
                System.out.println("changed " + oldValue + "->" + newValue);
                myFunc();
            }
        });

        Button btn = new Button();
        btn.setText("Toggle boolean flag");
//        btn.setOnAction(new EventHandler("", "", "", "") {
//            public void handle(ActionEvent event) {
//                booleanProperty.set(!booleanProperty.get()); //toggle
//                System.out.println("toggled to " + booleanProperty.get());
//            }
//        });

        // Bind to another property variable
        btn.underlineProperty().bind(booleanProperty);

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 300, 250));
        primaryStage.show();
    }

    public boolean getFlag() {
        return booleanProperty.get();
    }

    public void setFlag(boolean val) {
        booleanProperty.set(val);
    }

}
