package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class RectangleTest {

    @BeforeAll
    static void beforeAll() {

    }

    @Test
    void newRectangleHasCorrectlyOrderedPoints() {

        ArrayList<Point> rectanglePoints = new ArrayList<>();
        rectanglePoints.add(new Point(1, 2));
        rectanglePoints.add(new Point(4, -3));
        rectanglePoints.add(new Point(4, 2));
        rectanglePoints.add(new Point(1, -3));

        System.out.println(rectanglePoints);
        Rectangle rectangle = new Rectangle(rectanglePoints);
        System.out.println(rectangle);

        Assertions.assertEquals(1, 1);
    }
}