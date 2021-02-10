package sample;


import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.awt.*;
import java.util.function.Predicate;

public class Controller {
    @FXML
    private GridPane gridPane;
    private Field field;

    public void initialize() {
        field = new Field();
        field.initialize();
        paint_field();
    }

    @FXML
    public void key_pressed() {
        gridPane.addEventFilter(KeyEvent.KEY_PRESSED, this::handleArrowNavigation);
    }

    public void paint_field() {
        Label label;
        gridPane.getChildren().removeIf(node -> node instanceof Label);
        for (int i = 0; i < field.getSize(); i++) {
            for (int j = 0; j < field.getSize(); j++) {
                label = new Label(field.getPole()[j][i].getValue() + "");
                label.setFont(new Font("Cambria", 40));
                gridPane.add(label, i, j);
            }
        }
    }

    @FXML
    private void handleArrowNavigation(KeyEvent e) {
        System.out.println(e.getCode().getCode());
       field.move(e.getCode().getCode());
        paint_field();
    }
}


