package ru.software_test.sandbox;


public class FirstProgram {
    public static void main(String[] args) {
        hello("World");

        Square s = new Square(5);


        Rectangle r = new Rectangle(2,3);


        System.out.println("area of square with side " + s.l + " is " + area(s));
        System.out.println("area of rectangle with side A " + r.a + " and B " + r.b + " is " + area(r));

    }

    public static void hello(String name) {
        System.out.println("Hello " + name);
    }

    public static double area(Square s) {
        return s.l * s.l;
    }

    public static double area(Rectangle r) {
        return r.a * r.b;
    }
}
