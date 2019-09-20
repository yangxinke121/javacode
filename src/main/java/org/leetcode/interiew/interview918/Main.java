package org.leetcode.interiew.interview918;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    private static String getCount(String a, String b) {

        if (a.length() != b.length()) {
            return "False";
        }
        Map<Character, Character> map = new HashMap<>();
        for (int i = 0; i < a.length(); i++) {
            if (map.containsKey(a.charAt(i))) {
                if (map.get(a.charAt(i)) != b.charAt(i)) {
                    return "False";
                }
            } else {
                map.put(a.charAt(i), b.charAt(i));
            }
        }
        return "True";
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] split = str.split(";");
        System.out.println(getCount(split[0], split[1]));
    }
}
