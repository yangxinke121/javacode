package org.learn.statePattern;

/**
 * @author: yxk
 * @date: 2019-04-17 17:27
 */
public class SwimState implements RunState{

    public void run(Hero hero) {
        System.out.println("--------------不能跑动---------------");
        try {
            Thread.sleep(2000);//假设眩晕持续2秒
        } catch (InterruptedException e) {}
        hero.setState(Hero.COMMON);
        System.out.println("------眩晕状态结束，变为正常状态------");
    }

}
