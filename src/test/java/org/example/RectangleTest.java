package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RectangleTest {

    ArrayList<Point> pointsFormingValidRectangle;

    @BeforeEach
    void setUp() {
        pointsFormingValidRectangle = new ArrayList<>();
        pointsFormingValidRectangle.add(new Point(1, 2));
        pointsFormingValidRectangle.add(new Point(4, -3));
        pointsFormingValidRectangle.add(new Point(4, 2));
        pointsFormingValidRectangle.add(new Point(1, -3));
    }

    @Test
    void newRectangleHasCorrectlyOrderedPoints() {
        System.out.println(pointsFormingValidRectangle);
        Rectangle rectangle = new Rectangle(pointsFormingValidRectangle);
        System.out.println(rectangle);

        assertEquals(rectangle.getBottomLeftPoint().getX(), 1);
        assertEquals(rectangle.getBottomLeftPoint().getY(), -3);
        assertEquals(rectangle.getTopRightPoint().getX(), 4);
        assertEquals(rectangle.getTopRightPoint().getY(), 2);

    }
}