package org.learn.shiro.myProxy;

import java.lang.reflect.Method;

/**
 * @author: yxk
 * @date: 2019-04-02 09:18
 */
public interface MyInvocationHandler {

    Object invoke(Object Proxy, Method method, Object[] args) throws Throwable;
}
