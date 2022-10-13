package org.example.rectangle;

import org.example.cartesian.Point;

import java.util.ArrayList;
import java.util.HashSet;

public class Rectangle {
    Corner bottomLeftCorner;
    Corner topRightCorner;
    Corner topLeftCorner;
    Corner bottomRightCorner;

    public Rectangle(ArrayList<Corner> corners) throws RectangleException {
        if (cornersFormAValidRectangle(corners)) {
            corners.sort(Corner::compareTo);
            this.bottomLeftCorner = corners.get(0);
            this.topRightCorner = corners.get(3);
            this.topLeftCorner = new Corner(getLowerX(), getUpperY());
            this.bottomRightCorner = new Corner(getUpperX(), getLowerY());

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

    public void setBottomLeftCorner(Corner bottomLeftCorner) {
        this.bottomLeftCorner = bottomLeftCorner;
    }

    public Corner getTopRightCorner() {
        return topRightCorner;
    }

    public void setTopRightCorner(Corner topRightCorner) {
        this.topRightCorner = topRightCorner;
    }

    public Corner getTopLeftCorner() {
        return topLeftCorner;
    }

    public void setTopLeftCorner(Corner topLeftCorner) {
        this.topLeftCorner = topLeftCorner;
    }

    public Corner getBottomRightCorner() {
        return bottomRightCorner;
    }

    public void setBottomRightCorner(Corner bottomRightCorner) {
        this.bottomRightCorner = bottomRightCorner;
    }

    public static class RectangleException extends Exception {
        public RectangleException(String message) {
            super(message);
        }
    }
}
