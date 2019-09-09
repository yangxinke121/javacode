package org.java8;

public class TestTry {

    public static int fun() {
        int i = 10;
        try {
            i = i / 0;
            return --i;
        } catch (Exception e) {
            --i;
            return i--;
        } finally {
            --i;
            return i--;
        }
    }

    public static void main(String[] args) {
        System.out.println(fun());
    }
}
