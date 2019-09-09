package org.learn.FactoryPattern;

/**
 * @author: yxk
 * @date: 2019-04-12 16:37
 */
public class FactoryPatternDemo {

    public static void main(String[] args) {
        ShapeFactory shape = new ShapeFactory();

        Shape circle = shape.getShape("circle");
        circle.draw();

        Shape rectangle = shape.getShape("rectangle");
        rectangle.draw();

        Shape square = shape.getShape("square");
        square.draw();
    }
}
