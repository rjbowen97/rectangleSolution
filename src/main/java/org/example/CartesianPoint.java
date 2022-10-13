package org.example;

import java.util.Objects;

public class CartesianPoint {
    int x;
    int y;

    public CartesianPoint(int x, int y) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CartesianPoint cartesianPoint = (CartesianPoint) o;
        return x == cartesianPoint.x && y == cartesianPoint.y;
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
