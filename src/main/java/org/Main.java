package org;

public class Main {

    private static void selectSort(int[] nums) {

        for (int i = 0; i < nums.length; i++) {
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[index]) {
                    index = j;
                }
            }
            int temp = nums[index];
            nums[index] = nums[i];
            nums[i] = temp;
        }
    }

    public static void main(String[] args) {

        int[] nums = {2, 1, 7, 5, 3};
        selectSort(nums);
        for (int i : nums) {
            System.out.print(i + " ");
        }
    }
}
