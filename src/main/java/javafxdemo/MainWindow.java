package javafxdemo;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class MainWindow extends Application {

    public static void main(String[] args) {
        launch(args);
    }

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

//        VBox vBox = new VBox(10, new Label("A JavaFX Label"));
//        Scene scene = new Scene(vBox);
//        vBox.getChildren().add(new Label("another label?"));
//        vBox.getChildren().add(new Label("perhaps yet another label in this window?"));
//        vBox.getChildren().add(new Label("what would you say if I proposed adding a fourth label to the window " +
//                "at which you are currently gazing?"));
//        vBox.getChildren().add(button);
//        vBox.getChildren().add(new Label("ah, i see, you would say hello world. good choice"));
//        String cssLayout = "-fx-border-color: pink;\n" +
//                "-fx-border-insets: 0;\n" +
//                "-fx-border-width: 10;\n" +
//                "-fx-border-style: solid;\n";
//        vBox.setStyle(cssLayout);

        Rectangle rectangle1 = new Rectangle(0,0,200,300);
        rectangle1.setArcHeight(50);
        rectangle1.setArcWidth(50);
        rectangle1.setFill(Paint.valueOf("pink"));
        Group root = new Group(rectangle1);
        Scene scene = new Scene(root, 1200, 600);

        Rectangle rectangle2 = new Rectangle(150,0,150,200);
        rectangle2.setFill(Paint.valueOf("olive"));
        rectangle2.setArcWidth(50);
        rectangle2.setArcHeight(100);
        root.getChildren().add(rectangle2);

        Button button1 = new Button("button1");
        button1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("oh god button1 was pressed!");
            }
        });
        button1.setTextFill(Paint.valueOf("red"));

        Button button2 = new Button("button2");
        button2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                System.out.println("gee whiz you sure pressed button2");
            }
        });
        button2.setCursor(Cursor.CLOSED_HAND);

        VBox newVbox = new VBox(10);
        newVbox.getChildren().add(new Label("menu"));
        newVbox.getChildren().add(button);
        newVbox.getChildren().add(button1);
        newVbox.setLayoutX(10);
        newVbox.setLayoutY(10);

        root.getChildren().add(newVbox);

        Circle circle = new Circle();
        circle.setCenterX(225);
        circle.setCenterY(100);
        circle.setRadius(50);
        root.getChildren().add(circle);

        Circle circle1 = new Circle();
        circle1.setCenterX(500);
        circle1.setCenterY(200);
        circle1.setRadius(150);
        circle1.setFill(Paint.valueOf("turquoise"));
        root.getChildren().add(circle1);

        HBox hBox = new HBox(10);
        hBox.getChildren().add(new Label("hBox!"));
        Rectangle tinyRectangle = new Rectangle(10,10);
        tinyRectangle.setFill(Paint.valueOf("fuchsia"));
        hBox.getChildren().add(tinyRectangle);
        hBox.getChildren().add(button2);
        Circle tinyCircle = new Circle(10);
        tinyCircle.setFill(Paint.valueOf("chartreuse"));
        hBox.getChildren().add(tinyCircle);
        hBox.setLayoutX(15);
        hBox.setLayoutY(350);
        root.getChildren().add(hBox);

        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();

//        StackPane root = new StackPane();
//        root.getChildren().add(button);
//        Label label = new Label("Hello World");
//        label.setTranslateX(100);
//        Scene scene = new Scene(label, 300, 400);
//        primaryStage.setScene(scene);
//        primaryStage.setScene(new Scene(root, 300, 250));
//        primaryStage.show();
    }
}
