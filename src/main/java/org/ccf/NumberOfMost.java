package org.ccf;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 出现次数最多的数
 *
 * 问题描述：给定n个正整数，找出它们中出现次数最多的数。如果这样的数有多个，请输出其中最小的一个。
 */
public class NumberOfMost {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<Integer> list = new ArrayList<>();
        int m = scanner.nextInt();
        for (int i = 0; i < m; i++) {
            list.add(scanner.nextInt());
        }

        int[] nums = new int[10001];
        for (Integer i : list) {
            if (nums[i] == 0) {
                nums[i] = 1;
            } else {
                nums[i]++;
            }
        }

        int maxCount = -1;
        int result = 0;
        for (int i = 1; i <= 10000; i++) {
            if (nums[i] > maxCount) {
                maxCount = nums[i];
                result = i;
            }
        }

        System.out.println(result);
    }
}
