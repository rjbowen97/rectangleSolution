package org.example;

import java.util.ArrayList;
import java.util.HashSet;

public class Rectangle {

    Point bottomLeftPoint;
    Point topRightPoint;

    public Rectangle(ArrayList<Point> points) throws RectangleException {
        if (pointsFormAValidRectangle(points)) {
            points.sort(Point::compareTo);
            this.bottomLeftPoint = points.get(0);
            this.topRightPoint = points.get(3);

        } else {
            throw new RectangleException("ERROR: A rectangle only has 4 points.");
        }
    }

    private boolean pointsFormAValidRectangle(ArrayList<Point> points) throws RectangleException {
        boolean correctNumberOfPoints = points.size() == 4;
        if (!correctNumberOfPoints) {
            throw new RectangleException("A Rectangle only has 4 points");
        }

        HashSet<Point> uniquePoints = new HashSet<>(points);
        boolean correctNumberOfUniquePoints = uniquePoints.size() == 4;
        if (!correctNumberOfUniquePoints) {
            throw new RectangleException("A Rectangle cannot have duplicate points");
        }

        return true;
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


    public static class RectangleException extends Exception {
        public RectangleException(String message) {
            super(message);
        }
    }
}
