package org.example;

import java.util.ArrayList;

public class Rectangle {

    Point bottomLeftPoint;

    Point topRightPoint;

    public Rectangle(ArrayList<Point> points) {
        // todo - validate the points create a rectangle

        points.sort(Point::compareTo);
        this.bottomLeftPoint = points.get(0);
        this.topRightPoint = points.get(3);
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                ", bottomLeftPoint=" + bottomLeftPoint +
                ", topRightPoint=" + topRightPoint +
                '}';
    }

    public Point getBottomLeftPoint() {
        return bottomLeftPoint;
    }

    public void setBottomLeftPoint(Point bottomLeftPoint) {
        this.bottomLeftPoint = bottomLeftPoint;
    }

    public Point getTopRightPoint() {
        return topRightPoint;
    }

    public void setTopRightPoint(Point topRightPoint) {
        this.topRightPoint = topRightPoint;
    }
}
