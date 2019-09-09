package org.learn;

public enum SingletonEnum {

    INSTANCE;

    public void whatMethod() {
        System.out.println("12");
    }

    public static void main(String[] args) {
        SingletonEnum.INSTANCE.whatMethod();
    }
}
