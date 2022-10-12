package org.example;

public class Point implements Comparable<Point> {

    int x;
    int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    /*
        Compares the position of this point to another point based on its position relative to
        the origin (x=0,y=0)
     */
    @Override
    public int compareTo(Point otherPoint) {
        return Integer.compare(this.getX() + this.getY(), otherPoint.getX() + otherPoint.getY());

    }

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
