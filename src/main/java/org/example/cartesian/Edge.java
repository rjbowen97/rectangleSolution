package org.example.cartesian;

import org.example.rectangle.AdjacencyType;

import java.util.Objects;

public class Edge {
    Point start;
    Point end;

    public Edge(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    public Point intersects(Edge otherEdge) {
        if (this.start.getX() == this.end.getX()) {
            if (this.start.getX() > otherEdge.getStart().getX() && this.end.getX() < otherEdge.getEnd().getX()) {
                if (this.start.getY() < otherEdge.getStart().getY() && this.end.getY() > otherEdge.getStart().getY()) {
                    return new Point(this.start.getX(), otherEdge.getStart().getY());
                }
            }
        }

        if (this.start.getY() == this.end.getY()) {
            if (this.start.getY() > otherEdge.getStart().getY() && this.end.getY() < otherEdge.getEnd().getY()) {
                if (this.start.getX() < otherEdge.getStart().getX() && this.end.getX() > otherEdge.getStart().getX()) {
                    return new Point(otherEdge.getStart().getX(), this.start.getY());
                }
            }
        }

        return null;
    }

    public AdjacencyType isAdjacentTo(Edge otherEdge) {
        if (this.equals(otherEdge)) {
            return AdjacencyType.PROPER;
        }

        if (this.start.getX() == this.end.getX()) {
            if (otherEdge.getStart().getX() == otherEdge.getEnd().getX()) {
                if (this.start.getY() > otherEdge.getStart().getY() && this.end.getY() < otherEdge.getEnd().getY()) {
                    return AdjacencyType.SUB_LINE;
                }
            }
        }

        if (this.start.getY() == this.end.getY()) {
            if (otherEdge.getStart().getY() == otherEdge.getEnd().getY()) {
                if (this.start.getX() > otherEdge.getStart().getX() && this.end.getX() < otherEdge.getEnd().getX()) {
                    return AdjacencyType.SUB_LINE;
                }
            }
        }


        return AdjacencyType.NONE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Edge edge = (Edge) o;
        return start.equals(edge.start) && end.equals(edge.end);
    }

    @Override
    public int hashCode() {
        return Objects.hash(start, end);
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
