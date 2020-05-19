package ru.software_test.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class Tests {
    @Test
    public void testArea() {
        Square s = new Square(5);
        Assert.assertEquals(s.area(), 25);

    }

    @Test
    public void testRecrtangle() {
        Rectangle r = new Rectangle(3, 4);
        Assert.assertEquals(r.area(), 12);
    }

    @Test
    public void testDistance() {
        Point p1 = new Point(1,3);
        Point p2 = new Point(5,7);
        Assert.assertEquals(p1.distance(p2), 5.656854249492381
        );
    }

}
