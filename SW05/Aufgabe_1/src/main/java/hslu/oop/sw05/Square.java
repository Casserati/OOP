package hslu.oop.sw05;

public final class Square extends Shape {

    private final int side;

    public Square(final int x, final int y, final int side) {
        super(x, y);
        this.side = side;
    }

    public int getSide() {
        return this.side;
    }

    @Override
    public int getPerimeter() {
        return 4 * side;
    }

    @Override
    public int getArea() {
        return (int)Math.pow(side, 2);
    }
}
