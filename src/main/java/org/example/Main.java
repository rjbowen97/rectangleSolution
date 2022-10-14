package org.example;

import org.example.cartesian.Point;
import org.example.rectangle.AdjacencyType;
import org.example.rectangle.Rectangle;
import org.example.rectangle.RectangleAnalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        ArrayList<Point> inputRectanglePoints = new ArrayList<>();

        if (args.length > 0) {
            for (String currentArg : args) {
                System.out.println(currentArg);
                List<String> currentArgSplitOnComma = Arrays.asList(currentArg.split(","));
                int currentArgXValue = Integer.parseInt(currentArgSplitOnComma.get(0));
                int currentArgYValue = Integer.parseInt(currentArgSplitOnComma.get(1));
                inputRectanglePoints.add(new Point(currentArgXValue, currentArgYValue));
            }

            try {
                Rectangle primaryRectangle = new Rectangle(inputRectanglePoints.subList(0, 4));
                Rectangle otherRectangle = new Rectangle(inputRectanglePoints.subList(4, 8));

                ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
                boolean doesRectangleContainOtherRectangle = RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle);
                HashSet<AdjacencyType> adjacencyTypes = RectangleAnalyzer.getRectangleAdjacencies(primaryRectangle, otherRectangle);

                System.out.println("Rectangle 1 has the following relationships to Rectangle 2: ");
                System.out.println("Intersection Points: " + intersectionPoints);
                System.out.println("Rectangle 1 contains Rectangle 2: " + doesRectangleContainOtherRectangle);
                System.out.println("Rectangle 1 adjacency with Rectangle 2: " + adjacencyTypes);
            } catch (Rectangle.RectangleException e) {
                throw new RuntimeException(e);
            }
        }

        System.out.println(inputRectanglePoints);
    }
}
