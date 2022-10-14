package org.example.rectangle;

import org.example.cartesian.Edge;
import org.example.cartesian.Point;

import java.util.ArrayList;
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


}
