package ru.software_test.sandbox;


public class FirstProgram {
    public static void main(String[] args) {
       hello("World");

       double l = 5;
        System.out.println("area of square with side " + l + " is " +area(l));
    double a = 2;
    double b = 3;
        System.out.println("area of rectangle with side A " + a + " and B " + b +" is " +area(a,b));

    }
    public static void hello(String name){
        System.out.println("Hello " + name);
    }
    public static double area(double len){
        return len * len;
    }

    public static double area(double a,double b){
        return a * b;
    }
}
