package sample;


import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;

import java.awt.*;

public class Controller {
    @FXML
    private GridPane gridPane;
    private Field field;
    public void initialize(){
       field=new Field();
       field.initialize();
       paint_field();
    }
    @FXML
    public void key_pressed(KeyEvent e){
        System.out.println(e.getCode().getCode());
    }
    public void paint_field(){
        Label label;
        for(int i=0;i<field.getSize();i++){
            for (int j = 0; j < field.getSize(); j++) {
                label=new Label(field.getPole()[i][j].getValue()+"");
                label.setFont(new Font("Cambria",40));
                gridPane.add(label,i,j);
            }
        }
    }

}
