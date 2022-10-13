package org.example.rectangle;

import java.util.ArrayList;
import java.util.HashSet;

public class Rectangle {
    Corner bottomLeftCorner;
    Corner topRightCorner;

    public Rectangle(ArrayList<Corner> corners) throws RectangleException {
        if (pointsFormAValidRectangle(corners)) {
            corners.sort(Corner::compareTo);
            this.bottomLeftCorner = corners.get(0);
            this.topRightCorner = corners.get(3);

        } else {
            throw new RectangleException("ERROR: A rectangle only has 4 corners.");
        }
    }

    private boolean pointsFormAValidRectangle(ArrayList<Corner> corners) throws RectangleException {
        boolean correctNumberOfPoints = corners.size() == 4;
        if (!correctNumberOfPoints) {
            throw new RectangleException("A Rectangle only has 4 corners");
        }

        HashSet<Corner> uniqueCorners = new HashSet<>(corners);
        boolean correctNumberOfUniquePoints = uniqueCorners.size() == 4;
        if (!correctNumberOfUniquePoints) {
            throw new RectangleException("A Rectangle cannot have duplicate corners");
        }

        return true;
    }

    @Override
    public String toString() {
        return "Rectangle{" +
                ", bottomLeftPoint=" + bottomLeftCorner +
                ", topRightPoint=" + topRightCorner +
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