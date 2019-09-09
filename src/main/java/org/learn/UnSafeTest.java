package org.learn;

import sun.misc.Unsafe;

import java.lang.reflect.Field;

public class UnSafeTest {

    public static void main(String[] args) {
        Field f;
        Unsafe unsafe = null;
        try {
            f = Unsafe.class.getDeclaredField("theUnsafe");
            f.setAccessible(true);
            unsafe = (Unsafe) f.get(null);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(unsafe.pageSize());
    }
}
