package sample;

import javafx.scene.shape.Circle;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import javafx.scene.layout.Pane;
import javafx.scene.control.Button;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Rectangle;
import java.io.*;
import java.util.*;
import javafx.geometry.Bounds;

public class MyPlayer extends Pane implements Player{
    private Circle ball;
    private Map map;
    private Position position;
    int[][]matrix;
    Position[][]arr;
    
    int i = 0;
    int j = 0;
    ArrayList<Position>list;


    public MyPlayer(Map map){
        this.map = map;
        map.getBoundsInLocal();
        position = map.getStartPosition();
       ball = new Circle(position.getX(),position.getY(),map.getUnit() - 45);
        ball.setFill(Color.RED);
        ball.setStroke(Color.BLACK);
        getChildren().add(ball);
        matrix = new int[map.getSize()][map.getSize()];
        list =  map.getList();
        arr = map.getArr();
        position.setX(0);
        position.setY(0);
        
    }

    @Override
    public void moveLeft(){
       
        boolean check = true;
        for(int i = 0; i < list.size(); i++){
            if(((int)(ball.getCenterX() - 90) == list.get(i).getX() && (int)(ball.getCenterY()) == list.get(i).getY())){
                check = false;
            }
        }
        if(ball.getCenterX() > ball.getRadius() && check){
            position.setX(((int)(ball.getCenterX() - 45 - 90) / 90));
        position.setY((int)((ball.getCenterY() - 45) / 90));
            ball.setCenterX(ball.getCenterX() - 90);
         
        }else{
            System.out.println("Invalid Position!");
            ball.setCenterX(ball.getCenterX());        
        }
        ball.setCenterY(ball.getCenterY());
        // if(i < 0 && j < 0){
        //     ball.setCenterX(ball.getCenterX());
        //     ball.setCenterY(ball.getCenterY());
        // }
        // if(i != 0){ 
        // position.setX(i - 1);
        // position.setY(j);
        // }
    }
    @Override
    public void moveRight(){
     
        boolean check = true;
        for(int i = 0; i < list.size(); i++){
            if(((int)(ball.getCenterX() + 90) == list.get(i).getX() && (int)(ball.getCenterY()) == list.get(i).getY())){
                check = false;
            }
        }
        if(ball.getCenterX() < map.getWidth() - ball.getRadius() - 90 && check){
            position.setX(((int)(ball.getCenterX() - 45 + 90) / 90));
        position.setY((int)((ball.getCenterY() - 45) / 90));
            ball.setCenterX(ball.getCenterX() + 90);
       
        }else{
            System.out.println("Invalid Position!");
            ball.setCenterX(ball.getCenterX());
        }
          ball.setCenterY(ball.getCenterY());
        
    //     if(i < 0 && j < 0){
    //         ball.setCenterX(ball.getCenterX());
    //         ball.setCenterY(ball.getCenterY());
    //     }
    //     if(i >= map.getSize()){ 
    //     position.setX(i + 1);
    //     position.setY(j);   
    // }
        

    }
    @Override
    public void moveDown(){
        

         boolean check = true;
        for(int i = 0; i < list.size(); i++){
            if((int)(ball.getCenterX()) == list.get(i).getX() && (int)(ball.getCenterY() + 90) == list.get(i).getY()){
                check = false;
            }
        }
        if((ball.getCenterY() < map.getHeight() - ball.getRadius() - 90) && check){
            position.setX(((int)(ball.getCenterX() - 45) / 90));
        position.setY((int)((ball.getCenterY() - 45 + 90) / 90));
            ball.setCenterY(ball.getCenterY() + 90);
        
        }else{
            System.out.println("Invalid Position!");
            ball.setCenterY(ball.getCenterY());
        }
        ball.setCenterX(ball.getCenterX());
    
    //     if(i < 0 && j < 0){
    //         ball.setCenterX(ball.getCenterX());
    //         ball.setCenterY(ball.getCenterY());
    //     }
    //     if(j >= map.getSize()){ 
    //    position.setX(i);
    //     position.setY(j + 1);
    // }
        

    }

    @Override
    public void moveUp(){
        
         boolean check = true;
        for(int i = 0; i < list.size(); i++){
            if((int)(ball.getCenterX()) == list.get(i).getX() && (int)(ball.getCenterY() - 90) == list.get(i).getY()){
                check = false;
            }
        }
        if(ball.getCenterY() > ball.getRadius() && check){
            position.setX(((int)(ball.getCenterX() - 45) / 90));
        position.setY((int)((ball.getCenterY() - 45 - 90) / 90));
            ball.setCenterY(ball.getCenterY() - 90);
        
        }else{
            System.out.println("Invalid Position!");
            ball.setCenterY(ball.getCenterY());
        }
      ball.setCenterX(ball.getCenterX());
    //     if(i < 0 && j < 0){
    //         ball.setCenterX(ball.getCenterX());
    //         ball.setCenterY(ball.getCenterY());
    //     }
    //     if(j != 0){ 
    //      position.setX(i);   
    //     position.setY(j - 1);
    // }

    }
    @Override
    public Position getPosition(){
        return position;
    }
   


}
