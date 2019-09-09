package org.learn;

import java.util.Scanner;

public class CCF {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long r = scanner.nextInt();
        long y = scanner.nextInt();
        long g = scanner.nextInt();
        int n = scanner.nextInt();
        int[][] arr = new int[n][2];
        for (int i = 0; i < n; i++) {
            arr[i][0] = scanner.nextInt();
            arr[i][1] = scanner.nextInt();
        }
        System.out.println(wait(arr, r, y, g));
    }

    public static long wait(int[][] arr, long r, long y, long g) {
        int length = arr.length;
        long sum = 0;
        for (int i = 0; i < length; i++) {
            if (arr[i][0] == 0) {
                sum = sum + arr[i][1];
            }
            if (arr[i][0] == 1) {
                long r1 = (sum - arr[i][1]) %(r+y+g);
                if (r1 <= 0) {
                    sum = sum - r1;
                } else if (r1 > g) {
                    sum = sum + r+y+g - r1;
                }
            }
            if (arr[i][0] == 2) {
                long r1 = (sum - arr[i][1]) %(r+y+g);
                if (r1 <= 0) {
                    sum = sum + r - r1;
                } else if (r1 <= r) {
                    sum = sum + r - r1;
                } else if (r1 > r + g) {
                    sum = sum + r + y + g - r1 + r;
                }
            }
            if (arr[i][0] == 3) {
                long r1 = (sum - arr[i][1]) % (r+y+g);
                if (r1 > 0) {
                    if (r1 <= r + y) {
                        sum = sum + y+r - r1;
                    }
                }
            }
        }
        return sum;
    }
}
