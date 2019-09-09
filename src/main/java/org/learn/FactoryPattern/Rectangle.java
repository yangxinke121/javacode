package org.learn.FactoryPattern;

/**
 * @author: yxk
 * @date: 2019-04-12 16:33
 */
public class Rectangle implements Shape {
    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
