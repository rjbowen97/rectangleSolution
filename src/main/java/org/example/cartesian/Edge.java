package org.example.cartesian;

public class Edge {
    Point start;
    Point end;

    public Edge(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point intersects(Edge otherEdge) {
        if (this.start.getX() == this.end.getX()) {
            if (this.start.getX() > otherEdge.getStart().getX() && this.end.getX() < otherEdge.getEnd().getX() ) {
                if (this.start.getY() < otherEdge.getStart().getY() && this.end.getY() > otherEdge.getStart().getY()) {
                    return new Point(this.start.getX(), otherEdge.getStart().getY());
                }
            }
        }

        if (this.start.getY() == this.end.getY()) {
            if (this.start.getY() > otherEdge.getStart().getY() && this.end.getY() < otherEdge.getEnd().getY() ) {
                if (this.start.getX() < otherEdge.getStart().getX() && this.end.getX() > otherEdge.getStart().getX()) {
                    return new Point(otherEdge.getStart().getX(), this.start.getY());
                }
            }
        }

        return null;
    }

    public Point getStart() {
        return start;
    }

    public void setStart(Point start) {
        this.start = start;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }
}
