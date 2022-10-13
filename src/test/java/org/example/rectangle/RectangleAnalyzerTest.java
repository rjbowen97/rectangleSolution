package org.example.rectangle;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertTrue;

class RectangleAnalyzerTest {

    @Test
    void doRectanglesIntersect() throws Rectangle.RectangleException {

        ArrayList<Corner> validRectangleCorners1 = new ArrayList<>();
        validRectangleCorners1.add(new Corner(1, 2));
        validRectangleCorners1.add(new Corner(4, -3));
        validRectangleCorners1.add(new Corner(4, 2));
        validRectangleCorners1.add(new Corner(1, -3));

        Rectangle rectangle1 = new Rectangle(validRectangleCorners1);

        ArrayList<Corner> validRectangleCorners2 = new ArrayList<>();
        validRectangleCorners2.add(new Corner(2, 1));
        validRectangleCorners2.add(new Corner(3, 1));
        validRectangleCorners2.add(new Corner(2, -2));
        validRectangleCorners2.add(new Corner(3, -2));

        Rectangle rectangle2 = new Rectangle(validRectangleCorners2);

        boolean rectanglesAreIntersecting = RectangleAnalyzer.doRectanglesIntersect(rectangle1, rectangle2);
        assertTrue(rectanglesAreIntersecting);

    }
}