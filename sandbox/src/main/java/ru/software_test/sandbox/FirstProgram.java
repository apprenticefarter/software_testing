package ru.software_test.sandbox;


public class FirstProgram {
    public static void main(String[] args) {
        hello("World");

        Square s = new Square(5);


        Rectangle r = new Rectangle(2,3);
        Point p = new Point(1,2,4,5);

        System.out.println("area of square with side " + s.l + " is " + s.area());
        System.out.println("area of rectangle with side A " + r.a + " and B " + r.b + " is " + r.area());
        System.out.println("Distance between point A(" + p.x1 +"/"+ p.y1 +") and point B("+ p.x2 +"/"+ p.y2 + ") is "
                + p.distance());

    }

    public static void hello(String name) {
        System.out.println("Hello " + name);
    }




}
