package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import java.util.Scanner;

public class Main extends Application {
    public static String symb;
    public static int keyCode;
    Field field = new Field();
    Group group=new Group();
    Canvas canvas=new Canvas();

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Scene scene=new Scene(root, 600, 500);
        scene.getRoot().requestFocus();
        primaryStage.setScene(scene);
        primaryStage.setTitle("2048_game");
        primaryStage.show();
    }

    public static void main(String[] args) throws InterruptedException {
        launch(args);
        }
    public void init(){
            field.initialize();
    }
    public static int keyPressed(String s) {
            switch (s){
                case"w":
                  return 38;
                case"a":
                    return 37;
                case"d":
                    return 39;
                case"s" :
                    return 40;
            }
            return 0;
    }

}


