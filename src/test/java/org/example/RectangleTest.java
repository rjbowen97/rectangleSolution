package org.example;

import org.example.rectangle.Corner;
import org.example.rectangle.Rectangle;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class RectangleTest {

    ArrayList<Corner> validRectangleCorners;
    ArrayList<Corner> tooFewCorners;
    ArrayList<Corner> tooManyCorners;

    @BeforeEach
    void setUp() {
        System.out.println("START - Test Setup");
        validRectangleCorners = new ArrayList<>();
        validRectangleCorners.add(new Corner(1, 2));
        validRectangleCorners.add(new Corner(4, -3));
        validRectangleCorners.add(new Corner(4, 2));
        validRectangleCorners.add(new Corner(1, -3));

        tooFewCorners = new ArrayList<>(validRectangleCorners);
        tooFewCorners.remove(0);

        tooManyCorners = new ArrayList<>(validRectangleCorners);
        tooManyCorners.add(new Corner(1, -3));


        System.out.println(validRectangleCorners);
        System.out.println(tooManyCorners);
        System.out.println(tooFewCorners);

        System.out.println("END - Test Setup");


    }

    @Test
    void newRectangleHasCorrectlyOrderedCornersAndEdges() throws Rectangle.RectangleException {
        Rectangle rectangle = new Rectangle(validRectangleCorners);

        assertEquals(rectangle.getBottomLeftCorner().getX(), 1);
        assertEquals(rectangle.getBottomLeftCorner().getY(), -3);

        assertEquals(rectangle.getTopLeftCorner().getX(), 1);
        assertEquals(rectangle.getTopLeftCorner().getY(), 2);

        assertEquals(rectangle.getTopRightCorner().getX(), 4);
        assertEquals(rectangle.getTopRightCorner().getY(), 2);

        assertEquals(rectangle.getBottomRightCorner().getX(), 4);
        assertEquals(rectangle.getBottomRightCorner().getY(), -3);

        assertEquals(rectangle.getTopEdge().getStart(), rectangle.getTopLeftCorner());
        assertEquals(rectangle.getTopEdge().getEnd(), rectangle.getTopRightCorner());

        assertEquals(rectangle.getRightEdge().getStart(), rectangle.getBottomRightCorner());
        assertEquals(rectangle.getRightEdge().getEnd(), rectangle.getTopRightCorner());

        assertEquals(rectangle.getBottomEdge().getStart(), rectangle.getBottomLeftCorner());
        assertEquals(rectangle.getBottomEdge().getEnd(), rectangle.getBottomRightCorner());

        assertEquals(rectangle.getLeftEdge().getStart(), rectangle.getBottomLeftCorner());
        assertEquals(rectangle.getLeftEdge().getEnd(), rectangle.getTopLeftCorner());

    }

    @Test
    void rectangleWithDuplicateCornersThrowsException() {
        ArrayList<Corner> duplicateCorners = new ArrayList<>();
        duplicateCorners.add(new Corner(1, 2));
        duplicateCorners.add(new Corner(1, 2));
        duplicateCorners.add(new Corner(1, 2));
        duplicateCorners.add(new Corner(1, 2));


        assertThrows(Rectangle.RectangleException.class, () -> {
            new Rectangle(duplicateCorners);
        });
    }

    @Test
    void rectangleWithTooFewCornersThrowsException() {
        assertThrows(Rectangle.RectangleException.class, () -> {
            new Rectangle(tooFewCorners);
        });
    }

    @Test
    void rectangleWithTooManyCornersThrowsException() throws Rectangle.RectangleException {
        assertThrows(Rectangle.RectangleException.class, () -> {
            new Rectangle(tooManyCorners);
        });
    }
}