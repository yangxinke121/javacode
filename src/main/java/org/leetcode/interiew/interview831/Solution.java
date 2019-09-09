package org.leetcode.interiew.interview831;

import java.util.LinkedHashMap;
import java.util.Map;

public class Solution {

    private LinkedHashMap<Integer, Integer> map;

    private int capacity1;

    private int cacheSize;

    public Solution(int capacity) {
        cacheSize = capacity;
        capacity1 = (int) ((capacity / .75f) + 1);
        map = new LinkedHashMap<Integer, Integer>(capacity1, 0.75f, true){
            @Override
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > Solution.this.cacheSize;
            }
        };
    }

    public int get(int key) {
        return map.get(key) == null ? -1 : map.get(key);
    }

    public void put(int key, int value) {
        map.put(key, value);
    }

    public static void main(String[] args) {

        Solution solution = new Solution(2);
        solution.put(1,1);
        solution.put(2,2);
        solution.get(1);
        solution.put(3,3);
        System.out.println(solution.get(2));
    }
}
