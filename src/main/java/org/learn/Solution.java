package org.learn;


/**
 * @author: yxk
 * @date: 2019-04-18 17:42
 */
public class Solution {

    private int maxW = Integer.MIN_VALUE;

    private int[] weight = {2,2,4,6,3};

    private boolean[][] men = new boolean[5][10];

    private int n = 5;

    private int w = 9;

    public void getMax(int i, int cw) {
        if (i == n || cw == w) {
            if (cw > w) {
                maxW = cw;
            }
            return;
        }
        if (men[i][cw]) {
            return;
        }
        men[i][cw] = true;
        getMax(i + 1, cw);
        if (cw + weight[i] <= cw) {
            getMax(i + 1, cw + weight[i]);
        }
    }

    public void f(int i, int cw) {
        int n = 5;
        int w = 9;
        if (i == n || cw == w) {
            if (cw > maxW) {
                maxW = cw;
            }
            return;
        }
        if (men[i][cw]) {
            return;
        }
        men[i][cw] = true;
        f(i + 1, cw);
        if (cw + weight[i] <= w) {
            f(i + 1, cw + weight[i]);
        }
    }


    public int getMaxDP(int cn, int cw) {
        boolean[][] state = new boolean[5][10];
        state[0][0] = true;
        state[0][weight[0]] = true;
        for (int i = 1; i < cn; i++) {

            for (int j = 0; j <= cw; j++) {
                if (state[i - 1][j]) {
                    state[i][j] = state[i - 1][j];
                }
            }

            for (int j = 0; j <= cw - weight[i]; j++) {
                if (state[i - 1][j]) {
                    state[i][j + weight[i]] = true;
                }
            }
        }

        for (int i = cw; i >= 0; i--) {
            if (state[cn - 1][i]) {
                return i;
            }
        }
        return 0;
    }

    private int maxV = -1;

    private void getValueByWeight(int i, int cw, int cv, int[] weight, int[] value) {
        int w = 9;
        int n = 5;
        if (i == n || cw == w) {
            if (cv > maxV) {
                maxV = cv;
            }
            return;
        }
        getValueByWeight(i + 1, cw, cv, weight, value);

        if (cw + weight[i] <= w) {
            getValueByWeight(i + 1, cw + weight[i], cv + value[i], weight, value);
        }
    }

    private int getValueWeightByDP(int cn, int cw, int[] weight, int[] value) {

        int[][] state = new int[cn][cw + 1];
        state[0][0] = 0;
        state[0][weight[0]] = value[0];
        for (int i = 1; i < cn; i++) {
            for (int j = 0; j <= cw; j++) {
                if (state[i - 1][j] >= 0) {
                    state[i][j] = state[i - 1][j];
                }
            }
            for (int j = 0; j < cw - weight[i]; j++) {
                if (state[i - 1][j] >= 0) {
                    int v = state[i - 1][j] + value[i];
                    if (v > state[i][j + weight[i]]) {
                        state[i][j + weight[i]] = v;
                    }
                }
            }
        }

        int maxV = -1;
        for (int i = cw; i >= 0; i--) {
            if (state[cn - 1][i] > maxV) {
                maxV = state[cn - 1][i];
            }
        }
        return maxV;
    }

    /**
     * 给定一个 n × n 的二维矩阵表示一个图像。
     *
     * 将图像顺时针旋转 90 度。
     *
     * 说明：
     *
     * 你必须在原地旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要使用另一个矩阵来旋转图像。
     *
     * 示例 1:
     *
     * 给定 matrix =
     * [
     *   [1,2,3],
     *   [4,5,6],
     *   [7,8,9]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [7,4,1],
     *   [8,5,2],
     *   [9,6,3]
     * ]
     * 示例 2:
     *
     * 给定 matrix =
     * [
     *   [ 5, 1, 9,11],
     *   [ 2, 4, 8,10],
     *   [13, 3, 6, 7],
     *   [15,14,12,16]
     * ],
     *
     * 原地旋转输入矩阵，使其变为:
     * [
     *   [15,13, 2, 5],
     *   [14, 3, 4, 1],
     *   [12, 6, 8, 9],
     *   [16, 7,10,11]
     * ]
     */
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        if (n <= 1) {
            return;
        }

        //旋转次数
        int count = n * n / 4;

        int x = 0;
        int y = 0;
        int z = 0;

        int x1, y1, x2, y2;

        for (int i = 0; i < count; i++) {
            if (z >= (n - 1) - 2 * x) {
                x += 1;
                z = 0;
            }
            y = z + x;
            z += 1;

            x1 = x;
            y1 = y;

            for (int j = 0; j < 3; j++) {
                x2 = n - 1 - y1;
                y2 = x1;

                matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];
                matrix[x2][y2] = matrix[x1][y1] ^ matrix[x2][y2];
                matrix[x1][y1] = matrix[x1][y1] ^ matrix[x2][y2];

                x1 = x2;
                y1 = y2;
            }
        }
    }

    public int minSubArrayLen(int s, int[] nums) {
        int start = 0;
        int end = nums.length;
        int sub = end;
        int sum = 0;
        for (int i = 0; i < end; i++) {
            sum += nums[i];
            while (sum >= s) {
                sub = Math.min(sub, i - start + 1);
                sum -= nums[start++];
            }
        }
        return sub == end ? 0 : sub;
    }


    // 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
    //
    // 示例 1:
    //
    // 输入: 123
    // 输出: 321
    // 示例 2:
    //
    // 输入: -123
    // 输出: -321
    // 示例 3:
    //
    // 输入: 120
    // 输出: 21
    // 注意:
    //
    // 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
    public int reverse(int x) {


        if (x >= 0) {
            String s = String.valueOf(x);
            StringBuilder sb = new StringBuilder(s);
            try {
                return Integer.valueOf(sb.reverse().toString());
            } catch (Exception e) {
                return 0;
            }
        } else {
            String s = String.valueOf(-x);
            StringBuilder sb = new StringBuilder(s);
            try {
                return Integer.valueOf(sb.reverse().insert(0, '-').toString());
            } catch (Exception e) {
                return 0;
            }
        }
    }

    // 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
    //
    // 案例:
    //
    // s = "leetcode"
    // 返回 0.
    //
    // s = "loveleetcode",
    // 返回 2.
    //
    //
    // 注意事项：您可以假定该字符串只包含小写字母。
    public int firstUniqChar(String s) {
        return 0;
    }

    // 给定两个字符串 s 和 t ，编写一个函数来判断 t 是否是 s 的一个字母异位词。
    //
    // 示例 1:
    //
    // 输入: s = "anagram", t = "nagaram"
    // 输出: true
    // 示例 2:
    //
    // 输入: s = "rat", t = "car"
    // 输出: false
    // 说明:
    // 你可以假设字符串只包含小写字母。
    // "anagtam"
    // "nbgbram"
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        if (s.equals("") && t.equals("")) {
            return true;
        }

        int[] record1 = new int[26];

        for (char c : s.toCharArray()) {
            record1[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            record1[c - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (record1[i] != 0) {
                return false;
            }
        }
        return true;
    }

    public int myAtoi(String str) {
        String trimStr = str.trim();
        int result = 0;
        boolean negative = false;
        int i = 0, len = trimStr.length();
        int limit = -Integer.MAX_VALUE;
        int digit;
        int multmin;
        if (len > 0) {
            char firstChar = trimStr.charAt(0);
            if (firstChar < '0') { // Possible leading "+" or "-"
                if (firstChar == '-') {
                    negative = true;
                    limit = Integer.MIN_VALUE;
                } else if (firstChar != '+')
                    return 0;

                if (len == 1) // Cannot have lone "+" or "-"
                    return 0;
                i++;
            }
            multmin = limit / 10;
            while (i < len) {
                // Accumulating negatively avoids surprises near MAX_VALUE
                digit = Character.digit(trimStr.charAt(i++),10);
                if (digit < 0) {
                    break;
                }
                if (result < multmin) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result *= 10;
                if (result < limit + digit) {
                    return negative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
                }
                result -= digit;
            }
        } else {
            return 0;
        }
        return negative ? result : -result;

    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        // solution.f(0, 0);
        // System.out.println(solution.maxW);
        //
        // System.out.println(solution.getMaxDP(5, 9));
        //
        // solution.getValueByWeight(0, 0, 0, new int[]{2, 2, 4, 6, 3}, new int[]{3, 4, 8, 9, 6});
        // System.out.println(solution.maxV);
        //
        // System.out.println(solution.getValueWeightByDP(5, 10, new int[]{2, 2, 4, 6, 3}, new int[]{3, 4, 8, 9, 6}));
        //
        // System.out.println(solution.isAnagram("aa", "bb"));

        System.out.println(Character.digit('w', 10));

        // System.out.println(solution.myAtoi("-92147483648"));
    }
}
