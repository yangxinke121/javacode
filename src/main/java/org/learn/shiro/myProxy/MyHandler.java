package org.learn.shiro.myProxy;

import java.lang.reflect.Method;

/**
 * @author: yxk
 * @date: 2019-04-02 09:36
 */
public class MyHandler implements MyInvocationHandler {

    private Man man;

    public MyHandler(Man man) {
        this.man = man;
    }

    @Override
    public Object invoke(Object Proxy, Method method, Object[] args) throws Throwable {
        before();
        Object invoke = method.invoke(man);
        after();
        return invoke;
    }

    private void before() {
        System.out.println("before");
    }

    private void after() {
        System.out.println("after");
    }
}
