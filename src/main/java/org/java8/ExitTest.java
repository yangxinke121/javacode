package org.java8;

public class ExitTest {

    public static void main(String[] args) {

        try {
            System.exit(11);
        } catch (Exception e) {

        } finally {
            System.out.println(11);
        }
    }
}
