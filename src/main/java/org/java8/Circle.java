package org.java8;

public class Circle extends Shape {

    private int radius = 47;

    @Override
    public void draw() {
        System.out.println("Circle draw radius " + radius);
    }


    public static void main(String[] args) {
        Circle circle = new Circle();
        circle.draw();
    }
}
