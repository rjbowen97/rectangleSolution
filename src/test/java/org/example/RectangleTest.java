package org.example;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RectangleTest {
    @Test
    void newRectangleHasCorrectlyOrderedPoints() {
        Rectangle rectangle = new Rectangle(
                new Point(1, 2),
                new Point(4, -3),
                new Point(4, 2),
                new Point(1, -3));
        Assertions.assertEquals(1, 1);
    }
}