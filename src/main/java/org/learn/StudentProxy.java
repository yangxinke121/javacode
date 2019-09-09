package org.learn;

import com.sun.xml.internal.ws.server.sei.TieHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class StudentProxy implements InvocationHandler {

    private Student student;

    StudentProxy(Student student) {
        this.student = student;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("MyInvocationHandler invoke begin");
        System.out.println("proxy: "+ proxy.getClass().getName());
        System.out.println("method: "+ method.getName());
        for(Object o : args){
            System.out.println("arg: "+ o);
        }
        return method.invoke(student, args);
    }
}
