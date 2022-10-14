package org.example.rectangle;

import org.example.cartesian.Edge;
import org.example.cartesian.Point;

import java.util.ArrayList;
import java.util.HashSet;

public class Rectangle {
    private Point bottomLeftPoint;
    private Point topRightPoint;
    private Point topLeftPoint;
    private Point bottomRightPoint;

    private Edge topEdge;
    private Edge rightEdge;
    private Edge bottomEdge;
    private Edge leftEdge;

    public Rectangle(ArrayList<Point> points) throws RectangleException {
        validateInputPoints(points);
        this.setPoints(points);
        this.setEdges();
    }

    private void setEdges() {
        this.topEdge = new Edge(topLeftPoint, topRightPoint);
        this.rightEdge = new Edge(bottomRightPoint, topRightPoint);
        this.bottomEdge = new Edge(bottomLeftPoint, bottomRightPoint);
        this.leftEdge = new Edge(bottomLeftPoint, topLeftPoint);
    }

    private void validateInputPoints(ArrayList<Point> points) throws RectangleException {
        boolean correctNumberOfPoints = points.size() == 4;
        if (!correctNumberOfPoints) {
            throw new RectangleException("A Rectangle only has 4 points");
        }

        HashSet<Point> uniquePoints = new HashSet<>(points);
        boolean correctNumberOfUniquePoints = uniquePoints.size() == 4;
        if (!correctNumberOfUniquePoints) {
            throw new RectangleException("A Rectangle cannot have duplicate points");
        }
    }

    public boolean contains(Point point) {
        boolean containsPointInXDirection = point.getX() > getLowerXBound() && point.getX() < getUpperXBound();
        boolean containsPointInYDirection = point.getY() > getLowerYBound() && point.getY() < getUpperYBound();

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

    private void setPoints(ArrayList<Point> points) {
        points.sort(Point::compareTo);
        this.bottomLeftPoint = points.get(0);
        this.topRightPoint = points.get(3);
        this.topLeftPoint = new Point(bottomLeftPoint.getX(), topRightPoint.getY());
        this.bottomRightPoint = new Point(topRightPoint.getX(), bottomLeftPoint.getY());
    }

    public ArrayList<Edge> getEdges() {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(topEdge);
        edges.add(rightEdge);
        edges.add(bottomEdge);
        edges.add(leftEdge);

        return edges;
    }

    private int getLowerXBound() {
        return this.bottomLeftPoint.getX();
    }

    private int getLowerYBound() {
        return this.bottomLeftPoint.getY();
    }

    private int getUpperXBound() {
        return this.topRightPoint.getX();
    }

    private int getUpperYBound() {
        return this.topRightPoint.getY();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                "bottomLeftPoint=" + bottomLeftPoint +
                ", topRightPoint=" + topRightPoint +
                ", topLeftPoint=" + topLeftPoint +
                ", bottomRightPoint=" + bottomRightPoint +
                ", topEdge=" + topEdge +
                ", rightEdge=" + rightEdge +
                ", bottomEdge=" + bottomEdge +
                ", leftEdge=" + leftEdge +
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
