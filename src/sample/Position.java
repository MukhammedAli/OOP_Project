package sample;

public class Position {
    private int x;
    private int y;
    public  Position(int x,int y){
    this.x = x;
    this.y = y;
    }

    public Position() {

    }

    public int getX(){
     return x;
    }
    public int getY(){
        return  y;
    }
    public void setX(int x){
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public boolean equals(Position o){
        if(this.x == o.getX() && this.y == o.getY())
            return true;
        return false;
    }
}
