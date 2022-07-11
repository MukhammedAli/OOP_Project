package sample;

import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.layout.GridPane;
import javafx.geometry.Bounds;
import java.io.FileReader;
import javafx.scene.layout.ColumnConstraints;
import javafx.collections.ObservableList;
import java.io.*;
import javafx.scene.Node;
import java.util.*;



public class Map extends Pane {
    private int UNIT = 90;
    private int size = 8;
    private int[][]map = new int[size][size];
    private Position start;
    ArrayList<Position>list = new ArrayList<>();
    ArrayList<String>listenter = new ArrayList<>();
    Position[][]arr = new Position[size][size];
    Rectangle r = null;
    Bounds target;
    GridPane grid;
    public Map(String fileName){
            start = new Position();
          grid = new GridPane();
         grid.setVgap(1);
         grid.setHgap(1);
        try{
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            size  = Integer.parseInt(br.readLine());
            map = new int[size][size];
            arr = new Position[size][size];
            String delimeters = " ";
            for(int row = 0; row < map.length; row++){
                String line = br.readLine();
                String[]tokens = line.split(delimeters);
                for(int column = 0; column < map[row].length; column++){
                    map[row][column] = Integer.parseInt(tokens[column]);
                }
            }
        }
        catch(Exception e){

        }
        for(int i = 0; i < map.length; i++){
            for(int j = 0; j < map[i].length; j++){

                

               getChildren().add(draw(getValue(i,j),i,j));
               for(int z = 0; z < arr.length; z++){
                for(int v = 0; v < arr[z].length; v++){
                    Rectangle rer = draw(getValue(i,j),i,j);
                    Position pro = new Position((int)(rer.getX()) + (int)(rer.getWidth() / 2),(int)(rer.getY()) + (int)(rer.getHeight() / 2));
                    arr[z][v] = pro;
                }
               }

                if(getValue(i,j) == 1){
                Rectangle rectangular = draw(getValue(i,j),i,j);
                Position positive = new Position();
                positive.setX((int)(rectangular.getX()) + (int)(rectangular.getWidth() / 2));
                positive.setY((int)(rectangular.getY()) + (int)(rectangular.getHeight() / 2));
            
               list.add(positive);
                }

             
                 // setReccor(r);
                // Bounds bounds = r.localToScene(r.getBoundsInLocal());
                // start.setX((int)(bounds.getMinX()) + (int)(bounds.getWidth()) / 2);
                // start.setY((int)(bounds.getMinY()) + (int)(bounds.getHeight() / 2));
                
                                  
               

            }
            
        }
        
        
        
        
         
        // setRec(rec);
         
        // Bounds bounds = grid.sceneToLocal(textArea.localToScene(.getBoundsInLocal()));

//          for(int i = 0; i < map.length; i++){
//              for(int j = 0; j < map[i].length; j++){
//                  int index = map[i][j];
//                  if(index == 0){
//                      Rectangle rec1 = new Rectangle(UNIT,UNIT);
//                      rec1.setStroke((Color.WHITE));
//                      rec1.setFill((Color.WHITE));
//
//                  }if(index == 1){
//                      Rectangle rec2 = new Rectangle(UNIT,UNIT);
//                      rec2.setStroke((Color.WHITE));
//                      rec2.setFill((Color.WHITE));
//
//                  }
//              }
//          }
    }
        
       
        public Position[][] getArr(){
            return arr;
        }
        public int[][] getMap(){
            return map;
        }
        // public  void setReccor(Rectangle r){
        //     this.r = r;
        // }
      
        // public String getReccor(){
        //     return " x " + r.getX() + "  y  " + r.getY();
        // }
        public ArrayList<Position> getList(){
            return list;
        }
//          try(BufferedReader br = new BufferedReader(new FileReader(fileName)))
    //      }{
//              String currentLine;
//              while(currentLine == br.readLine() != null){
//                  if(currentLine.isEmpty())
//                      continue;
//                  ArrayList<Integer> rows = new ArrayList<>();
//                  String values = currentLine.trim().split();
//                  for(String string: values){
//                      if(!string.isEmpty()){
//                          int id = Integer.parseInt(string);
//                          reow.add(id);
//                      }
//                  }
//                  tempLayout.add(row);
//              }
//          }catch(IOException e){
//
//          }
//          int width = tempLayout.get(0).size();
//          int height = tempLayout.size();
//
//          layer = new TileLayer(width,height);
//          return layer;

    public int getUnit(){
        return UNIT;
    }
    public Rectangle draw(int num,int row,int column){
        Rectangle rec = null;
        rec = new Rectangle(UNIT, UNIT);
        rec.setX((column) * 90);
        rec.setY((row) * 90);
        if(num == 0){
            rec.setFill(Color.WHITE);
            rec.setStroke(Color.BLACK);
        }else if(num == 1){
            rec.setFill(Color.BLACK);
            rec.setStroke(Color.BLACK);

        }else if(num == 2){
            rec.setFill(Color.WHITE);
            rec.setStroke(Color.BLACK);
            start.setX(100);
            start.setY(100); 
             Bounds bounds = rec.localToScene(rec.getBoundsInLocal());
                 start.setX((int)(bounds.getMinX()) + (int)(bounds.getWidth()) / 2);
                 start.setY((int)(bounds.getMinY()) + (int)(bounds.getHeight() / 2));
            

        }

        return rec;
    }
    public int getSize(){
        return size;
    }

//     public Node getNodeFromGridPane(GridPane gridPane, int col, int row) {
//     for (Node node : gridPane.getChildren()) {
//         if (GridPane.getColumnIndex(node) == col && GridPane.getRowIndex(node) == row) {
//             return node;
//         }
//     }
//     return null;
// }
    public int  getValue(int a, int b){
        return map[a][b];
    }
    public Position getStartPosition(){
        return start;
    }


}
