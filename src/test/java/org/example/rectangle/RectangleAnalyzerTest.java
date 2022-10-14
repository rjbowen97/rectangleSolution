package org.example.rectangle;

import org.example.cartesian.Point;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

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

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
        ArrayList<Point> invertedIntersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(otherRectangle, primaryRectangle);
        System.out.println(intersectionPoints);
        System.out.println(invertedIntersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertTrue(intersectionPoints.contains(new Point(5, 10)));
        assertTrue(intersectionPoints.contains(new Point(10, 5)));

        assertEquals(2, invertedIntersectionPoints.size());
        assertTrue(invertedIntersectionPoints.contains(new Point(5, 10)));
        assertTrue(invertedIntersectionPoints.contains(new Point(10, 5)));

        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle));
        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(otherRectangle, primaryRectangle));

    }

    @Test
    void intersectingRectanglesRight() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(5, -5));
        otherRectangleCorners.add(new Corner(15, -5));
        otherRectangleCorners.add(new Corner(5, 5));
        otherRectangleCorners.add(new Corner(15, 5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
        ArrayList<Point> invertedIntersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(otherRectangle, primaryRectangle);
        System.out.println(intersectionPoints);
        System.out.println(invertedIntersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertTrue(intersectionPoints.contains(new Point(10, 5)));
        assertTrue(intersectionPoints.contains(new Point(10, -5)));

        assertEquals(2, invertedIntersectionPoints.size());
        assertTrue(invertedIntersectionPoints.contains(new Point(10, 5)));
        assertTrue(invertedIntersectionPoints.contains(new Point(10, -5)));

        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle));
        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(otherRectangle, primaryRectangle));
    }

    @Test
    void intersectingRectanglesBottomRight() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(5, -15));
        otherRectangleCorners.add(new Corner(15, -15));
        otherRectangleCorners.add(new Corner(5, -5));
        otherRectangleCorners.add(new Corner(15, -5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
        ArrayList<Point> invertedIntersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(otherRectangle, primaryRectangle);
        System.out.println(intersectionPoints);
        System.out.println(invertedIntersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertTrue(intersectionPoints.contains(new Point(5, -10)));
        assertTrue(intersectionPoints.contains(new Point(10, -5)));

        assertEquals(2, invertedIntersectionPoints.size());
        assertTrue(invertedIntersectionPoints.contains(new Point(5, -10)));
        assertTrue(invertedIntersectionPoints.contains(new Point(10, -5)));

        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle));
        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(otherRectangle, primaryRectangle));
    }

    @Test
    void intersectingRectanglesBottom() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-5, -5));
        otherRectangleCorners.add(new Corner(-5, -15));
        otherRectangleCorners.add(new Corner(5, -5));
        otherRectangleCorners.add(new Corner(5, -15));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
        ArrayList<Point> invertedIntersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(otherRectangle, primaryRectangle);
        System.out.println(intersectionPoints);
        System.out.println(invertedIntersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertTrue(intersectionPoints.contains(new Point(-5, -10)));
        assertTrue(intersectionPoints.contains(new Point(5, -10)));

        assertEquals(2, invertedIntersectionPoints.size());
        assertTrue(invertedIntersectionPoints.contains(new Point(-5, -10)));
        assertTrue(invertedIntersectionPoints.contains(new Point(5, -10)));

        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle));
        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(otherRectangle, primaryRectangle));
    }

    @Test
    void intersectingRectanglesBottomLeft() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-15, -15));
        otherRectangleCorners.add(new Corner(-15, -5));
        otherRectangleCorners.add(new Corner(-5, -15));
        otherRectangleCorners.add(new Corner(-5, -5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
        ArrayList<Point> invertedIntersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(otherRectangle, primaryRectangle);
        System.out.println(intersectionPoints);
        System.out.println(invertedIntersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertTrue(intersectionPoints.contains(new Point(-5, -10)));
        assertTrue(intersectionPoints.contains(new Point(-10, -5)));

        assertEquals(2, invertedIntersectionPoints.size());
        assertTrue(invertedIntersectionPoints.contains(new Point(-5, -10)));
        assertTrue(invertedIntersectionPoints.contains(new Point(-10, -5)));

        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle));
        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(otherRectangle, primaryRectangle));
    }

    @Test
    void intersectingRectanglesLeft() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-15, -5));
        otherRectangleCorners.add(new Corner(-15, 5));
        otherRectangleCorners.add(new Corner(-5, -5));
        otherRectangleCorners.add(new Corner(-5, 5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
        ArrayList<Point> invertedIntersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(otherRectangle, primaryRectangle);
        System.out.println(intersectionPoints);
        System.out.println(invertedIntersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertTrue(intersectionPoints.contains(new Point(-10, 5)));
        assertTrue(intersectionPoints.contains(new Point(-10, -5)));

        assertEquals(2, invertedIntersectionPoints.size());
        assertTrue(invertedIntersectionPoints.contains(new Point(-10, 5)));
        assertTrue(invertedIntersectionPoints.contains(new Point(-10, -5)));

        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle));
        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(otherRectangle, primaryRectangle));
    }

    @Test
    void intersectingRectanglesTopLeft() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-15, 5));
        otherRectangleCorners.add(new Corner(-15, 15));
        otherRectangleCorners.add(new Corner(-5, 5));
        otherRectangleCorners.add(new Corner(-5, 15));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
        ArrayList<Point> invertedIntersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(otherRectangle, primaryRectangle);
        System.out.println(intersectionPoints);
        System.out.println(invertedIntersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertTrue(intersectionPoints.contains(new Point(-10, 5)));
        assertTrue(intersectionPoints.contains(new Point(-5, 10)));

        assertEquals(2, invertedIntersectionPoints.size());
        assertTrue(invertedIntersectionPoints.contains(new Point(-10, 5)));
        assertTrue(invertedIntersectionPoints.contains(new Point(-5, 10)));

        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle));
        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(otherRectangle, primaryRectangle));
    }

    @Test
    void intersectingRectanglesTop() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-5, 5));
        otherRectangleCorners.add(new Corner(-5, 15));
        otherRectangleCorners.add(new Corner(5, 5));
        otherRectangleCorners.add(new Corner(5, 15));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
        ArrayList<Point> invertedIntersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(otherRectangle, primaryRectangle);
        System.out.println(intersectionPoints);
        System.out.println(invertedIntersectionPoints);

        assertEquals(2, intersectionPoints.size());
        assertTrue(intersectionPoints.contains(new Point(-5, 10)));
        assertTrue(intersectionPoints.contains(new Point(5, 10)));

        assertEquals(2, invertedIntersectionPoints.size());
        assertTrue(invertedIntersectionPoints.contains(new Point(-5, 10)));
        assertTrue(invertedIntersectionPoints.contains(new Point(5, 10)));

        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle));
        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(otherRectangle, primaryRectangle));
    }

    @Test
    void nonIntersectingNonContainedRectangles() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(20, 30));
        otherRectangleCorners.add(new Corner(20, 50));
        otherRectangleCorners.add(new Corner(40, 30));
        otherRectangleCorners.add(new Corner(40, 50));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
        ArrayList<Point> invertedIntersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(otherRectangle, primaryRectangle);
        System.out.println(intersectionPoints);
        System.out.println(invertedIntersectionPoints);

        assertEquals(intersectionPoints.size(), 0);
        assertEquals(invertedIntersectionPoints.size(), 0);

        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle));
        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(otherRectangle, primaryRectangle));

    }

    @Test
    void containedRectangle() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-5, 5));
        otherRectangleCorners.add(new Corner(-5, -5));
        otherRectangleCorners.add(new Corner(5, 5));
        otherRectangleCorners.add(new Corner(5, -5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
        ArrayList<Point> invertedIntersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(otherRectangle, primaryRectangle);
        System.out.println(intersectionPoints);
        System.out.println(invertedIntersectionPoints);

        assertEquals(intersectionPoints.size(), 0);
        assertEquals(invertedIntersectionPoints.size(), 0);

        assertTrue(RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle));
    }

    // Adjacency Tests
    @Test
    void adjacentRectanglesRightSubLine() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(10, -5));
        otherRectangleCorners.add(new Corner(15, -5));
        otherRectangleCorners.add(new Corner(10, 5));
        otherRectangleCorners.add(new Corner(15, 5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
        ArrayList<Point> invertedIntersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(otherRectangle, primaryRectangle);
        System.out.println(intersectionPoints);
        System.out.println(invertedIntersectionPoints);

        assertEquals(0, intersectionPoints.size());
        assertEquals(0, invertedIntersectionPoints.size());

        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle));
        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(otherRectangle, primaryRectangle));

        System.out.println(intersectionPoints);
        ArrayList<AdjacencyType> rectangleAdjacencies = RectangleAnalyzer.getRectangleAdjacencies(primaryRectangle, otherRectangle);
        System.out.println(rectangleAdjacencies);


        assertTrue(rectangleAdjacencies.contains(AdjacencyType.SUB_LINE));

    }

    @Test
    void adjacentRectanglesRightProper() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(10, 10));
        otherRectangleCorners.add(new Corner(15, -10));
        otherRectangleCorners.add(new Corner(10, -10));
        otherRectangleCorners.add(new Corner(15, 10));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        ArrayList<Point> intersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(primaryRectangle, otherRectangle);
        ArrayList<Point> invertedIntersectionPoints = RectangleAnalyzer.getRectangleIntersectionPoints(otherRectangle, primaryRectangle);
        System.out.println(intersectionPoints);
        System.out.println(invertedIntersectionPoints);

        assertEquals(0, intersectionPoints.size());
        assertEquals(0, invertedIntersectionPoints.size());

        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(primaryRectangle, otherRectangle));
        assertFalse(RectangleAnalyzer.doesRectangleContainOtherRectangle(otherRectangle, primaryRectangle));

        System.out.println(intersectionPoints);
        ArrayList<AdjacencyType> rectangleAdjacencies = RectangleAnalyzer.getRectangleAdjacencies(primaryRectangle, otherRectangle);
        System.out.println(rectangleAdjacencies);


        assertTrue(rectangleAdjacencies.contains(AdjacencyType.PROPER));

    }


}