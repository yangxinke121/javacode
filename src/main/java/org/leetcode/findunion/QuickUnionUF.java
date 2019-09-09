package org.leetcode.findunion;

import java.util.Scanner;

public class QuickUnionUF {

    private int[] roots;

    public QuickUnionUF(int N) {
        roots = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            roots[i] = i;
        }
    }

    private int findRoot(int root) {
        if (roots[root] == root) {
            return root;
        } else {
            roots[root] = findRoot(roots[root]);
            return roots[root];
        }
    }

    public void merge(int p, int q) {
        int t1 = findRoot(p);
        int t2 = findRoot(q);
        if (t1 != t2) {
            roots[t2] = t1;
        }
    }

    private boolean connect(int p, int q) {
        return findRoot(p) == findRoot(q);
    }

    public void union(int p, int q) {
        int qroot = findRoot(q);
        int proot = findRoot(p);
        roots[qroot] = proot;
    }

    public static void main(String[] args) {
        QuickUnionUF quickUnionUF = new QuickUnionUF(5);
        Scanner scanner = new Scanner(System.in);
        for (int i = 1; i <= 5; i++) {
            quickUnionUF.merge(scanner.nextInt(), scanner.nextInt());
        }

        int sum = 0;
        for (int i = 1; i <= 5; i++) {
            if (quickUnionUF.roots[i] == i) {
                sum++;
            }
        }
        System.out.println(sum);
    }
}
