package hslu.oop.sw03;

public class Pointer {

    private int x;
    private int y;

    public Pointer(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getQuadrant() {
        if (x < 0 && y > 0)
            return 2;
        if (x < 0 && y < 0)
            return 3;
        if (x > 0 && y > 0)
            return 1;
        if (x > 0 && y < 0)
            return 4;
        return 0; //falls der Point auf einer Achse ist
    }
}
