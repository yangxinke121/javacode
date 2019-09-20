package org;

import java.util.*;

public class Main {

    public static boolean judge(int[] arr) {
        if (arr.length == 0) {
            return false;
        }
        return VerifySquenceOfBST(arr, 0, arr.length - 1);
    }

    // 1 3 2 5 7 6 4
    // 1, 2, 3, 4, 0, 6, 4
    // 4, 8, 6, 12, 16, 14, 10
    private static boolean VerifySquenceOfBST(int[] sequence, int begin, int end) {

        // if (begin >= end) {
        //     return true;
        // }
        //
        // int i = end;
        // while (i > begin && sequence[i - 1] > sequence[end]) {
        //     i--;
        // }
        //
        // for (int j = i - 1; j >= begin; --j) {
        //     if (sequence[j] > sequence[end]) {
        //         return false;
        //     }
        // }
        //
        // return VerifySquenceOfBST(sequence, begin, i - 1) &&
        //         VerifySquenceOfBST(sequence, i, end - 1);

        if (begin >= end) {
            return true;
        }
        int i = end;
        while (i > begin && sequence[i - 1] > sequence[end]) {
            i--;
        }
        for (int j = i - 1; j >= begin; j--) {
            if (sequence[j] > sequence[end]) {
                return false;
            }
        }

        return VerifySquenceOfBST(sequence, begin, i - 1) &&
                VerifySquenceOfBST(sequence, i, end - 1);
    }



    static int first(List<Integer> list) {

        Collections.sort(list);
        int min = 0;
        if (list.size() == 0 || list.size() == 1) {
            return -1;
        }
        for (int i = 0; i < list.size(); i++) {
            if (i == 0) {
                min = list.get(0);
            }
            if (list.get(i) != min + i) {
                return list.get(i - 1) + 1;
            }
        }
        return -1;
    }


    private int a = 0;
    class innerTest {

        public void test(){

            int a = Main.this.a;
        }
    }


    public static void main(String[] args) {

        int[] nums = {2, 1, 7, 5, 3};
        for (int i : nums) {
            System.out.print(i + " ");
        }

        Integer i = -128;
        Integer j = -128;
        System.out.println(i == j);
        Integer k = new Integer(i);
        int l = i;
        System.out.println(k == l);

        System.out.println(first(Arrays.asList(1, 2, 3)));


    }
}
