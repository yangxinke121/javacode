package org.learn.statePattern;

/**
 * @author: yxk
 * @date: 2019-04-16 14:49
 */
public class Context {

    public static final StartState START_STATE = new StartState();

    public static final StopState STOP_STATE = new StopState();

    private State state;

    private State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
        doAction();
    }

    private void doAction() {
        state.doAction(this);
        System.out.println(getState().toString());
    }
}
