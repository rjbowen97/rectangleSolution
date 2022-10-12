package org.example;

public class Main {
    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle(
                new Point(1, 2),
                new Point(4, -3),
                new Point(4, 2),
                new Point(1, -3));

        System.out.println(rectangle);
    }
}
