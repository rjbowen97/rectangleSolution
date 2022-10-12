package org.example;

import java.util.ArrayList;
import java.util.Comparator;

public class Rectangle implements Comparator<Point> {

    Point topLeftPoint;
    Point topRightPoint;
    Point bottomLeftPoint;
    Point bottomRightPoint;

    // todo constructor taking only two points

    public Rectangle(Point point1, Point point2, Point point3, Point point4) {
        ArrayList<Point> points = new ArrayList<>();
        points.add(point1);
        points.add(point2);
        points.add(point3);
        points.add(point4);

        System.out.println(points);
        points.sort(this);
        System.out.println(points);


        // todo - Point assignment


        // todo - validate the points create a rectangle

        this.topLeftPoint = point1;
        this.topRightPoint = point2;
        this.bottomLeftPoint = point3;
        this.bottomRightPoint = point4;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "topLeftPoint=" + topLeftPoint +
                ", topRightPoint=" + topRightPoint +
                ", bottomLeftPoint=" + bottomLeftPoint +
                ", bottomRightPoint=" + bottomRightPoint +
                '}';
    }

    /*
        This will compare points in a way that sorts them clockwise,
        starting from the top left corner and ending
        in the bottom left corner
     */
    @Override
    public int compare(Point point1, Point point2) {

        if (point1.getX() < point2.getX()) {
            if (point1.getY() > point2.getY()) {
                return 1;
            } else {
                return -1;
            }
        }

        return 0;
    }
}
