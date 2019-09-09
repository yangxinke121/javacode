package org.learn.statePattern;

/**
 * @author: yxk
 * @date: 2019-04-16 14:52
 */
public class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is stop");
    }

    @Override
    public String toString() {
        return "Stop State";
    }
}
