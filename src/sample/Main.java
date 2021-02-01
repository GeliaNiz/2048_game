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
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.setTitle("2048_game");
        primaryStage.show();
    }

    public static void main(String[] args) throws InterruptedException {
        launch(args);
        }
    public Parent initial() {
        Scanner scanner = new Scanner(System.in);
        Field field = new Field();
        while (true) {
            field.print();
            System.out.println("w-вверх");
            System.out.println("a-влево");
            System.out.println("d-вправо");
            System.out.println("s-вниз");
            symb = scanner.nextLine();
            keyCode = keyPressed(symb);
            field.move(keyCode);
            System.out.println();
        }
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


