package org.sortorsearch.dfs;

/**
 * 全排列
 */
public class Permutation {

    private boolean[] book = new boolean[10];
    private int[] a = new int[10];

    private void dfs(int step, int n) {
        if (step == n + 1) {
            for (int i = 1; i <= n; i++) {
                System.out.printf("%d ", a[i]);
            }
            System.out.println();
            return;
        }

        for (int i = 1; i <= n; i++) {
            if (!book[i]) {
                a[step] = i;
                book[i] = true;
                dfs(step + 1, n);
                book[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        permutation.dfs(1, 3);
    }
}
