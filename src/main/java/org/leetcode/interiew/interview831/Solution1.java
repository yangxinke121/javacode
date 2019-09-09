package org.leetcode.interiew.interview831;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution1 {

    public String getMinVersion(String[] list) {

        List<Integer> list1 = new ArrayList<>();
        for (String s : list) {

            StringBuilder sb = new StringBuilder();
            String[] split = s.split(".");
            for (String value : split) {
                sb.append(value);
            }
            if (sb.toString().length() < 4) {
                for (int i = 0; i < 4 - sb.toString().length(); i++) {
                    sb.append(0);
                }
            }
            list1.add(Integer.valueOf(sb.toString()));
        }

        Collections.sort(list1);
        return list1.get(0).toString();
    }
}
