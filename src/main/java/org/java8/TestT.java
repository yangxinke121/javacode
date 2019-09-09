package org.java8;

public class TestT {

    public static void main(String[] args) {

        int a = 0;

        ok:
        for(int i = 0;i<5;i++){
            for(int j = 0;j<5;j++){
                if(j==4) {
                    a=i;
                    break ok;
                }
            }
        }
        System.out.println(a);

    }
}


