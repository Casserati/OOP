package hslu.oop.sw05;

public final class Circle extends Shape {

    private int diameter;

    public Circle(final int x, final int y, final int diameter) {
        super(x, y);
        this.diameter = diameter;
    }

    public int getDiameter() {
        return this.diameter;
    }

    public void setDiameter(int diameter) {
        this.diameter = diameter;
    }

    @Override
    public int getPerimeter() {
        return (int) (Math.PI * getDiameter());
    }

    @Override
    public int getArea() {
        return (int) (Math.pow((getDiameter() / 2), 2) * Math.PI);
    }
}
