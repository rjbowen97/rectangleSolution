package org.example.rectangle;

import org.example.cartesian.Point;

public class Corner extends Point implements Comparable<Corner> {

    public Corner(int x, int y) {
        super(x, y);
    }

    /*
        Compares the position of this corner to another corner based on its position relative to
        the origin (x=0,y=0)
     */
    @Override
    public int compareTo(Corner otherCorner) {
        return Integer.compare(this.getX() + this.getY(), otherCorner.getX() + otherCorner.getY());
    }
}
