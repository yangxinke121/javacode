package org.leetcode.str;

import java.util.*;

public class Solution {

    public String addBinary(String a, String b) {
        char[] aa = a.toCharArray();
        char[] bb = b.toCharArray();

        int aLen = aa.length;
        int bLen = bb.length;

        int i = aLen - 1;
        int j = bLen - 1;
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        while (i >= 0 && j >= 0) {
            int temp = (aa[i] - '0' + bb[j] - '0') + carry;
            carry = temp / 2;
            sb.append(temp % 2);
            i--;
            j--;
        }
        while (i >= 0) {
            int temp = aa[i] - '0' + carry;
            carry = temp / 2;
            sb.append(temp % 2);
            i--;
        }

        while (j >= 0) {
            int temp = bb[j] - '0' + carry;
            carry = temp / 2;
            sb.append(temp % 2);
            j--;
        }
        if (carry == 1) {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    /**
     * 编码
     *
     * @param str
     * @return
     */
    public int strEncode(String str) {
        if (str == null) {
            return -1;
        }
        char[] chars = str.toCharArray();
        int len = chars.length;
        int i = 0;
        int sum = 0;

        int first = 16276;
        int second = 651;
        int third = 26;
        if (i < len && chars[i] - 'a' > 0) {
            sum += (chars[i] - 'a') * first;
            i++;
        }
        while (i < len) {
            if (chars[i] - 'a' >= 0) {
                int temp = 1;
                if (i == 1) {
                    temp *= second;
                }
                if (i == 2) {
                    temp *= third;
                }
                sum += (chars[i] - 'a') * temp + 1;
            }
            i++;
        }
        return sum;
    }

    public int twoSum(int n) {
        List<Integer> set = new ArrayList<>((int) (n / .75) + 1);
        for (int i = 2; i <= n; i++) {
            if (m(i)) {
                set.add(i);
            }
        }
        int count = 0;
        for (int i = 0; i < set.size(); i++) {
            if (set.contains(n - set.get(i))) {
                count++;
            }
        }
        if (set.contains(n / 2)) {
            count += 2;
        }
        return count / 2;
    }

    private boolean m(int i) {
        for (int j = 2; j <= Math.sqrt(i); j++) {
            if (i % j == 0) {
                return false;
            }
        }
        return true;
    }

    public String geoHash(int n) {
        int high = 90;
        int low = -90;
        int count = 0;
        StringBuilder sb = new StringBuilder();
        while (low <= high) {
            int mid = (low + high) / 2;
            count++;
            if (mid < n) {
                low = mid;
                sb.append(1);
            } else if (mid > n) {
                high = mid;
                sb.append(0);
            } else {
                sb.append(1);
                low = mid;
            }
            if (count >= 6) {
                break;
            }
        }
        return sb.toString();
    }


    /**
     * 49 字母异位词分组
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {

        // List<List<String>> res = new ArrayList<>();
        //
        // // 记录 (排序后的字符串，list编号)
        // Map<String, Integer> map = new HashMap<>();
        //
        // for (String str : strs) {
        //     String s = sort(str);
        //     Integer index = map.get(s);
        //     if (index == null) {
        //         List<String> list = new ArrayList<>();
        //         list.add(str);
        //         res.add(list);
        //         map.put(s, res.size() - 1);
        //     } else {
        //         res.get(index).add(str);
        //     }
        // }
        // return res;


        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            String sort = sort(s);
            if (!map.containsKey(sort)) {
                map.put(sort, new ArrayList<>());
            }
            map.get(sort).add(s);
        }
        return new ArrayList<>(map.values());
    }

    private String sort(String s) {
        char[] cs = s.toCharArray();
        Arrays.sort(cs);
        return new String(cs);
    }


    /**
     * 451  根据字符出现频率排序
     *
     * @param s
     * @return
     */
    public String frequencySort(String s) {
        // Pair[] arr=new Pair[256];//定义一个数组，下标代表字符下标，值存储pair
        // //初始化数组
        // for (int i=0;i<256;i++){
        //     arr[i]=new Pair(0,(char)i);
        // }
        // //增加指定字符的频率
        // for (int j=0;j<s.length();j++){
        //     arr[s.charAt(j)].fre++;
        // }
        // //频率高的往前排
        // Arrays.sort(arr,new myCompare());
        // StringBuffer str=new StringBuffer();
        // for (int k=0;k<s.length();k++){
        //     if (arr[k].fre==0)break;
        //     //输出Pair中存储的所有字符
        //     while (arr[k].fre!=0) {
        //         str.append(arr[k].c);
        //         arr[k].fre--;
        //     }
        // }
        // return str.toString();

        StringBuilder sb = new StringBuilder();
        int[] hash = new int[256];
        for (char c : s.toCharArray()) {
            hash[c]++;
        }

        int[] hash1 = hash.clone();
        Arrays.sort(hash);
        for (int i = 255; i >= 0 && hash[i] > 0; i--) {
            for (int j = 0; j < 256; j++) {
                if (hash[i] == hash1[j]) {
                    while (hash1[j]-- > 0) {
                        sb.append((char) j);
                    }
                }
            }
        }
        return sb.toString();
    }

    /**
     * 字符串的排列
     *
     * @param s1
     * @param s2
     * @return
     */
    public boolean checkInclusion(String s1, String s2) {

        // 法一 统计每一位出现的次数
        // int[] tempS1 = new int[26];
        // for (int i = 0; i < s1.length(); i++) {
        //     tempS1[s1.charAt(i) - 'a']++;
        // }
        // for (int i = 0; i <= s2.length() - s1.length(); i++) {
        //     int[] tempS2 = new int[26];
        //     for (int j = i; j < i + s1.length(); j++) {
        //         tempS2[s2.charAt(j) - 'a']++;
        //     }
        //     if (match(tempS1, tempS2)) {
        //         return true;
        //     }
        // }
        // return false;

        // 法二 滑动窗口

        if (s2.length() < s1.length()) {
            return false;
        }
        int[] tempS1 = new int[26];
        int[] tempS2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            tempS1[s1.charAt(i) - 'a']++;
            tempS2[s2.charAt(i) - 'a']++;
        }
        for (int i = 0; i < s2.length() - s1.length(); i++) {
            if (match(tempS1, tempS2)) {
                return true;
            }
            tempS2[s2.charAt(i + s1.length()) - 'a']++;
            tempS2[s2.charAt(i) - 'a']--;
        }
        return match(tempS1, tempS2);
    }

    private boolean match(int[] tempS1, int[] tempS2) {
        for (int i = 0; i < 26; i++) {
            if (tempS1[i] != tempS2[i]) {
                return false;
            }
        }
        return true;
    }

    /**
     * 13 罗马数字转整数
     *
     * @param s
     * @return
     */
    public int romanToInt(String s) {

        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);

        int temp = 0;
        for (int i = 0; i < s.length(); ) {
            int m = map.get(s.charAt(i));
            if (i < s.length() - 1) {
                if (s.charAt(i) == 'I' && (s.charAt(i + 1) == 'V' || s.charAt(i + 1) == 'X')) {
                    m = map.get(s.charAt(i + 1)) - m;
                    temp += m;
                    i = i + 2;
                    continue;
                }
                if (s.charAt(i) == 'X' && (s.charAt(i + 1) == 'L' || s.charAt(i + 1) == 'C')) {
                    m = map.get(s.charAt(i + 1)) - m;
                    temp += m;
                    i = i + 2;
                    continue;
                }
                if (s.charAt(i) == 'C' && (s.charAt(i + 1) == 'D' || s.charAt(i + 1) == 'M')) {
                    m = map.get(s.charAt(i + 1)) - m;
                    temp += m;
                    i = i + 2;
                    continue;
                }
                temp += m;
                i++;
            } else {
                temp += m;
                i++;
            }
        }
        return temp;
    }

    /**
     * 43 字符串相乘
     *
     * @param num1
     * @param num2
     * @return
     */
    public String multiply(String num1, String num2) {

        int n1 = num1.length() - 1;
        int n2 = num2.length() - 1;

        if (n1 < 0 || n2 < 0) {
            return "";
        }
        int[] mul = new int[n1 + n2 + 2];

        for (int i = n1; i >= 0; --i) {
            for (int j = n2; j >= 0; --j) {
                int bitmul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                // 先加低位判断是否有新的进位
                bitmul += mul[i + j + 1];

                mul[i + j] += bitmul / 10;
                mul[i + j + 1] = bitmul % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        int i = 0;
        // 去掉前导0
        while (i < mul.length - 1 && mul[i] == 0) {
            i++;
        }
        for (; i < mul.length; ++i) {
            sb.append(mul[i]);
        }
        return sb.toString();

    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.addBinary("1010", "1011"));

        System.out.println(solution.strEncode("yahy"));

        System.out.println(1024 >> 5);


        System.out.println(solution.twoSum(10));

        System.out.println(solution.geoHash(5));

        List<List<String>> lists = solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
        for (List<String> list : lists) {
            for (String s : list) {
                System.out.print(s + " ");
            }
            System.out.println();
        }

        System.out.println(solution.frequencySort("tree"));


        System.out.println(solution.checkInclusion("ab", "eidboaoo"));

        System.out.println(solution.romanToInt("I"));
    }
}


//自定义Comparator排序规则是按照频率，从大到小
class myCompare implements Comparator<Pair> {
    @Override
    public int compare(Pair o1, Pair o2) {
        return o2.fre - o1.fre;
    }
}

//自定义封装类，用于存储频率和字符
class Pair {
    public int fre;
    public char c;

    Pair(int fre, char c) {
        this.fre = fre;
        this.c = c;
    }
}