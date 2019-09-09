package org.bag;

import java.util.Scanner;

public class Pascal {

    public static void main(String[] args) {

        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int[][] a = new int[n][n];

        for(int i=0; i<n; i++){
            a[i][0] = 1;
            a[i][i] = 1;
        }

        if (n > 1) {
            for (int i = 2; i < n; i++) {
                for (int j = 1; j < i; j++) {
                    a[i][j] = a[i - 1][j - 1] + a[i - 1][j];
                }
            }
        }

        for(int k=0; k<n; k++){
            for (int i = 0; i <= k; i++) {
                if(i != k )
                System.out.print(a[k][i]+ " ");
                else
                    System.out.print(a[k][i]);
            }
            System.out.println();
        }
    }
}
