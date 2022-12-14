package org.example;

import org.example.cartesian.Point;
import org.example.rectangle.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {

    ArrayList<Point> validRectanglePoints;
    ArrayList<Point> tooFewPoints;
    ArrayList<Point> tooManyPoints;

    @BeforeEach
    void setUp() {
        System.out.println("START - Test Setup");
        validRectanglePoints = new ArrayList<>();
        validRectanglePoints.add(new Point(1, 2));
        validRectanglePoints.add(new Point(4, -3));
        validRectanglePoints.add(new Point(4, 2));
        validRectanglePoints.add(new Point(1, -3));

        tooFewPoints = new ArrayList<>(validRectanglePoints);
        tooFewPoints.remove(0);

        tooManyPoints = new ArrayList<>(validRectanglePoints);
        tooManyPoints.add(new Point(1, -3));

        System.out.println(validRectanglePoints);
        System.out.println(tooManyPoints);
        System.out.println(tooFewPoints);

        System.out.println("END - Test Setup");
    }

    @Test
    void newRectangleHasCorrectlyOrderedPointsAndEdges() throws Rectangle.RectangleException {
        Rectangle rectangle = new Rectangle(validRectanglePoints);

        assertEquals(rectangle.getBottomLeftPoint().getX(), 1);
        assertEquals(rectangle.getBottomLeftPoint().getY(), -3);

        assertEquals(rectangle.getTopLeftPoint().getX(), 1);
        assertEquals(rectangle.getTopLeftPoint().getY(), 2);

        assertEquals(rectangle.getTopRightPoint().getX(), 4);
        assertEquals(rectangle.getTopRightPoint().getY(), 2);

        assertEquals(rectangle.getBottomRightPoint().getX(), 4);
        assertEquals(rectangle.getBottomRightPoint().getY(), -3);

        assertEquals(rectangle.getTopEdge().getStart(), rectangle.getTopLeftPoint());
        assertEquals(rectangle.getTopEdge().getEnd(), rectangle.getTopRightPoint());

        assertEquals(rectangle.getRightEdge().getStart(), rectangle.getBottomRightPoint());
        assertEquals(rectangle.getRightEdge().getEnd(), rectangle.getTopRightPoint());

        assertEquals(rectangle.getBottomEdge().getStart(), rectangle.getBottomLeftPoint());
        assertEquals(rectangle.getBottomEdge().getEnd(), rectangle.getBottomRightPoint());

        assertEquals(rectangle.getLeftEdge().getStart(), rectangle.getBottomLeftPoint());
        assertEquals(rectangle.getLeftEdge().getEnd(), rectangle.getTopLeftPoint());
    }

    @Test
    void rectangleWithDuplicatePointsThrowsException() {
        ArrayList<Point> duplicatePoints = new ArrayList<>();
        duplicatePoints.add(new Point(1, 2));
        duplicatePoints.add(new Point(1, 2));
        duplicatePoints.add(new Point(1, 2));
        duplicatePoints.add(new Point(1, 2));

        assertThrows(Rectangle.RectangleException.class, () -> {
            new Rectangle(duplicatePoints);
        });
    }

    @Test
    void rectangleWithTooFewPointsThrowsException() {
        assertThrows(Rectangle.RectangleException.class, () -> {
            new Rectangle(tooFewPoints);
        });
    }

    @Test
    void rectangleWithTooManyPointsThrowsException() throws Rectangle.RectangleException {
        assertThrows(Rectangle.RectangleException.class, () -> {
            new Rectangle(tooManyPoints);
        });
    }
}