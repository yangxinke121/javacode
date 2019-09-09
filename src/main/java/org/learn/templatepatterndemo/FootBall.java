package org.learn.templatepatterndemo;

/**
 * @author: yxk
 * @date: 2019-04-10 17:23
 */
public class FootBall extends Game {
    @Override
    void initialize() {
        System.out.println("Football Game Initialized! Start playing.");
    }

    @Override
    void startPlay() {
        System.out.println("Football Game Started. Enjoy the game!");
    }

    @Override
    void endPlay() {
        System.out.println("Football Game Finished!");
    }
}
