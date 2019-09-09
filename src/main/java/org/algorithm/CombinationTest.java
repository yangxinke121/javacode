package org.algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationTest {

    public void combination(List<Integer> result, List<Integer> list, Integer n) {


        if (n == 0) {
            for (Integer integer : result) {
                System.out.printf("%d ", integer);
            }
            System.out.println();
            return;
        }

        if (list.isEmpty()) {
            return;
        }

        result.add(list.get(0));
        // 选择那个元素
        combination(result, list.subList(1, list.size()), n - 1);

        result.remove(result.size() - 1);
        // 不选择
        combination(result, list.subList(1, list.size()), n);
    }

    /**
     * 从一个集合里选出 n个元素
     * @param args dsds
     */
    public static void main(String[] args) {
        CombinationTest combinationTest = new CombinationTest();
        combinationTest.combination(new ArrayList<>(), Arrays.asList(1,2,3,4,5), 2);
    }
}
