package org.example.rectangle;

import org.example.cartesian.Edge;
import org.example.cartesian.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class RectangleAnalyzer {
    /**
     * Using the edges of the two input rectangles, this function checks if any of the edges intersect and, if they do,
     * returns the points representing said intersections.
     * @param primaryRectangle
     * @param otherRectangle
     * @return The points at which the two rectangles intersect, or an empty list if no intersections are present.
     */
    public static ArrayList<Point> getRectangleIntersectionPoints(Rectangle primaryRectangle, Rectangle otherRectangle) {

        ArrayList<Edge> primaryRectangleEdges = primaryRectangle.getEdges();
        ArrayList<Edge> otherRectangleEdges = otherRectangle.getEdges();

        ArrayList<Point> intersections = new ArrayList<>();

        primaryRectangleEdges.forEach((currentPrimaryRectangleEdge) -> {
            otherRectangleEdges.forEach((currentOtherRectangleEdge) -> {
                intersections.add(currentPrimaryRectangleEdge.intersects(currentOtherRectangleEdge));
            });
        });

        intersections.removeIf(Objects::isNull);

        return intersections;
    }

    /**
     * Checks if the primaryRectangle entirely contains the otherRectangle using the points of the otherRectangle.
     * @param primaryRectangle
     * @param otherRectangle
     * @return boolean indicating containment of the otherRectangle by the primaryRectangle.
     */
    public static boolean doesRectangleContainOtherRectangle(Rectangle primaryRectangle, Rectangle otherRectangle) {
        AtomicInteger pointsContainedByPrimaryRectangle = new AtomicInteger();

        otherRectangle.getPoints().forEach((currentPoint) -> {
            if (primaryRectangle.contains(currentPoint)) {
                pointsContainedByPrimaryRectangle.getAndIncrement();
            }
        });

        return pointsContainedByPrimaryRectangle.get() == 4;
    }

    /**
     * Checks if the edges of two rectangles share any adjacencies with one another.
     * See {@link AdjacencyType} for the definitions of adjacencies.
     * @param primaryRectangle
     * @param otherRectangle
     * @return The {@link AdjacencyType} shared between the two rectangles.
     */
    public static HashSet<AdjacencyType> getRectangleAdjacencies(Rectangle primaryRectangle, Rectangle otherRectangle) {
        ArrayList<Edge> primaryRectangleEdges = primaryRectangle.getEdges();
        ArrayList<Edge> otherRectangleEdges = otherRectangle.getEdges();

        HashSet<AdjacencyType> adjacencies = new HashSet<>();

        primaryRectangleEdges.forEach((currentPrimaryRectangleEdge) -> {
            otherRectangleEdges.forEach((currentOtherRectangleEdge) -> {
                AdjacencyType currentEdgeAdjacencyType = currentPrimaryRectangleEdge.isAdjacentTo(currentOtherRectangleEdge);
                if (currentEdgeAdjacencyType != AdjacencyType.NONE) {
                    adjacencies.add(currentEdgeAdjacencyType);
                }
            });
        });

        if (adjacencies.size() == 0) {
            otherRectangleEdges.forEach((currentOtherRectangleEdge) -> {
                primaryRectangleEdges.forEach((currentPrimaryRectangleEdge) -> {
                    AdjacencyType currentEdgeAdjacencyType = currentOtherRectangleEdge.isAdjacentTo(currentPrimaryRectangleEdge);
                    if (currentEdgeAdjacencyType != AdjacencyType.NONE) {
                        adjacencies.add(currentEdgeAdjacencyType);
                    }
                });
            });
        }

        if (adjacencies.size() == 0) {
            adjacencies.add(AdjacencyType.NONE);
        }

        return adjacencies;
    }
}
