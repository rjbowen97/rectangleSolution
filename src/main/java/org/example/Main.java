package org.example;

import org.example.cartesian.Point;
import org.example.rectangle.AdjacencyType;
import org.example.rectangle.Rectangle;
import org.example.rectangle.RectangleAnalyzer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * The Main class of the application.
 */
public class Main {
    /**
     * Takes a user-inputted list of 8 coordinate pairs, which then are used to create 2 Rectangles.
     * The function then outputs any intersection points between the two rectangles,
     * if the primary rectangle contains the other rectangle, and the type of adjacency the primary rectangle has
     * with the other rectangle.
     *
     * @param args A list of cartesian coordinates representing the corners of two rectangles. Each coordinate is
     *             separated by a space, and each value within the coordinate is separated by a comma.
     *             The primary rectangle is constructed from the first 4 coordinate pairs and the "other" rectangle is constructed
     *             from the last 4 coordinate pairs.
     *             e.g. "-10,-10 -10,10 10,-10 10,10 5,5 15,5 5,15 15,15"
     */
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
