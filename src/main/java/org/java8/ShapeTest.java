package org.java8;

import java.util.Map;
import java.util.Set;

public class ShapeTest {

    public static void main(String[] args) {

        Set<Map.Entry<Thread, StackTraceElement[]>> entries = Thread.getAllStackTraces().entrySet();
        for (Map.Entry<Thread, StackTraceElement[]> stack : entries) {
            Thread key = stack.getKey();
            StackTraceElement[] value = stack.getValue();
            System.out.println(key.getName());
            for (StackTraceElement stackTraceElement : value) {
                System.out.println(stackTraceElement);
            }
        }
    }
}
