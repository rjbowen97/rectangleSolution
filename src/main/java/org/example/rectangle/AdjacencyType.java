package org.example.rectangle;

/**
 * Represents the type of adjacency between two rectangles.
 * SUB_LINE: The edge of a rectangle is entirely contained within the edge of another rectangle.
 * PROPER: The edge of a rectangle perfectly overlaps with the edge of another rectangle.
 * PARTIAL: The edge of a rectangle partially overlaps with the edge of another rectangle.
 * NONE: The edge of a rectangle does not overlap with the edge of another rectangle.
 */
public enum AdjacencyType {
    SUB_LINE, PROPER, PARTIAL, NONE
}
