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

    private void printPermutations(int[] data, int n, int k) {
        if (k == 1) {
            for (int i = 0; i < n; ++i) {
                System.out.print(data[i] + " ");
            }
            System.out.println();
        }

        for (int i = 0; i < k; ++i) {
            int tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;

            printPermutations(data, n, k - 1);

            tmp = data[i];
            data[i] = data[k - 1];
            data[k - 1] = tmp;
        }
    }


    public static void main(String[] args) {
        Permutation permutation = new Permutation();
        // permutation.dfs(1, 3);

        permutation.printPermutations(new int[]{1, 2, 3, 4}, 4, 4);
    }
}
