package hslu.oop.sw04;

import java.awt.*;

public class LineProblem {

    private Point startPoint;
    private Point endPoint;

    public LineProblem(Point startPoint, Point endPoint) {
        this.startPoint = new Point(this.startPoint.getX(), this.startPoint.getY());
        this.endPoint = new Point(this.endPoint.getX(), this.endPoint.getY());
    }

    public Point getStartPoint() {
        return new Point(this.startPoint.getX(), this.startPoint.getY());
    }

    public void setStartPoint(Point startPoint) {
        this.startPoint = new Point(startPoint.getX(), startPoint.getY());
    }

    public Point getEndPoint() {
        return new Point(this.endPoint.getX(), this.endPoint.getY());
    }

    public void setEndPoint(Point endPoint) {
        this.startPoint = new Point(endPoint.getX(), endPoint.getY());
    }
}
