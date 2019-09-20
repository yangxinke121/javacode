package org.leetcode.interiew.interview911;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static String format(String template, Map<String, Object> param) {

        StringBuilder sb = new StringBuilder(template);
        while (true) {
            int i = sb.toString().indexOf('{');
            if (i < 0) {
                break;
            }
            int i1 = sb.toString().indexOf('}');
            String substring = sb.toString().substring(i + 1, i1);
            Object o = param.get(substring);
            sb.delete(i, i1 + 1);
            sb.insert(i, o);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // try {
        //     String s_nextLine = scan.nextLine();
        //     String[] line = s_nextLine.split("\\s+");
        //     String template = line[0];
        //     Map<String, Object> param = new HashMap<>();
        //     for (int i = 1; i < line.length; i += 2) {
        //         param.put(line[i], line[i + 1]);
        //     }
        //     System.out.println(format(template, param));
        // } finally {
        //     scan.close();
        // }

        Map<String, Object> map = new HashMap<>();
        map.put("name", "yxk");
        map.put("age", 12);
        System.out.println(format("我的名字{name},年纪是{age}", map));
    }



    //     private int count = Integer.MAX_VALUE;
    //     public static void main(String[] args){
    //         Scanner sc = new Scanner(System.in);
    //         int n = sc.nextInt();
    //         int a = sc.nextInt();
    //         int b = sc.nextInt();
    //         int[][] arr = new int[n][2];
    //         int[] res = new int[1];
    //         res[0] = Integer.MAX_VALUE;
    //         for (int i = 0; i < n; i++) {
    //             arr[i][0] = sc.nextInt();
    //             arr[i][1] = sc.nextInt();
    //         }
    //         getNum(arr, a, b, res, 0, 0);
    //         System.out.println(res[0]);
    //
    //     }
    //
    // private static void getNum(int[][] arr, int a, int b, int[] res, int sum, int count) {
    //     if (a < 0) {
    //         return;
    //     }
    //     if (b < 0) {
    //         return;
    //     }
    //     if (count > arr.length) {
    //         return;
    //     }
    //     if (count == arr.length) {
    //         res[0] = Math.min(res[0], sum);
    //         return;
    //     }
    //     getNum(arr, a - 1, b, res, sum + arr[count][0], count + 1);
    //     getNum(arr, a, b - 1, res, sum + arr[count][1], count + 1);
    // }
}
