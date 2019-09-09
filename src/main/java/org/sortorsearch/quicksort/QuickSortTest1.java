package org.sortorsearch.quicksort;

public class QuickSortTest1 {

    private static void qsort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = partition1(arr, left, right);
        qsort(arr, left, mid - 1);
        qsort(arr, mid + 1, right);
    }

    private static int partition1(int[] arr, int left, int right) {
        int temp = arr[left];
        while (left < right) {
            while (left < right && arr[right] >= temp) {
                right--;
            }
            arr[left] = arr[right];
            while (left < right && arr[left] <= temp) {
                left++;
            }
            arr[right] = arr[left];
        }
        arr[left] = temp;
        return left;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 1, 5, 3, 7, 8};
        qsort(arr, 0, 5);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
