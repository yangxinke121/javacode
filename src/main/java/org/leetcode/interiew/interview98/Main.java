package org.leetcode.interiew.interview98;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    private int count;

    private int permute(int[] nums, int[] mark) {
        List<Integer> list = new ArrayList<>();
        boolean[] book = new boolean[nums.length];
        dfs(nums, 0, list, book, mark);
        return count;
    }

    private void dfs(int[] nums, int n, List<Integer> list, boolean[] book, int[] mark) {

        if (n == nums.length) {
            if (list.size() == nums.length) {
                count++;
            }
            return;
        }

        for (int i = 0; i < nums.length; i++) {

            if (book[i]) {
                continue;
            }
            if (list.size() > 0 && mark[list.size() - 1] == 1 && nums[i] > list.get(list.size() - 1)) {
                continue;
            }

            if (list.size() > 0 && mark[list.size() - 1] == 0 && nums[i] < list.get(list.size() - 1)) {
                continue;
            }
            list.add(nums[i]);
            book[i] = true;
            dfs(nums, n + 1, list, book, mark);
            book[i] = false;
            list.remove(list.size() - 1);
        }
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        int[] mark = new int[n - 1];
        int z = 0;
        int o = 0;
        for (int i = 0; i < n - 1; i++) {
            int i1 = scanner.nextInt();
            if (i1 == 1) {
                o++;
            } else {
                z++;
            }
            mark[i] = i1;
        }
        if (z == n - 1 || o == n - 1) {
            System.out.println(1);
            return;
        }
        Main main = new Main();
        System.out.println(main.permute(nums, mark) % ((int) Math.pow(10, 9) + 7));
    }
}
