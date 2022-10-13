package org.example.rectangle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

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
    void doRectanglesIntersectTopRight() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(5, 5));
        otherRectangleCorners.add(new Corner(15, 5));
        otherRectangleCorners.add(new Corner(5, 15));
        otherRectangleCorners.add(new Corner(15, 15));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        boolean rectanglesAreIntersecting = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        assertTrue(rectanglesAreIntersecting);

    }

    @Test
    void doRectanglesIntersectRight() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(5,-5));
        otherRectangleCorners.add(new Corner(15,-5));
        otherRectangleCorners.add(new Corner(5,5));
        otherRectangleCorners.add(new Corner(15,5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        boolean rectanglesAreIntersecting = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        assertTrue(rectanglesAreIntersecting);

    }

    @Test
    void doRectanglesIntersectBottomRight() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(5,-15));
        otherRectangleCorners.add(new Corner(15,-15));
        otherRectangleCorners.add(new Corner(5,-5));
        otherRectangleCorners.add(new Corner(15,-5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        boolean rectanglesAreIntersecting = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        assertTrue(rectanglesAreIntersecting);

    }

    @Test
    void doRectanglesIntersectBottom() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-5,-5));
        otherRectangleCorners.add(new Corner(-5,-15));
        otherRectangleCorners.add(new Corner(5,-5));
        otherRectangleCorners.add(new Corner(5,-15));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        boolean rectanglesAreIntersecting = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        assertTrue(rectanglesAreIntersecting);

    }

    @Test
    void doRectanglesIntersectBottomLeft() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-15,-15));
        otherRectangleCorners.add(new Corner(-15,-5));
        otherRectangleCorners.add(new Corner(-5,-15));
        otherRectangleCorners.add(new Corner(-5,-5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        boolean rectanglesAreIntersecting = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        assertTrue(rectanglesAreIntersecting);

    }

    @Test
    void doRectanglesIntersectLeft() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-15,-5));
        otherRectangleCorners.add(new Corner(-15,5));
        otherRectangleCorners.add(new Corner(-5,-5));
        otherRectangleCorners.add(new Corner(-5,5));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        boolean rectanglesAreIntersecting = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        assertTrue(rectanglesAreIntersecting);

    }

    @Test
    void doRectanglesIntersectTopLeft() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-15,5));
        otherRectangleCorners.add(new Corner(-15,15));
        otherRectangleCorners.add(new Corner(-5,5));
        otherRectangleCorners.add(new Corner(-5,15));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        boolean rectanglesAreIntersecting = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        assertTrue(rectanglesAreIntersecting);

    }

    @Test
    void doRectanglesIntersectTop() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(-5,5));
        otherRectangleCorners.add(new Corner(-5,15));
        otherRectangleCorners.add(new Corner(5,5));
        otherRectangleCorners.add(new Corner(5,15));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        boolean rectanglesAreIntersecting = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        assertTrue(rectanglesAreIntersecting);

    }

    @Test
    void nonIntersectingRectangles() throws Rectangle.RectangleException {
        ArrayList<Corner> otherRectangleCorners = new ArrayList<>();
        otherRectangleCorners.add(new Corner(20,30));
        otherRectangleCorners.add(new Corner(20,50));
        otherRectangleCorners.add(new Corner(40,30));
        otherRectangleCorners.add(new Corner(40,50));

        Rectangle otherRectangle = new Rectangle(otherRectangleCorners);

        boolean rectanglesAreIntersecting = RectangleAnalyzer.doRectanglesIntersect(primaryRectangle, otherRectangle);
        assertFalse(rectanglesAreIntersecting);

    }
}