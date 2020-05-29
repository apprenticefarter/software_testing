package ru.software_test.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class EquationTests {
    @Test
    public void test1(){
        Equation lul = new Equation(1,2,3);
        Assert.assertEquals(lul.getN(),0);
    }
    @Test
    public void test2(){
        Equation lul = new Equation(1,4,1);
        Assert.assertEquals(lul.getN(),2);
    }
    @Test
    public void test3(){
        Equation lul = new Equation(1,2,1);
        Assert.assertEquals(lul.getN(),1);
    }
}
