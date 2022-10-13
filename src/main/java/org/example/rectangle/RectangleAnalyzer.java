package org.example.rectangle;

public class RectangleAnalyzer {

    public static boolean doRectanglesIntersect(Rectangle primaryRectangle, Rectangle otherRectangle) {

        if (otherRectangle.getLowerX() > primaryRectangle.getLowerX() && otherRectangle.getLowerX() < primaryRectangle.getUpperX()) {
            if (otherRectangle.getUpperY() > primaryRectangle.getLowerY() && otherRectangle.getUpperY() < primaryRectangle.getUpperY()) {
                return true;
            }
        }

        return false;
    }


}
