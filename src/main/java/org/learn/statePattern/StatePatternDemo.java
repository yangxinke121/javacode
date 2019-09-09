package org.learn.statePattern;

/**
 * @author: yxk
 * @date: 2019-04-16 15:00
 */
public class StatePatternDemo {

    public static void main(String[] args) {
        Context context = new Context();

        context.setState(Context.START_STATE);

        context.setState(Context.STOP_STATE);
    }
}
