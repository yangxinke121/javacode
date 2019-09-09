package org.learn.strategypattern;

/**
 * @author: yxk
 * @date: 2019-04-09 17:26
 */
public class StrategyPatternDemo {

    public static void main(String[] args) {

        Context context = new Context(new OperationAdd());
        System.out.println("7 + 23 = " +context.executeOperation(7, 23));

        context = new Context(new OperationSubstract());
        System.out.println("7 - 23 = " + context.executeOperation(7, 23));

        context = new Context(new OperationMultiply());
        System.out.println("7 * 23 = " + context.executeOperation(7, 23));
    }
}
