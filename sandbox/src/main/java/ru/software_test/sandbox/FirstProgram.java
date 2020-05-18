package ru.software_test.sandbox;


public class FirstProgram {
    public static void main(String[] args) {

        Point p1 = new Point(1, 2);
        Point p2 = new Point(4, 5);
        System.out.println("Distance between point A(" + p1.x + "/" + p1.y + ") and point B(" + p2.x + "" + p2.y + ") is "
                + Point.distance(p1, p2));

    }


}
