package com.cybertek.utilities;

public class Example {

    public static void main(String[] args) {

        String one = Singleton.get();

        System.out.println("One: "+one);

        String two = Singleton.get();

        System.out.println("Two: "+two);

        String three = Singleton.get();

        System.out.println("Three: "+three);

    }
}
