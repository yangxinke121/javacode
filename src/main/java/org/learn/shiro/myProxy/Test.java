package org.learn.shiro.myProxy;

import java.lang.reflect.Method;

/**
 * @author: yxk
 * @date: 2019-04-02 10:19
 */
public class Test {

    public void test() {

        try {
            String path = "D:\\javacode\\target\\classes\\org\\learn\\shiro\\heap\\";
            ClassReloader classReloader = new ClassReloader(path);
            Class<?> r = classReloader.findClass("Heap.class");
            System.out.println(r.newInstance());
            ClassReloader classReloader1 = new ClassReloader(path);
            Class<?> r2 = classReloader1.findClass("Heap.class");
            System.out.println(r2.newInstance());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Throwable {

        Man man = new Xiaoyudian();
        MyHandler myHandler = new MyHandler(man);

        Man proxyMan = (Man) MyProxy.newProxyInstance(new MyClassLoader("D:\\javacode\\target\\classes\\org\\learn\\shiro\\myProxy", "org.learn.shiro.myProxy"),
                Man.class, myHandler);

        System.out.println(proxyMan.getClass().getName());
        proxyMan.findObject();

    }
}
