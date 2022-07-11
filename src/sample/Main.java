package sample;

import javafx.application.Application;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.util.Duration;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import java.io.*;
import java.util.*;

import java.io.File;

// import  javafx.scene.input.KeyCode.DOWN;
// import  javafx.scene.input.KeyCode.UP;
// import  javafx.scene.input.KeyCode.LEFT;
// import  javafx.scene.input.KeyCode.RIGHT;

public class Main extends Application {
    private Map map;
    private MyPlayer player;
    private  Food food;
    private Timeline animation;
    //    static String filename;
    public static void main(String[] args) {
        launch(args);
//        filename = args[0];
    }

    @Override
    public void start(Stage primaryStage) throws Exception{

        Pane paner = new Pane();
        map = new Map("C:\\Users\\muham\\IdeaProjects\\oop_project\\src\\sample\\map1.txt");
        player = new MyPlayer(map);
        Food food = new Food(map,player);
        paner.getChildren().addAll(map,player);
        // map.getChildren().add((Pane)player);

        Scene scene = new Scene(paner,800,800);
        scene.setOnKeyPressed(e -> {
            switch (e.getCode()) {
                case DOWN:player.moveDown();break;
                case UP:player.moveUp();break;
                case LEFT:player.moveLeft();break;
                case RIGHT:player.moveRight();break;
            }
        });
     //   MyBotPlayer bot = new MyBotPlayer(player,map,food);
//        scene.setOnKeyPressed(e ->{
//            if(e.getCode() == KeyCode.P && map.getSize() == 8){
//                bot.eat();
//            }
//        });

        primaryStage.setScene(scene);
        primaryStage.setTitle("Game");
        primaryStage.show();




    }
//    public void run(){
//
//    }
//
//    public void draw(){
//
//        for(int i = 0; i < map.getUnit(); i++){
//            for(int j = 0; j < map.getUnit(); j++){
//                if(map.getValue(i,j) == 0){
//
//                }
//                if(map.getValue(i,j) == 1){
//
//                }
//            }
//        }
//    }






}
