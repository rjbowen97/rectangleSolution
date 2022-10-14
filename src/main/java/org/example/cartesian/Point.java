package org.example.cartesian;

import java.util.Objects;

/**
 * Represents a point in a cartesian coordinate space.
 */
public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    /**
     * Creates a point in cartesian space with the given x and y values
     *
     * @param x The position of the point in the x dimension
     * @param y The position of the point in the y dimension
     */
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    /**
     * This point is considered equal to another point if the other point has the same x and y values as this point.
     *
     * @param o The point being checked for equality
     * @return boolean if the two points are equal
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Point point = (Point) o;
        return x == point.x && y == point.y;
    }

    /**
     * Used for checking if a point is unique in a HashSet.
     *
     * @return The hashcode generated from the x and y coordinates of the point..
     */
    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    /**
     * Compares the position of this point to another point based on its position relative to
     * the origin (x=0,y=0).
     * <p>
     * e.g. (0,1) is greater than (-2,-3).
     *
     * @param otherPoint the object to be compared.
     * @return The comparison result.
     */
    @Override
    public int compareTo(Point otherPoint) {
        return Integer.compare(this.getX() + this.getY(), otherPoint.getX() + otherPoint.getY());
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
