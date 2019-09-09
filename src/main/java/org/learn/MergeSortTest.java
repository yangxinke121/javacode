package org.learn;

public class MergeSortTest {

    public static void mergeSort(int[] arr, int start, int end) {

        if (start >= end) {
            return;
        }
        int mid = (start + end) / 2;
        mergeSort(arr, start, mid);
        mergeSort(arr, mid + 1, end);
        merge(arr, start, mid, end);
    }

    public static void merge(int[] arr, int p, int q, int r) {

        int i = p, j = q + 1, k = 0;
        int[] temp = new int[r - p + 1];
        while (i <= q && j <= r) {
            if (arr[i] < arr[j]) {
                temp[k++] = arr[i++];

            } else {
                temp[k++] = arr[j++];
            }
        }
        while (i <= q) {
            temp[k++] = arr[i++];
        }
        while (j <= r) {
            temp[k++] = arr[j++];
        }

        for (i = 0; i <= r - p; i++) {
            arr[p + i] = temp[i];
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2,3,6,1,4,8,5};
        mergeSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.printf("%d ", i);
        }
    }
}
