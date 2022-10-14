package org.example.rectangle;

import org.example.cartesian.Edge;
import org.example.cartesian.Point;

import java.util.ArrayList;
import java.util.Collections;

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

        intersections.removeAll(Collections.singleton(null));


        return intersections;
    }


}
