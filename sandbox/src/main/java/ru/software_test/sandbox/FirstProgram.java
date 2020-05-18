package ru.software_test.sandbox;


public class FirstProgram {
    public static void main(String[] args) {
        hello("World");

        Square s = new Square(5);


        Rectangle r = new Rectangle(2,3);
        Point p1 = new Point(1,2);
        Point p2 = new Point(4,5);

        System.out.println("area of square with side " + s.l + " is " + s.area());
        System.out.println("area of rectangle with side A " + r.a + " and B " + r.b + " is " + r.area());
        System.out.println("Distance between point A(" + p1.x +"/"+ p1.y +") and point B("+ p2.x +"/"+ p2.y + ") is " + distance(p1,p2));

    }

    public static void hello(String name) {
        System.out.println("Hello " + name);
    }
    public static double distance(Point p1, Point p2){
        double distance = Math.pow((p2.x - p1.x) , 2) + Math.pow((p2.y - p1.y), 2);
    return Math.sqrt(distance);
    }


}
