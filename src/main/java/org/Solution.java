package org;

import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

public class Solution {

    // 输入: numbers = [2, 7, 11, 15], target = 9
    // 输出: [1,2]
    // 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
    public int[] twoSum(int[] numbers, int target) {
        if (numbers.length < 2) {
            return new int[]{};
        }
        int end = numbers.length - 1;
        int start = 0;
        while (start < end) {
            if (numbers[start] + numbers[end] == target) {
                return new int[]{start + 1, end + 1};
            } else if (numbers[start] + numbers[end] < target) {
                start++;
            } else {
                end--;
            }
        }
        return new int[]{};
    }

    public boolean isPalindrome(String s) {
        if (s.isEmpty()) {
            return true;
        }
        s = s.toLowerCase();
        int length = s.length();
        StringBuilder sb = new StringBuilder(length);
        for (char c : s.toCharArray()) {
            if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) {
                sb.append(c);
            }
        }
        return sb.toString().equals(sb.reverse().toString());
    }

    public static int binarySort(int[] arr, int target) {
        int end = arr.length - 1;
        int start = 0;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public String reverseVowels(String s) {
        if (s.isEmpty()) {
            return "";
        }
        int start = 0;
        char[] chars = s.toCharArray();
        int end = chars.length - 1;
        while (start < end) {
            while (start < end && ((chars[start] != 'a') && (chars[start] != 'e') && (chars[start] != 'i') && (chars[start] != 'o') && (chars[start] != 'u')
                    && (chars[start] != 'A') && (chars[start] != 'E') && (chars[start] != 'I') && (chars[start] != 'O') && (chars[start] != 'U')
            )) {
                start++;
            }
            while (start < end && ((chars[end] != 'a') && (chars[end] != 'e') && (chars[end] != 'i') && (chars[end] != 'o') && (chars[end] != 'u')
                    && (chars[end] != 'A') && (chars[end] != 'E') && (chars[end] != 'I') && (chars[end] != 'O') && (chars[end] != 'U')
            )) {
                end--;
            }
            char c = chars[start];
            chars[start] = chars[end];
            chars[end] = c;
            start++;
            end--;
        }
        return new String(chars);
    }


    /**
     * 输入: s = 7, nums = [2,3,1,2,4,3]
     * 输出: 2
     * 解释: 子数组 [4,3] 是该条件下的长度最小的连续子数组。
     */
    public int minSubArrayLen(int s, int[] nums) {

        int start = 0;
        int end = nums.length - 1;
        int sum = 0;
        int sub = 0;
        while (start <= end) {
            for (int i = start; i <= end; i++) {
                sum += nums[i];
            }
            if (sum >= s) {
                sub = end - start + 1;
                start++;
                sum = 0;
            } else {
                end--;
            }
        }
        return sub;
    }

    public void reverseString(char[] s) {

        int start = 0;
        int length = s.length - 1;

        while (start < length) {
            char temp = s[start];
            s[start++] = s[length];
            s[length--] = temp;
        }
    }


    public boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            int temp = nums[i];
            if (temp == nums[i + 1]) {
                return true;
            }
        }
        return false;
    }


    public int singleNumber(int[] nums) {
        int temp = 0;
        for (int num : nums) {
            temp ^= num;
        }
        return temp;
    }


    public int[] intersect(int[] nums1, int[] nums2) {
        if (nums1.length == 0 || nums2.length == 0) {
            return new int[]{};
        }
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int end = nums1.length;
        int[] temp = new int[end];
        int tempIndex = 0;
        int start = 0;
        int nums2Start = 0;
        while (start < end && nums2Start < nums2.length) {
            if (nums1[start] > nums2[nums2Start]) {
                nums2Start++;
            } else if (nums1[start] < nums2[nums2Start]) {
                start++;
            } else {
                temp[tempIndex++] = nums1[start];
                start++;
                nums2Start++;
            }
        }
        int[] arr = new int[tempIndex];
        System.arraycopy(temp, 0, arr, 0, tempIndex);
        return arr;
    }


    public int[] plusOne(int[] digits) {
        int length = digits.length - 1;
        digits[length]++;
        if (digits[length] > 9) {
            while (length > 0 && digits[length] > 9) {
                digits[length] -= 10;
                length--;
                digits[length]++;
            }
        }
        // int preValue = (digits[length] + 1) / 10;
        // digits[length] = (digits[length] + 1) % 10;
        // while (length > 0) {
        //     if (preValue > 0) {
        //         digits[--length] += preValue;
        //         preValue = digits[length] / 10;
        //         digits[length] = digits[length] % 10;
        //     } else {
        //         break;
        //     }
        // }
        if (digits[0] == 0) {
            int[] temp = new int[digits.length + 1];
            System.arraycopy(digits, 0, temp, 1, digits.length);
            temp[0] = 1;
            return temp;
        } else {
            return digits;
        }
    }

    public int[] twoSum1(int[] nums, int target) {
        if (nums.length < 2) {
            return new int[]{};
        }
        int capacity = (int) (nums.length / 0.75 + 1);
        Map<Integer, Integer> map = new HashMap<>(capacity);
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                return new int[]{map.get(target - nums[i]), i};
            } else {
                map.put(nums[i], i);
            }
        }
        return new int[]{};
    }

    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char temp = board[i][j];
                if (temp == '.') {
                    continue;
                }
                // 比较行
                for (int row = j + 1; row < 9; row++) {
                    if (temp == board[i][row]) {
                        return false;
                    }
                }
                // 比较列
                for (int col = i + 1; col < 9; col++) {
                    if (temp == board[col][j]) {
                        return false;
                    }
                }

                // 比较单元格
                // 00 01 02
                // 10 11 12
                // 20 21 22
                // i,j / 3
                int tempI = (i / 3) * 3;
                int tempJ = (j / 3) * 3;
                for (int k = tempI; k < tempI + 3; k++) {
                    if (k == i) {
                        continue;
                    }
                    for (int m = tempJ; m < tempJ + 3; m++) {
                        if (m == j) {
                            continue;
                        }
                        if (temp == board[k][m]) {
                            return false;
                        }
                    }
                }
            }
        }
        return true;
    }


    public int firstUniqChar(String s) {
        if (s.isEmpty()) {
            return -1;
        }
        int length = s.length();
        int capacity = (int) (length / 0.75 + 1);
        Map<Character, Integer> map = new HashMap<>(capacity);
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                Integer integer = map.get(c);
                map.put(c, integer + 1);
            } else {
                map.put(c, 1);
            }
        }
        for (int i = 0; i < length; i++) {
            if (map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 实现 java str的功能
     *
     * @param haystack
     * @param needle
     * @return
     */
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        char[] haystackch = haystack.toCharArray();
        char[] needlech = needle.toCharArray();

        char first = needlech[0];
        int max = haystack.length() - needle.length();
        for (int i = 0; i <= max; i++) {
            if (haystackch[i] != first) {
                while (++i <= max && haystackch[i] != first) ;
            }
            if (i <= max) {
                int j = i + 1;
                int end = needle.length() - 1 + j;
                for (int k = 1; j < end && needlech[k] == haystackch[j]; k++, j++) ;
                if (j == end) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 报数序列
     *
     * @param n
     * @return
     */
    public String countAndSay(int n) {
        if (n == 1) {
            return "1";
        }
        String s = countAndSay(n - 1);

        char[] chars1 = s.toCharArray();
        StringBuilder sb = new StringBuilder();
        char aChar = chars1[0];
        int count = 0;
        for (int i = 0; i < s.length(); i++) {
            if (aChar == chars1[i]) {
                count++;
                continue;
            }
            sb.append(count).append(aChar);
            aChar = chars1[i];
            count = 1;
        }
        sb.append(count).append(aChar);
        return sb.toString();
    }

    /**
     * 最长公共前缀
     *
     * @param strs
     * @return
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].length() == i || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    public int sale(int n) {

        if(n % 2 != 0 || n == 10) {
            return -1;
        }else {
            int result2 = 0;
            if(n % 8 != 0) {
                result2 = n / 8 + 1;
            }
            else {
                result2 = n / 8;
            }
            return result2;
        }
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        char[][] chars = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };

        System.out.println(solution.isValidSudoku(chars));


        System.out.println(solution.firstUniqChar("loveleetcode"));

        System.out.println(solution.strStr("heloll", ""));

        System.out.println(solution.countAndSay(6));

        System.out.println(solution.longestCommonPrefix(new String[]{"flood", "flow", "flight"}));


        System.out.println(solution.sale(20));

        Executors.newFixedThreadPool(1, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                Thread t = new Thread(r);
                t.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                    @Override
                    public void uncaughtException(Thread t1, Throwable e) {
                        System.out.println();
                    }
                });
                return t;
            }
        });
    }

}

