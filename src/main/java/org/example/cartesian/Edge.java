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
        if (isVertical()) {
            if (this.start.getX() > otherEdge.getStart().getX() && this.end.getX() < otherEdge.getEnd().getX()) {
                if (this.start.getY() < otherEdge.getStart().getY() && this.end.getY() > otherEdge.getStart().getY()) {
                    return new Point(this.start.getX(), otherEdge.getStart().getY());
                }
            }
        }

        if (isHorizontal()) {
            if (this.start.getY() > otherEdge.getStart().getY() && this.end.getY() < otherEdge.getEnd().getY()) {
                if (this.start.getX() < otherEdge.getStart().getX() && this.end.getX() > otherEdge.getStart().getX()) {
                    return new Point(otherEdge.getStart().getX(), this.start.getY());
                }
            }
        }

        return null;
    }

    private boolean canOverlapVerticallyWith(Edge otherEdge) {
        return isVertical()
                && otherEdge.isVertical()
                && this.start.getX() == otherEdge.getStart().getX();
    }

    private boolean canOverlapHorizontallyWith(Edge otherEdge) {
        return isHorizontal()
                && otherEdge.isHorizontal()
                && this.start.getY() == otherEdge.getStart().getY();
    }

    public AdjacencyType isAdjacentTo(Edge otherEdge) {
        if (this.equals(otherEdge)) {
            return AdjacencyType.PROPER;
        }

        if (canOverlapVerticallyWith(otherEdge)) {
            if (this.start.getY() > otherEdge.getStart().getY() && this.end.getY() < otherEdge.getEnd().getY()) {
                return AdjacencyType.SUB_LINE;
            }
            if (this.start.getY() > otherEdge.getStart().getY() && this.end.getY() > otherEdge.getEnd().getY()) {
                if (this.start.getY() < otherEdge.getEnd().getY()) {
                    return AdjacencyType.PARTIAL;
                }
            }
            if (this.start.getY() < otherEdge.getStart().getY() && this.end.getY() < otherEdge.getEnd().getY()) {
                if (this.end.getY() > otherEdge.getStart().getY()) {
                    return AdjacencyType.PARTIAL;
                }
            }
        }

        if (canOverlapHorizontallyWith(otherEdge)) {
            if (this.start.getX() > otherEdge.getStart().getX() && this.end.getX() < otherEdge.getEnd().getX()) {
                return AdjacencyType.SUB_LINE;
            }

            if (this.start.getX() > otherEdge.getStart().getX() && this.end.getX() > otherEdge.getEnd().getX()) {
                if (this.start.getX() < otherEdge.getEnd().getX()) {
                    return AdjacencyType.PARTIAL;
                }
            }
            if (this.start.getX() < otherEdge.getStart().getX() && this.end.getX() < otherEdge.getEnd().getX()) {
                if (this.end.getX() > otherEdge.getStart().getX()) {
                    return AdjacencyType.PARTIAL;
                }
            }
        }

        return AdjacencyType.NONE;
    }

    public boolean isHorizontal() {
        return this.start.getY() == this.end.getY();
    }

    public boolean isVertical() {
        return this.start.getX() == this.end.getX();
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

    public Point getEnd() {
        return end;
    }
}
