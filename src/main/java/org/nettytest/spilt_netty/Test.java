package org.nettytest.spilt_netty;

public class Test {

    public static void main(String[] args) {

        String s = "hi, yxk. welcome to Netty.$_hi, yxk. welcome to Netty.$_hi, yxk. welcome to Netty.$_hi, yxk. welcome to Netty.$_hi, yxk. welcome to Netty.$_hi, yxk. welcome to Netty.$_hi, yxk. welcome to Netty.$_hi, yxk. welcome to Netty.$_hi, yxk. welcome to Netty.$_hi, yxk. welcome to Netty.$_$_$_";

        String[] split = s.split("\\$_");
        System.out.println(split.length);
        for (String s1 : split) {
            System.out.println(s1);
        }

        String s1 = "123,123,,,123,";
        String[] split1 = s1.split(",");
        System.out.println(split1.length);
    }
}
