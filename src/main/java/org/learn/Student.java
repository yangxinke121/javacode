package org.learn;

public class Student implements Person {
    @Override
    public void sayHello(String content, int age) {
        System.out.println("Student say Hello " + content + " " + age);
    }

    @Override
    public void sayGoodBye(boolean seeAgin, double time) {
        System.out.println("Student say GoodBye " + seeAgin + " " + time);
    }
}
