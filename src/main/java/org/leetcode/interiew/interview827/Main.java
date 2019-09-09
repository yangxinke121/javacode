package org.leetcode.interiew.interview827;

import java.util.Scanner;

public class Main {


    static String getIndexAndLongest(String users, int k) {

        int[] temp = new int[users.length()];
        int length = users.length();
        for (int i = 0; i < length; i++) {
            if (users.charAt(i) == 'b') {
                int before = before(users, i - 1);
                int after = after(users, i + 1);
                temp[i] = before + after;
            }
        }
        int max = temp[0];
        int count = 0;
        for (int i = 1; i < length; i++) {
            if (temp[i] > max) {
                max = temp[i];
                count = i;
            }
        }

        int tempLen = 0;
        for (int i = 0; i < length; i++) {
            int tempMax = 0;
            int j;
            for (j = i; j < length; j++) {
                if (users.charAt(j) == 'b') {
                    tempMax++;
                } else {
                    if (tempMax < k) {
                        tempMax++;
                    } else {
                        break;
                    }
                }
            }
            if (j == length) {
                for (int l = 0; l < i; l++) {
                    if (users.charAt(l) == 'b' && tempMax <= k) {
                        tempMax++;
                    } else {
                        if (tempMax < k) {
                            tempMax++;
                        } else {
                            break;
                        }
                    }
                }
            }
            if (tempMax > tempLen) {
                tempLen = tempMax;
            }
        }
        return count + " " + tempLen;
    }

    private static int before(String user, int i) {
        int count = 0;
        while (i >= 0) {
            if (user.charAt(i) == 'g') {
                count++;
            } else {
                break;
            }
            i--;
        }
        if (i < 0) {
            i = user.length() - 1;
            while (i >= 0) {
                if (user.charAt(i) == 'g') {
                    count++;
                    i--;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    private static int after(String user, int i) {
        int count = 0;
        while (i < user.length()) {
            if (user.charAt(i) == 'g') {
                count++;
            } else {
                break;
            }
            i++;
        }
        if (i >= user.length()) {
            i = 0;

            while (i >= 0 && i < user.length()) {
                if (user.charAt(i) == 'g') {
                    count++;
                    i++;
                } else {
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String res;

        String _users;
        try {
            _users = in.nextLine();
        } catch (Exception e) {
            _users = null;
        }
        int k = in.nextInt();
        res = getIndexAndLongest(_users, k);
        System.out.println(res);
    }
}
