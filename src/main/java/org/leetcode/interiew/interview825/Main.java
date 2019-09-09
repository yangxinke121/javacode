package org.leetcode.interiew.interview825;

import java.util.Scanner;

public class Main {


    private int Num(int x) {
        int ret = 0;
        while (x != 0) {
            ret += (x % 10) * (x % 10);
            x /= 10;
        }
        return ret;
    }

    private boolean isHappy(int n) {
        if (n <= 0)
            return false;
        while (n != 1) {
            n = Num(n);
            if (n == 4)
                return false;
        }
        return true;
    }

    private static void squareSum(int a) {
        int sum = 0;
        while (a != 0) {
            sum += (int) Math.pow(a % 10, 2);
            a /= 10;
        }
        if (sum == 1) {
            System.out.println("true");
        } else {
            squareSum(sum);
        }
    }

    public static void main(String[] args) {

        // Scanner s = new Scanner(System.in);
        // int m = s.nextInt();
        // int[] a = new int[m];
        // for (int i = 0; i < m; i++) {
        //     a[i] = s.nextInt();
        // }
        //
        // Main main = new Main();
        // for (int i = 0; i < m; i++) {
        //     System.out.println(main.isHappy(a[i]));
        //     // squareSum(a[i]);
        // }


        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] str = new String[2 * n];
        for (int i = 0; i < 2 * n; i++) {
            str[i] = scanner.next();
        }

        boolean[] flag = new boolean[n];
        for (int i = 0; i < 2 * n; i += 2) {

            String sp1 = str[i];
            int[] tempS1 = new int[4];
            String[] split1 = sp1.split("\\.");
            for (int j = 0; j < split1.length; j++) {
                tempS1[j] = Integer.parseInt(split1[j]);
            }

            String sp2 = str[i + 1];
            String[] split2 = sp2.split("\\.");
            int[] tempS2 = new int[4];
            for (int j = 0; j < split2.length; j++) {
                tempS2[j] = Integer.parseInt(split2[j]);
            }

            for (int j = 0; j < 4; j++) {
                if (tempS1[j] < tempS2[j]) {
                    flag[i / 2] = true;
                    break;
                }
            }
        }

        for (boolean b : flag) {
            System.out.println(b);
        }



        // Scanner scanner = new Scanner(System.in);
        // String s1 = scanner.nextLine();
        // String s2 = scanner.nextLine();
        // if (s2.trim().equals("")) {
        //     System.out.println(s1);
        //     return;
        // }
        // Queue<String> queue = new LinkedList<>();
        // String[] s = s1.split(" ");
        // String[] s3 = s2.split(" ");
        // int k = 0;
        // for (int i = 0; i < s.length; i++) {
        //     queue.offer(s[i]);
        //     if ((i + 1) % 4 == 0) {
        //         if (k < s3.length) {
        //             queue.offer(s3[k++]);
        //         }
        //     }
        // }
        // for (int i = k; i < s3.length; i++) {
        //     queue.offer(s3[i]);
        // }
        // while (!queue.isEmpty()) {
        //     System.out.printf("%s ", queue.poll());
        // }
    }
}
