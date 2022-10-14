package org.example.rectangle;

import org.example.cartesian.Edge;
import org.example.cartesian.Point;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class RectangleAnalyzer {

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

    public static boolean doesRectangleContainOtherRectangle(Rectangle primaryRectangle, Rectangle otherRectangle) {
        AtomicInteger cornersContainedByPrimaryRectangle = new AtomicInteger();

        otherRectangle.getCorners().forEach((currentCorner) -> {
            if (primaryRectangle.contains(currentCorner)) {
                cornersContainedByPrimaryRectangle.getAndIncrement();
            }
        });

        return cornersContainedByPrimaryRectangle.get() == 4;
    }

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

        return adjacencies;


    }


}
