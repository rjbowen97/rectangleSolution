package org.example.rectangle;

public class RectangleAnalyzer {

    public static boolean doRectanglesIntersect(Rectangle primaryRectangle, Rectangle otherRectangle) {

        int cornersOfOtherRectangleContainedByPrimaryRectangle = 0;

        if (primaryRectangle.contains(otherRectangle.getBottomLeftCorner())) {
            cornersOfOtherRectangleContainedByPrimaryRectangle++;
        }
        if (primaryRectangle.contains(otherRectangle.getBottomRightCorner())) {
            cornersOfOtherRectangleContainedByPrimaryRectangle++;
        }
        if (primaryRectangle.contains(otherRectangle.getTopLeftCorner())) {
            cornersOfOtherRectangleContainedByPrimaryRectangle++;
        }
        if (primaryRectangle.contains(otherRectangle.getTopRightCorner())) {
            cornersOfOtherRectangleContainedByPrimaryRectangle++;
        }

        return cornersOfOtherRectangleContainedByPrimaryRectangle == 1 || cornersOfOtherRectangleContainedByPrimaryRectangle == 2;
    }


}
