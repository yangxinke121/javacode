package org.java8;

public class StaticTest {

    public static int a = 0;

    public static void say() {
        System.out.println("hhh");
    }

    public StaticTest() {
        System.out.println("cons");
    }

    static {
        System.out.println("static");
    }

    {
        System.out.println("normal");
    }
}
