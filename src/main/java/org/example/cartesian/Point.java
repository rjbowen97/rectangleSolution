package org.example.cartesian;

import java.util.Objects;

public class Point implements Comparable<Point> {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

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

    /*
            Compares the position of this point to another point based on its position relative to
            the origin (x=0,y=0)
         */
    @Override
    public int compareTo(Point otherPoint) {
        return Integer.compare(this.getX() + this.getY(), otherPoint.getX() + otherPoint.getY());
    }
}
