package org.sortorsearch.quicksort;

public class QuickSortTest3 {

    public void qsort(int[] arr, int left, int right) {

        int partition = partition(arr, left, right);
        qsort(arr, 0, partition - 1);
        qsort(arr, partition + 1, right);
    }

    private int partition(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];

            while (left < right && arr[right] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }
}
