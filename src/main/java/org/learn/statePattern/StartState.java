package org.learn.statePattern;

/**
 * @author: yxk
 * @date: 2019-04-16 14:51
 */
public class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is start state");
    }

    @Override
    public String toString() {
        return "Start state";
    }
}
