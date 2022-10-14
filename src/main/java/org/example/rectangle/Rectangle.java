package org.example.rectangle;

import org.example.cartesian.Edge;
import org.example.cartesian.Point;

import java.util.ArrayList;
import java.util.HashSet;

public class Rectangle {
    private final Point bottomLeftPoint;
    private final Point topRightPoint;
    private final Point topLeftPoint;
    private final Point bottomRightPoint;

    private final Edge topEdge;
    private final Edge rightEdge;
    private final Edge bottomEdge;
    private final Edge leftEdge;

    public Rectangle(ArrayList<Point> points) throws RectangleException {
        if (pointsFormAValidRectangle(points)) {
            points.sort(Point::compareTo);
            this.bottomLeftPoint = points.get(0);
            this.topRightPoint = points.get(3);
            this.topLeftPoint = new Point(getLowerX(), getUpperY());
            this.bottomRightPoint = new Point(getUpperX(), getLowerY());

            this.topEdge = new Edge(topLeftPoint, topRightPoint);
            this.rightEdge = new Edge(bottomRightPoint, topRightPoint);
            this.bottomEdge = new Edge(bottomLeftPoint, bottomRightPoint);
            this.leftEdge = new Edge(bottomLeftPoint, topLeftPoint);


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

    public boolean contains(Point point) {
        boolean containsPointInXDirection = point.getX() > getLowerX() && point.getX() < getUpperX();
        boolean containsPointInYDirection = point.getY() > getLowerY() && point.getY() < getUpperY();

        return containsPointInXDirection && containsPointInYDirection;
    }

    public ArrayList<Point> getPoints() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(bottomLeftPoint);
        points.add(topRightPoint);
        points.add(topLeftPoint);
        points.add(bottomRightPoint);

        return points;
    }

    public ArrayList<Edge> getEdges() {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(topEdge);
        edges.add(rightEdge);
        edges.add(bottomEdge);
        edges.add(leftEdge);

        return edges;
    }

    private int getLowerX() {
        return this.bottomLeftPoint.getX();
    }

    private int getLowerY() {
        return this.bottomLeftPoint.getY();
    }

    private int getUpperX() {
        return this.topRightPoint.getX();
    }

    private int getUpperY() {
        return this.topRightPoint.getY();
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


    public Point getTopRightPoint() {
        return topRightPoint;
    }

    public Point getTopLeftPoint() {
        return topLeftPoint;
    }

    public Point getBottomRightPoint() {
        return bottomRightPoint;
    }

    public Edge getTopEdge() {
        return topEdge;
    }

    public Edge getRightEdge() {
        return rightEdge;
    }

    public Edge getBottomEdge() {
        return bottomEdge;
    }

    public Edge getLeftEdge() {
        return leftEdge;
    }

    public static class RectangleException extends Exception {
        public RectangleException(String message) {
            super(message);
        }
    }
}
