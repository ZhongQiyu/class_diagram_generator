package view;

import javafx.event.EventHandler;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import model.Coordinate;

/**
 * A Java class that aims for modeling a window that is able
 * to get dragged.
 * @author Tyler Nass, Brendan Pritikin, Qiyu 'Allen' Zhong
 * @version 1.0
 */
public class DraggableWindow {

    /**
     * Drag a window around the corner so that they would be able to
     * float around the panel.
     * @param scene the Scene to drag the window around with.
     * @param newPos the new position to drag the window to.
     */
    public void dragWindow(Scene scene, Coordinate newPos) {
        // drag the window to a different location
    }

    /**
     * Add a node to the window so that it would be able to get dragged.
     * @param node the Node to set in the builder.
     */
    private void addDraggableNode(final Node node) {
        node.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                if (me.getButton() != MouseButton.MIDDLE) {
                    double initialX = 0;
                    double initialY = 0;
                    initialX = me.getSceneX();
                    initialY = me.getSceneY();
                    // think about the usage of dragging
                    // while using the initialX and initialY
                }
            }
        });
        node.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                if (me.getButton() != MouseButton.MIDDLE) {
                    double initialX = 0;
                    double initialY = 0;
                    node.getScene().getWindow().setX(me.getScreenX() - initialX);
                    node.getScene().getWindow().setY(me.getScreenY() - initialY);
                }
            }
        });
    }

}
