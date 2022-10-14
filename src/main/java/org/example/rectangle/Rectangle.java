package org.example.rectangle;

import org.example.cartesian.Edge;
import org.example.cartesian.Point;

import java.util.ArrayList;
import java.util.HashSet;

public class Rectangle {
    private final Corner bottomLeftCorner;
    private final Corner topRightCorner;
    private final Corner topLeftCorner;
    private final Corner bottomRightCorner;

    private final Edge topEdge;
    private final Edge rightEdge;
    private final Edge bottomEdge;
    private final Edge leftEdge;

    public Rectangle(ArrayList<Corner> corners) throws RectangleException {
        if (cornersFormAValidRectangle(corners)) {
            corners.sort(Corner::compareTo);
            this.bottomLeftCorner = corners.get(0);
            this.topRightCorner = corners.get(3);
            this.topLeftCorner = new Corner(getLowerX(), getUpperY());
            this.bottomRightCorner = new Corner(getUpperX(), getLowerY());

            this.topEdge = new Edge(topLeftCorner, topRightCorner);
            this.rightEdge = new Edge(bottomRightCorner, topRightCorner);
            this.bottomEdge = new Edge(bottomLeftCorner, bottomRightCorner);
            this.leftEdge = new Edge(bottomLeftCorner, topLeftCorner);


        } else {
            throw new RectangleException("ERROR: A rectangle only has 4 corners.");
        }
    }

    private boolean cornersFormAValidRectangle(ArrayList<Corner> corners) throws RectangleException {
        boolean correctNumberOfCorners = corners.size() == 4;
        if (!correctNumberOfCorners) {
            throw new RectangleException("A Rectangle only has 4 corners");
        }

        HashSet<Corner> uniqueCorners = new HashSet<>(corners);
        boolean correctNumberOfUniqueCorners = uniqueCorners.size() == 4;
        if (!correctNumberOfUniqueCorners) {
            throw new RectangleException("A Rectangle cannot have duplicate corners");
        }

        return true;
    }

    public boolean contains(Point point) {
        boolean containsPointInXDirection = point.getX() > getLowerX() && point.getX() < getUpperX();
        boolean containsPointInYDirection = point.getY() > getLowerY() && point.getY() < getUpperY();

        return containsPointInXDirection && containsPointInYDirection;
    }

    public ArrayList<Corner> getCorners() {
        ArrayList<Corner> corners = new ArrayList<>();
        corners.add(bottomLeftCorner);
        corners.add(topRightCorner);
        corners.add(topLeftCorner);
        corners.add(bottomRightCorner);

        return corners;
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
        return this.bottomLeftCorner.getX();
    }

    private int getLowerY() {
        return this.bottomLeftCorner.getY();
    }

    private int getUpperX() {
        return this.topRightCorner.getX();
    }

    private int getUpperY() {
        return this.topRightCorner.getY();
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                ", bottomLeftCorner=" + bottomLeftCorner +
                ", topRightCorner=" + topRightCorner +
                '}';
    }

    public Corner getBottomLeftCorner() {
        return bottomLeftCorner;
    }


    public Corner getTopRightCorner() {
        return topRightCorner;
    }

    public Corner getTopLeftCorner() {
        return topLeftCorner;
    }

    public Corner getBottomRightCorner() {
        return bottomRightCorner;
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
