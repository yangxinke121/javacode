package org.bag;

import java.util.Scanner;

public class Huiwen {

    public static void main(String[] args) {
//        String i = "123";
//        System.out.println(i.charAt(0));
//
//        int count = 0;
//        for(int i=1000; i<10000; i++){
//            String str = String.valueOf(i);
//            if(str.charAt(0) == str.charAt(str.length()-1) && str.charAt(1) == str.charAt(str.length()-2)){
//                System.out.println(i);
//                count++;
//            }
//        }
//        System.out.println(count);
        Scanner scanner = new Scanner(System.in);
        int i = scanner.nextInt();
        int a = i;
        int r = 0;
        if(a < 0) {
            return;
        }

        while (a > 0){
            r = r * 10 + a%10;
            a = a/10;
        }
        System.out.println(r==i);
    }
}


