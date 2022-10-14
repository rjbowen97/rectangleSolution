package org.example.rectangle;

import org.example.cartesian.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleAnalyzerTest {

    Rectangle primaryRectangle;

    @BeforeEach
    void setUp() throws Rectangle.RectangleException {
        ArrayList<Corner> primaryRectangleCorners = new ArrayList<>();
        primaryRectangleCorners.add(new Corner(-10, -10));
        primaryRectangleCorners.add(new Corner(-10, 10));
        primaryRectangleCorners.add(new Corner(10, -10));
        primaryRectangleCorners.add(new Corner(10, 10));

        primaryRectangle = new Rectangle(primaryRectangleCorners);
    }

    @Test
    void intersectingRectanglesTopRight() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(5, 5));
        otherRectangleCorners.add(new Corner(15, 5));
        otherRectangleCorners.add(new Corner(5, 15));
        otherRectangleCorners.add(new Corner(15, 15));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        System.out.println(intersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertEquals(new Point(0, 0), intersectionPoints.get(0));
        assertEquals(new Point(0, 0), intersectionPoints.get(1));

    }

    @Test
    void intersectingRectanglesRight() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(5, -5));
        otherRectangleCorners.add(new Corner(15, -5));
        otherRectangleCorners.add(new Corner(5, 5));
        otherRectangleCorners.add(new Corner(15, 5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        System.out.println(intersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertEquals(new Point(0, 0), intersectionPoints.get(0));
        assertEquals(new Point(0, 0), intersectionPoints.get(1));
    }

    @Test
    void intersectingRectanglesBottomRight() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(5, -15));
        otherRectangleCorners.add(new Corner(15, -15));
        otherRectangleCorners.add(new Corner(5, -5));
        otherRectangleCorners.add(new Corner(15, -5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        System.out.println(intersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertEquals(new Point(0, 0), intersectionPoints.get(0));
        assertEquals(new Point(0, 0), intersectionPoints.get(1));
    }

    @Test
    void intersectingRectanglesBottom() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-5, -5));
        otherRectangleCorners.add(new Corner(-5, -15));
        otherRectangleCorners.add(new Corner(5, -5));
        otherRectangleCorners.add(new Corner(5, -15));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        System.out.println(intersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertEquals(new Point(0, 0), intersectionPoints.get(0));
        assertEquals(new Point(0, 0), intersectionPoints.get(1));
    }

    @Test
    void intersectingRectanglesBottomLeft() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-15, -15));
        otherRectangleCorners.add(new Corner(-15, -5));
        otherRectangleCorners.add(new Corner(-5, -15));
        otherRectangleCorners.add(new Corner(-5, -5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        System.out.println(intersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertEquals(new Point(0, 0), intersectionPoints.get(0));
        assertEquals(new Point(0, 0), intersectionPoints.get(1));
    }

    @Test
    void intersectingRectanglesLeft() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-15, -5));
        otherRectangleCorners.add(new Corner(-15, 5));
        otherRectangleCorners.add(new Corner(-5, -5));
        otherRectangleCorners.add(new Corner(-5, 5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        System.out.println(intersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertEquals(new Point(0, 0), intersectionPoints.get(0));
        assertEquals(new Point(0, 0), intersectionPoints.get(1));
    }

    @Test
    void intersectingRectanglesTopLeft() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-15, 5));
        otherRectangleCorners.add(new Corner(-15, 15));
        otherRectangleCorners.add(new Corner(-5, 5));
        otherRectangleCorners.add(new Corner(-5, 15));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        System.out.println(intersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertEquals(new Point(0, 0), intersectionPoints.get(0));
        assertEquals(new Point(0, 0), intersectionPoints.get(1));
    }

    @Test
    void intersectingRectanglesTop() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-5, 5));
        otherRectangleCorners.add(new Corner(-5, 15));
        otherRectangleCorners.add(new Corner(5, 5));
        otherRectangleCorners.add(new Corner(5, 15));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        System.out.println(intersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertEquals(new Point(0, 0), intersectionPoints.get(0));
        assertEquals(new Point(0, 0), intersectionPoints.get(1));
    }

    @Test
    void nonIntersectingRectangles() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(20, 30));
        otherRectangleCorners.add(new Corner(20, 50));
        otherRectangleCorners.add(new Corner(40, 30));
        otherRectangleCorners.add(new Corner(40, 50));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        System.out.println(intersectionPoints);

        assertEquals(intersectionPoints.size(), 0);
    }
}