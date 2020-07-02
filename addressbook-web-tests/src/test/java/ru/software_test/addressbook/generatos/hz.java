package ru.software_test.addressbook.generatos;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class hz {
    public static void main(String []args ){
        Integer x = 0;
        Set<Integer> numbers = new HashSet<>();
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);
        Iterator<Integer> iterator = numbers.iterator();
        while (iterator.hasNext()){
            x = iterator.next();
        }
        System.out.println(x);
    }
}
