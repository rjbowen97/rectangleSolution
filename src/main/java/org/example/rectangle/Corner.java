package org.example.rectangle;

import java.util.Objects;

public class Corner implements Comparable<Corner> {

    int x;
    int y;

    public Corner(int x, int y) {
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
        Compares the position of this corner to another corner based on its position relative to
        the origin (x=0,y=0)
     */
    @Override
    public int compareTo(Corner otherCorner) {
        return Integer.compare(this.getX() + this.getY(), otherCorner.getX() + otherCorner.getY());

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Corner corner = (Corner) o;
        return x == corner.x && y == corner.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    @Override
    public String toString() {
        return "Corner{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
