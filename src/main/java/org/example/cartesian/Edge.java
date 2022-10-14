package org.example.cartesian;

import org.example.rectangle.AdjacencyType;

import java.util.Objects;

/**
 * Represents an edge (or, synonymously, a line) in a cartesian coordinate space.
 */
public class Edge {
    Point start;
    Point end;

    /**
     * Creates an edge with the specified start and end points
     *
     * @param start The starting point of the edge
     * @param end   The ending point of the edge
     */
    public Edge(Point start, Point end) {
        this.start = start;
        this.end = end;
    }

    /**
     * Checks if this edge intersects anywhere with another edge. If it does, it returns the point of intersection.
     * Otherwise, it returns null.
     *
     * @param otherEdge The edge to be checked for intersection
     * @return The point of intersection between this edge and the other edge. If there is no intersection, it returns null
     */
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

    /**
     * Checks if the edge is horizontal
     *
     * @return A boolean indicating if the edge is horizontal
     */
    public boolean isHorizontal() {
        return this.start.getY() == this.end.getY();
    }

    /**
     * Checks if the edge is vertical
     *
     * @return A boolean indicating if the edge is vertical
     */
    public boolean isVertical() {
        return this.start.getX() == this.end.getX();
    }

    /**
     * Checks if this edge is adjacent to another edge. See {@link AdjacencyType} for the types of adjacencies.
     * @param otherEdge The edge to be checked for adjacencies with this edge
     * @return The type of adjacency this edge has with the other edge
     */
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

    /**
     * Checks if this edge could possibly overlap vertically with the otherEdge
     * @param otherEdge The other edge
     * @return boolean
     */
    private boolean canOverlapVerticallyWith(Edge otherEdge) {
        return isVertical()
                && otherEdge.isVertical()
                && this.start.getX() == otherEdge.getStart().getX();
    }

    /**
     * Checks if this edge could possibly overlap horizontally with the otherEdge
     * @param otherEdge The other edge
     * @return boolean
     */
    private boolean canOverlapHorizontallyWith(Edge otherEdge) {
        return isHorizontal()
                && otherEdge.isHorizontal()
                && this.start.getY() == otherEdge.getStart().getY();
    }

    /**
     * The equals function of this class considers two edges to be equal if they have matching starting and ending points.
     * @param o The object being checked for equality with this object
     * @return boolean indicating if this edge and the given object are equal
     */
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

    /**
     * Used for checking if an edge is unique in a HashSet.
     * @return The hashcode generated from the start and end points.
     */
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
