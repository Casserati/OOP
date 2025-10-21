package hslu.oop.sw04;

public class Point
{
    private int xCoordinate;
    private int yCoordinate;

    public Point(int x, int y){
        this.xCoordinate = x;
        this.yCoordinate = y;
    }

    public int getQuadrant(){
        if (xCoordinate > 0 && yCoordinate > 0){
            return 1;
        }
        if (xCoordinate < 0 && yCoordinate > 0){
            return 2;
        }
        if (xCoordinate < 0 && yCoordinate < 0){
            return 3;
        }
        if (xCoordinate > 0 && yCoordinate < 0){
            return 4;
        }
        else {
            return 0;
        }
    }

    public int getX() {
        return xCoordinate;
    }

    public int getY() {
        return yCoordinate;
    }

    // Aufgabe a
    public void moveRelative(int x, int y){
        this.xCoordinate += x;
        this.yCoordinate += y;
    }

    // Aufgabe b
    public void moveRelative(Point point){
        this.xCoordinate += point.getX();
        this.yCoordinate += point.getY();
    }

    // Aufgabe c
    public void moveRelative(double angle, int value){
        this.xCoordinate += (int) (value * Math.cos(angle));
        this.yCoordinate += (int) (value * Math.sin(angle));
    }
}