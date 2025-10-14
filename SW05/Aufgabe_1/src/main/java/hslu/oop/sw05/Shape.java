package hslu.oop.sw05;

public abstract class Shape {
    private int x;
    private int y;

    protected Shape(int x, int y){
        this.x = x;
        this.y = y;
    }

    public void move(int newX, int newY){
        this.x = newX;
        this.y = newY;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    public abstract int getPerimeter();

    public abstract int getArea();
}
