package org.learn.templatepatterndemo;

/**
 * @author: yxk
 * @date: 2019-04-10 17:22
 */
public abstract class Game {

    abstract void initialize();

    abstract void startPlay();

    abstract void endPlay();

    protected final void play() {
        initialize();

        startPlay();

        endPlay();
    }
}
