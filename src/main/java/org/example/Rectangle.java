package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class Rectangle implements Comparator<Point> {

    Point bottomLeftPoint;

    Point topRightPoint;

    public Rectangle(ArrayList<Point> points) {
        // todo - validate the points create a rectangle

        points.sort(this);
        this.bottomLeftPoint = points.get(0);
        this.topRightPoint = points.get(3);
    }

    /*
        We only need two vertices that are opposite of each other for rectangle calculations.
        So, by sorting the points based on position, the bottom left point of the rectangle
        is at index 0 and the top right point of the rectangle is at index 3.
     */
    @Override
    public int compare(Point point1, Point point2) {
        return Integer.compare(point1.getX() + point1.getY(), point2.getX() + point2.getY());
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
