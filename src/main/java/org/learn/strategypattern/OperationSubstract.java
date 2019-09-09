package org.learn.strategypattern;

/**
 * @author: yxk
 * @date: 2019-04-09 17:23
 */
public class OperationSubstract implements Strategy {
    @Override
    public int doOperation(int num1, int num2) {
        return num1 - num2;
    }
}
