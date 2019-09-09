package org.learn.templatepatterndemo;


/**
 * @author: yxk
 * @date: 2019-04-10 17:31
 */
public class TemplatePatternDemo {


    private TemplatePatternDemo() {
    }

    public static void main(String[] args) {

        Game cricket = new Cricket();
        cricket.play();

        System.out.println();

        cricket = new FootBall();
        cricket.play();
    }
}
