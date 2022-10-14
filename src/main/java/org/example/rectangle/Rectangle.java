package org.example.rectangle;

import org.example.cartesian.Edge;
import org.example.cartesian.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Represents a rectangle in cartesian coordinate space. (Has four corners with edges connecting said corners at 90
 * degree angles.)
 */
public class Rectangle {
    private Point bottomLeftPoint;
    private Point topRightPoint;
    private Point topLeftPoint;
    private Point bottomRightPoint;

    private Edge topEdge;
    private Edge rightEdge;
    private Edge bottomEdge;
    private Edge leftEdge;

    /**
     * Checks if the given points form a valid rectangle and if so, sets the points of this rectangle and
     * calculates the edges connecting the points of the rectangle.
     *
     * @param points A list of 4 cartesian coordinate pairs representing a rectangle.
     * @throws RectangleException Thrown if the 4 cartesian coordinate pairs do not represent a rectangle.
     */
    public Rectangle(List<Point> points) throws RectangleException {
        validateInputPoints(points);
        this.setPoints(points);
        this.setEdges();
    }

    /**
     * Sorts the points based on their distance from the origin of the cartesian coordinate system (0,0). Then,
     * uses the indices of the sorted points to assign the points to their logical positions in the rectangle.
     * This allows for easier intersection, containment, and adjacency calculations.
     *
     * @param points The list of points to represent this rectangle.
     */
    private void setPoints(List<Point> points) {
        points.sort(Point::compareTo);
        this.bottomLeftPoint = points.get(0);
        this.topRightPoint = points.get(3);
        this.topLeftPoint = new Point(bottomLeftPoint.getX(), topRightPoint.getY());
        this.bottomRightPoint = new Point(topRightPoint.getX(), bottomLeftPoint.getY());
    }

    /**
     * Calculates and sets the edges of the rectangle using the points of the rectangle.
     */
    private void setEdges() {
        this.topEdge = new Edge(topLeftPoint, topRightPoint);
        this.rightEdge = new Edge(bottomRightPoint, topRightPoint);
        this.bottomEdge = new Edge(bottomLeftPoint, bottomRightPoint);
        this.leftEdge = new Edge(bottomLeftPoint, topLeftPoint);
    }

    /**
     * Checks if there are 4 input points and that the 4 points are all unique.
     *
     * @param points The points to check for valid rectangle formation
     * @throws RectangleException An exception indicating why the points do not form a valid rectangle
     */
    private void validateInputPoints(List<Point> points) throws RectangleException {
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

    /**
     * Checks if a given point is contained by this rectangle.
     *
     * @param point The point to be checked for containment by this rectangle
     * @return boolean indicating if the point is contained
     */
    public boolean contains(Point point) {
        boolean containsPointInXDirection = point.getX() > getLowerXBound() && point.getX() < getUpperXBound();
        boolean containsPointInYDirection = point.getY() > getLowerYBound() && point.getY() < getUpperYBound();

        return containsPointInXDirection && containsPointInYDirection;
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

    /**
     * Gets the points representing this rectangle.
     *
     * @return The points representing this rectangle.
     */
    public ArrayList<Point> getPoints() {
        ArrayList<Point> points = new ArrayList<>();
        points.add(bottomLeftPoint);
        points.add(topRightPoint);
        points.add(topLeftPoint);
        points.add(bottomRightPoint);

        return points;
    }

    /**
     * Gets the edges connecting the points of this rectangle.
     *
     * @return The edges connecting the points of this rectangle.
     */
    public ArrayList<Edge> getEdges() {
        ArrayList<Edge> edges = new ArrayList<>();
        edges.add(topEdge);
        edges.add(rightEdge);
        edges.add(bottomEdge);
        edges.add(leftEdge);

        return edges;
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

    /**
     * An exception representing a validation error when checking for a valid rectangle
     */
    public static class RectangleException extends Exception {
        public RectangleException(String message) {
            super(message);
        }
    }
}
