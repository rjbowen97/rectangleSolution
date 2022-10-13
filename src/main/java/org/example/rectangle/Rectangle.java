package org.example.rectangle;

import org.example.cartesian.Range;

import java.util.ArrayList;
import java.util.HashSet;

public class Rectangle {
    Corner bottomLeftCorner;
    Corner topRightCorner;

    public Rectangle(ArrayList<Corner> corners) throws RectangleException {
        if (cornersFormAValidRectangle(corners)) {
            corners.sort(Corner::compareTo);
            this.bottomLeftCorner = corners.get(0);
            this.topRightCorner = corners.get(3);

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

    public Range getXRange() {
        return new Range(this.getBottomLeftCorner().getX(), this.getTopRightCorner().getX());
    }

    public Range getYRange() {
        return new Range(this.getBottomLeftCorner().getY(), this.getTopRightCorner().getY());
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


    public static class RectangleException extends Exception {
        public RectangleException(String message) {
            super(message);
        }
    }
}
