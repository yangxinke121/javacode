package org.learn.FactoryPattern;

/**
 * @author: yxk
 * @date: 2019-04-12 16:34
 */
public class Circle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}
