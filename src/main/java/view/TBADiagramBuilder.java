package view;

import javafx.application.Application;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.input.*;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Line;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import model.*;

import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.util.ArrayList;
import java.util.Random;

/**
 * A Java class that attempts to model a diagram builder.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class TBADiagramBuilder extends Application {
    private final int MENU_WIDTH = 200;
    private final int WINDOW_WIDTH = 1200;
    private final int WINDOW_HEIGHT = 600;
    private final Coordinate POSITION = new Coordinate(0, 0);
    private String backgroundColor = "white"; //background color of main display
    private String baseColor = "black"; //color of text & lines on main display
    private String menuColor = "lavender"; //background color of menu display
    private String menuBaseColor = "black"; //color of text on menu display
    private ArrayList<Button> buttons = new ArrayList<>();
    private Diagram diagram = new Diagram();
    private final BooleanProperty dragModeActiveProperty =
            new SimpleBooleanProperty(this, "dragModeActive", true);

    /**
     * @return the width of the menu.
     */
    private int getMENU_WIDTH() {
        return MENU_WIDTH;
    }

    /**
     * @return the width of the window.
     */
    private int getWINDOW_WIDTH() {
        return WINDOW_WIDTH;
    }

    /**
     * @return the height of the window.
     */
    private int getWINDOW_HEIGHT() {
        return WINDOW_HEIGHT;
    }

    /**
     * @return the horizontal location of the window.
     */
    private Coordinate getPOSITION() { return POSITION; }

    /**
     * @return the background color of the main window.
     */
    public String getBackgroundColor() {
        return this.backgroundColor;
    }

    /**
     * @return the color of text and lines in the main window.
     */
    public String getBaseColor() {
        return this.baseColor;
    }

    /**
     * @return the background color of the menu.
     */
    public String getMenuColor() {
        return this.menuColor;
    }

    /**
     * @return the color of text in the menu.
     */
    public String getMenuBaseColor() {
        return this.menuBaseColor;
    }

    /**
     * @return the buttons that are available throughout the whole
     */
    public ArrayList<Button> getButtons() { return this.buttons; }

    /**
     * @return the contents stored in the diagram.
     */
    public Diagram getDiagram() { return this.diagram; }

    /**
     * @return the mode that indicates whether the dragging mode is going on.
     */
    public BooleanProperty getDragModeActiveProperty() { return this.dragModeActiveProperty; }

    /**
     * Return the button that is available throughout the storage.
     * Given a name to return, get the mapped and direct instance
     * from the instance.
     * @param name the name of the button to retrieve.
     * @return the button that has the name passed in.
     */
    public static Button getButton(String name) {
        TBADiagramBuilder window = new TBADiagramBuilder();
        ArrayList<Button> buttons = window.getButtons();
        for(Button button: buttons) {
            if(button.getText().equals(name)) {
                return new Button(button.getText());
            }
        }
        return null;
    }

    /**
     * The properties needed for invoking the options for the mouse.
     */
    private static final class MouseContext {
        public double mouseAnchorX;
        public double mouseAnchorY;
        public double initialTranslateX;
        public double initialTranslateY;
    }

    /**
     * A Java class that attempts to define the fields
     * required for dragging the Nodes around the window.
     */
    private static final class DragContext {
        public double mouseAnchorX;
        public double mouseAnchorY;
        public double initialTranslateX;
        public double initialTranslateY;
    }

    /**
     * Make a Node to be able to get dragged throughout the theme.
     * @param node the node to enable dragging with
     * @return the node that is able to get dragged.
     */
    private Node makeDraggable(final Node node) {
        final DragContext dragContext = new DragContext();
        final Group wrapGroup = new Group(node);
        wrapGroup.addEventFilter(
                MouseEvent.ANY,
                new EventHandler<MouseEvent>() {
                    public void handle(final MouseEvent mouseEvent) {
                        if (dragModeActiveProperty.get()) {
                            // disable mouse events for all children
                            mouseEvent.consume();
                        }
                    }
                });
        wrapGroup.addEventFilter(
                MouseEvent.MOUSE_PRESSED,
                new EventHandler<MouseEvent>() {
                    public void handle(final MouseEvent mouseEvent) {
                        if (dragModeActiveProperty.get()) {
                            // remember initial mouse cursor coordinates
                            // and node position
                            dragContext.mouseAnchorX = mouseEvent.getX();
                            dragContext.mouseAnchorY = mouseEvent.getY();
                            dragContext.initialTranslateX =
                                    node.getTranslateX();
                            dragContext.initialTranslateY =
                                    node.getTranslateY();
                        }
                    }
                });

        wrapGroup.addEventFilter(
                MouseEvent.MOUSE_DRAGGED,
                new EventHandler<MouseEvent>() {
                    public void handle(final MouseEvent mouseEvent) {
                        if (dragModeActiveProperty.get()) {
                            // shift node from its initial position by delta
                            // calculated from mouse cursor movement
                            node.setTranslateX(
                                    dragContext.initialTranslateX
                                            + mouseEvent.getX()
                                            - dragContext.mouseAnchorX);
                            node.setTranslateY(
                                    dragContext.initialTranslateY
                                            + mouseEvent.getY()
                                            - dragContext.mouseAnchorY);
                        }
                    }
                });

        return wrapGroup;
    }

    /**
     * New file an operation from the previous scheme.
     */
    private void setNewFile(Stage primaryStage, MenuItem undo) {
        undo.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Create New File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Text", "*.txt"),
                        new FileChooser.ExtensionFilter("Rich Text Font", "*.rtf"));
                fileChooser.showSaveDialog(primaryStage);
            }
        });
    }

    /**
     * Import a file.
     */
    private void setImportFile(Stage primaryStage, MenuItem importFile) {
        importFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileToImport = new FileChooser();
                fileToImport.setTitle("Import File");
                fileToImport.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Text (.txt)", "*.txt"),
                        new FileChooser.ExtensionFilter("JSON (.json)", "*.json"),
                        new FileChooser.ExtensionFilter("JPEG (.JPG)", "*.jpeg"));
                fileToImport.showOpenDialog(primaryStage);
                if(fileToImport != null)
                {
                    //write data to file
//                    try(BufferedReader bufferToWrite = new BufferedReader()
                    System.out.println("There's something to save, WOW!");
                }
            }
        });
    }

    /**
     * Export a file.
     */
    private void setExportFile(Stage primaryStage, MenuItem newFile) {
        newFile.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Export New File");
                fileChooser.getExtensionFilters().addAll(
                        new FileChooser.ExtensionFilter("Text (.txt)", "*.txt"),
                        new FileChooser.ExtensionFilter("JSON (.json)", "*.json"),
                        new FileChooser.ExtensionFilter("JPEG (.JPG)", "*.jpeg"));
                fileChooser.showSaveDialog(primaryStage);
            }
        });
    }

    /**
     * Closes window. Does NOT offer save first.
     */
    private void setExitApp(Stage primaryStage, MenuItem exitApplication) {
        exitApplication.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                primaryStage.close();
            }
        });
    }

    /**
     * A helper that generates the menu bar of the stuff.
     * @param primaryStage the primary window to work on for the window.
     * @return a MenuBar object that includes all the menu options to put on the window.
     */
    private MenuBar getMenuBar(Stage primaryStage) {
        // create the File menu, its list items, and add.
        Menu fileMenu = new Menu("File");
        MenuItem importFile = new MenuItem("Import");
        MenuItem exportFile = new MenuItem("Export");
        MenuItem exitApplication = new MenuItem("Exit");
        fileMenu.getItems().add(importFile);
        fileMenu.getItems().add(exportFile);
        fileMenu.getItems().add(exitApplication);
        // create the Edit menu, its list items, and add.
        Menu editMenu = new Menu("Edit");
        MenuItem createFile = new MenuItem("Create");
        MenuItem dragFile = new MenuItem("Drag");
        MenuItem undo = new MenuItem("Undo");
        MenuItem redo = new MenuItem("Redo");
        editMenu.getItems().add(createFile);
        editMenu.getItems().add(dragFile);
        editMenu.getItems().add(undo);
        editMenu.getItems().add(redo);
        // create the Theme menu for the user to switch themes
        Menu themeMenu = new Menu("Theme");
        MenuItem defaultTheme = new MenuItem("Default");
        MenuItem darkTheme = new MenuItem("Night");
        themeMenu.getItems().add(defaultTheme);
        themeMenu.getItems().add(darkTheme);
        // create the Help menu, its list items, and add.
        Menu helpMenu = new Menu("Help");
        MenuItem helpNotAvailable = new MenuItem("Help? HA.. no help in this app.");
        helpMenu.getItems().add(helpNotAvailable);
        // add actions to each item in all menus:
        setExportFile(primaryStage, exportFile);
        setImportFile(primaryStage, importFile);
        setExitApp(primaryStage, exitApplication);
        setNewFile(primaryStage, undo);
        //create the menu bar with the above criteria.
        MenuBar menuBar = new MenuBar();
        //add all menus to that menu bar.
        menuBar.getMenus().addAll(fileMenu, editMenu, themeMenu, helpMenu);
        return menuBar;
    }

    /**
     * Set the menu for the window.
     * @param menuBar the MenuBar with all essential user options included.
     * @param root the Group to include the background and the bar.
     * @return the Group with everything all set.
     */
    private Group getMenu(MenuBar menuBar, Group root) {
        // set up a Group object that handles all operations
        // indicated in the expected API of the Project
        Group menu = new Group();
        Rectangle menuBackground = new Rectangle(this.getMENU_WIDTH(), this.getWINDOW_HEIGHT());
        menuBackground.setFill(Paint.valueOf(this.getMenuColor()));
        menu.getChildren().addAll(menuBackground, menuBar);
        root.getChildren().add(menu);
        return menu;
    }

    /**
     * Set up the collection of options that the users can deal with.
     * @param options the raw set of options for the users.
     * @return the collection of user's options in the window's operation.
     */
    private ComboBox<Button> getUserOptions(ArrayList<String> options) {
        ComboBox<Button> userOptions = new ComboBox<>();
        ArrayList<Button> buttonOptions = new ArrayList<>();
        for(String option: options) {
            buttonOptions.add(new Button(option));
        }
        userOptions.getItems().addAll(buttonOptions);
        return userOptions;
    }

    /**
     * The driver function of the AnotherWindow application.
     * @param primaryStage the first window to get things around with in a direct manner.
     * @throws Exception an Exception if an error is caught at the runtime.
     */
    @Override
    public void start(Stage primaryStage) throws Exception {
        // set up the basic information for the window
        double windowWidth = this.getWINDOW_WIDTH();
        double windowHeight = this.getWINDOW_HEIGHT();
        primaryStage.setTitle("Class Diagram Tool TBA");
        // create the File menu, its list items, and add.
        MenuBar optionBar = this.getMenuBar(primaryStage);

        // create three class diagrams
        ClassInfo class1 = new ClassInfo("Class1",new Coordinate(0,0));
        ClassInfo class2 = new ClassInfo("Class2",new Coordinate(200,200));
        ClassInfo class3 = new ClassInfo("Class3",new Coordinate(400,0));
        // create the methods to add into the classes
        Method method = new Method("foo","int");
        Method method1 = new Method("bar","float");
        class1.addMethod(method);
        class2.addMethod(method1);
        class2.addMethod(method);
        // create the variables to add into the classes
        Variable variable = new Variable("int", "cat");
        class2.addInstanceVariable(variable);
        // create the stereotype for the second class
        class2.setStereotype(new Stereotype("stereotype"));
        // add the processed classes for the diagram builder
        this.getDiagram().addClass(class1);
        this.getDiagram().addClass(class2);
        this.getDiagram().addClass(class3);
        // add the relations between the classes
        this.getDiagram().addRelationship(new Instance(class1, class2));
        this.getDiagram().addRelationship(new Instance(class2, class3, "hello"));

        // create a Group object that clusters the elements
        Group root = new Group();
        Group diagramGroup = new Group();
        diagramGroup.setLayoutX(this.getMENU_WIDTH() + 10);
        diagramGroup.setLayoutY(10);
        root.getChildren().addAll(diagramGroup, optionBar);
        // add a Scene object to represent the window for the background
        Scene scene = new Scene(root, this.getWINDOW_WIDTH(), this.getWINDOW_HEIGHT());
        scene.setFill(Paint.valueOf(this.getBackgroundColor()));
        for (ClassInfo c : diagram.getClasses()){
            diagramGroup.getChildren().add(classToGroup(c));
        }
        for (Relationship r : diagram.getRelationships()){
            diagramGroup.getChildren().add((relationshipToGroup(r)));
        }
        // add a listener to the Scene object for tracking the status at the back end
        scene.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("mouse click detected! "+event.getSource());
            }
        });

        // set up a Group object that handles all operations
        // indicated in the expected API of the Project 2-3
        Group menu = this.getMenu(optionBar, root);

        // add the options for creating, importing, and exporting diagrams
        Label userOptionsLabel = new Label("User Options");
        userOptionsLabel.setLayoutX(10);
        userOptionsLabel.setLayoutY(30);
        userOptionsLabel.setTextFill(Paint.valueOf(this.getMenuBaseColor()));
        ArrayList<String> options = new ArrayList<>();
        options.add("Create");
        options.add("Import");
        options.add("Export");
        options.add("Undo");
        options.add("Redo");
        options.add("Drag");
        ComboBox<Button> userOptions = getUserOptions(options);

        // set up the create button and its behaviors
        Button userCreate = userOptions.getItems().get(0);
        userCreate.setLayoutX(10);
        userCreate.setLayoutY(30);
        userCreate.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                System.out.println("user create!");
                // set up the window of creation
                Label createLabel = new Label("Your Choice - We Do Our Job");
                StackPane createLayout = new StackPane();
                createLayout.getChildren().add(createLabel);
                Scene createWindow = new Scene(createLayout, windowWidth/2, windowHeight/2);
                createLabel.setTranslateX(createWindow.getX());
                createLabel.setTranslateY(createWindow.getY() - createWindow.getHeight()*0.4);
                Stage createStage = new Stage();
                createStage.setTitle("Create a Class Diagram");
                createStage.setScene(createWindow);
                createStage.setX(primaryStage.getX() + primaryStage.getWidth()*0.2);
                createStage.setY(primaryStage.getY() + primaryStage.getHeight()*0.2);
                createStage.show();

                // enable input of class name in the window
                TextField nameField = new TextField();
                nameField.textProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println("Class Name Modified: " + nameField.getCharacters().toString());
                });
                nameField.setPrefWidth(10);
                nameField.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        createStage.close();
                    }
                });
                nameField.setTranslateX(createWindow.getX());
                nameField.setTranslateY(createWindow.getY() - createWindow.getHeight()*0.4);
                nameField.setText("Class Name");
                createLayout.getChildren().add(nameField);
                // enable input of method name in the window
                TextField methodField = new TextField();
                methodField.textProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println("Method Modified: " + methodField.getCharacters().toString());
                });
                methodField.setPrefWidth(10);
                methodField.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        createStage.close();
                    }
                });
                methodField.setTranslateX(createWindow.getX());
                methodField.setTranslateY(createWindow.getY() - createWindow.getHeight()*0.3);
                methodField.setText("Method");
                createLayout.getChildren().add(methodField);
                // enable input of variable name in the window
                TextField variableField = new TextField();
                variableField.textProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println("Variable Modified: " + variableField.getCharacters().toString());
                });
                variableField.setPrefWidth(10);
                variableField.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        createStage.close();
                    }
                });
                variableField.setTranslateX(createWindow.getX());
                variableField.setTranslateY(createWindow.getY() - createWindow.getHeight()*0.2);
                variableField.setText("Variable");
                createLayout.getChildren().add(variableField);
                // enable input of a coordinate in the window
                TextField coordinateField = new TextField();
                coordinateField.textProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println("Coordinate Modified: " + coordinateField.getCharacters().toString());
                });
                coordinateField.setPrefWidth(10);
                coordinateField.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        createStage.close();
                    }
                });
                coordinateField.setTranslateX(createWindow.getX());
                coordinateField.setTranslateY(createWindow.getY() - createWindow.getHeight()*0.1);
                coordinateField.setText("Coordinate");
                createLayout.getChildren().add(coordinateField);
                // enable input of the relations between two classes in the window
                TextField relationField = new TextField();
                relationField.textProperty().addListener((observable, oldValue, newValue) -> {
                    System.out.println("Relation Modified: " + relationField.getCharacters().toString());
                });
                relationField.setPrefWidth(10);
                relationField.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        createStage.close();
                    }
                });
                relationField.setTranslateX(createWindow.getX());
                relationField.setTranslateY(createWindow.getY());
                relationField.setText("Relation");
                createLayout.getChildren().add(relationField);

                // add an exit button
                Button exitButton = new Button();
                exitButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        createStage.close();
                    }
                });
                exitButton.setTranslateX(createWindow.getX() - createWindow.getWidth()*0.05);
                exitButton.setTranslateY(createWindow.getY() + createWindow.getHeight()*0.1);
                exitButton.setText("Exit");
                createLayout.getChildren().add(exitButton);
                // add a change button: modify if same class name, generate otherwise
                Button changeButton = new Button();
                changeButton.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent event) {
                        // create a new diagram for the user's operation;
                        int randomX = new Random().nextInt((int) windowWidth);
                        int randomY = new Random().nextInt((int) windowHeight);
                        ClassInfo newInfo = new ClassInfo(nameField.getText(), new Coordinate(randomX,randomY));
                        String[] methodInfo = methodField.getText().split(" ");
                        newInfo.addMethod(new Method(methodInfo[0], methodInfo[1]));
                        String[] varInfo = variableField.getText().split(" ");
                        newInfo.addInstanceVariable(new Variable(varInfo[0], varInfo[1]));
                        String[] posInfo = coordinateField.getText().split(" ");
                        newInfo.setPosition(Integer.parseInt(posInfo[0]), Integer.parseInt(posInfo[1]));
                        String[] relationInfo = relationField.getText().split(" ");
                        getDiagram().addRelationship(null);
                        diagramGroup.getChildren().add(classToGroup(newInfo));
                        getDiagram().addClass(newInfo);
                    }
                });
                changeButton.setTranslateX(createWindow.getX() + createWindow.getWidth()*0.05);
                changeButton.setTranslateY(createWindow.getY() + createWindow.getHeight()*0.1);
                changeButton.setText("Change");
                createLayout.getChildren().add(changeButton);
            }
        });

        menu.getChildren().add(userCreate);

        // set up the import button and its behaviors
        Button userImport = userOptions.getItems().get(1);
        userImport.setLayoutX(10);
        userImport.setLayoutY(60);
        menu.getChildren().add(userImport);

        // set up the export button and its behaviors
        Button userExport = userOptions.getItems().get(2);
        userExport.setLayoutX(10);
        userExport.setLayoutY(90);
        menu.getChildren().add(userExport);

        // set up the undo button and its behaviors
        Button userUndo = userOptions.getItems().get(3);
        userUndo.setLayoutX(10);
        userUndo.setLayoutY(120);
        menu.getChildren().add(userUndo);

        // set up the redo button and its behaviors
        Button userRedo = userOptions.getItems().get(4);
        userRedo.setLayoutX(10);
        userRedo.setLayoutY(150);
        menu.getChildren().add(userRedo);

        // set up the drag button and its behaviors
        Button userDrag = userOptions.getItems().get(5);
        userDrag.setLayoutX(10);
        userDrag.setLayoutY(180);
        menu.getChildren().add(userDrag);

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    /**
     * Make each element inside a class diagram to be in the Group object
     * for visualizing them in windows.
     * @param classInfo the class diagram to extract information from.
     * @return the grouped and exposited group to embed in the builder.
     */
    private Group classToGroup(ClassInfo classInfo){
        Group toReturn = new Group();
        VBox vBox = new VBox(3);
        Label classNameLabel = new Label(classInfo.getClassName());
        classNameLabel.setTextFill(Paint.valueOf(baseColor));
        vBox.getChildren().add(classNameLabel);
        if (classInfo.getMethods().iterator().hasNext()){
            Rectangle r = new Rectangle(100,3);
            r.setFill(Paint.valueOf(baseColor));
            vBox.getChildren().add(r);
        }
        for (Method m : classInfo.getMethods()){
            String s = m.getReturnType() + " " + m.getMethodName() + "()";
            Label methodLabel = new Label(s);
            methodLabel.setTextFill(Paint.valueOf(baseColor));
            vBox.getChildren().add(methodLabel);
        }
        if (classInfo.getInstanceVariables().iterator().hasNext()){
            Rectangle r = new Rectangle(100,3);
            r.setFill(Paint.valueOf(baseColor));
            vBox.getChildren().add(r);
        }
        for (Variable v : classInfo.getInstanceVariables()){
            String s = v.getType() + " " + v.getName();
            Label instanceVariableLabel = new Label(s);
            instanceVariableLabel.setTextFill(Paint.valueOf(baseColor));
            vBox.getChildren().add(instanceVariableLabel);
        }
        String cssLayout = "-fx-border-color: " + baseColor + ";\n" +
                "-fx-border-insets: 0;\n" +
                "-fx-border-width: 5;\n" +
                "-fx-border-style: solid;\n";
        vBox.setStyle(cssLayout);
        toReturn.getChildren().add(vBox);
        toReturn.setLayoutX((int) classInfo.getLocation().getX());
        toReturn.setLayoutY((int) classInfo.getLocation().getY());
        if (classInfo.getStereotype() != null){
            Label stereotype = new Label("<<"+classInfo.getStereotype().getLabel()+">>");
            stereotype.setTranslateX(0);
            stereotype.setTranslateY(-20);
            stereotype.setTextFill(Paint.valueOf(baseColor));
            toReturn.getChildren().add(stereotype);
        }
        return toReturn;
    }

    /**
     * Make each element inside a collection of relations to be
     * in the Group object for visualizing them in windows.
     * @param relationship the set of relations to extract information from.
     * @return the grouped and exposited group to embed in the builder.
     */
    private Group relationshipToGroup(Relationship relationship){
        Group toReturn = new Group();
        double startX = relationship.getOrigin().getLocation().getX();
        double startY = relationship.getOrigin().getLocation().getY();
        double endX = relationship.getDestination().getLocation().getX();
        double endY = relationship.getDestination().getLocation().getY();
        Line line = new Line(startX, startY, endX, endY);
        line.setStroke(Paint.valueOf(baseColor));
        if (relationship.getClass() == Instance.class){
            Instance i = (Instance) relationship;
            Label label = new Label(i.getLabel());
            label.setTranslateX((startX + endX)/2.0);
            label.setTranslateY((startY + endY)/2.0);
            label.setTextFill(Paint.valueOf(baseColor));
            toReturn.getChildren().add(label);
        }
        toReturn.getChildren().add(line);
        return toReturn;
    }

}
