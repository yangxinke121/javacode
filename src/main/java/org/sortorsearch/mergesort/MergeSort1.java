package org.sortorsearch.mergesort;

public class MergeSort1 {

    private static void mergeSort1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort1(arr, left, mid);
        mergeSort1(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int p =left, q = mid + 1, k = 0;
        int[] temp = new int[right - left + 1];
        while (p <= mid && q <= right) {
            if (arr[p] <= arr[q]) {
                temp[k++] = arr[p++];
            } else {
                temp[k++] = arr[q++];
            }
        }

        while (p <= mid) {
            temp[k++] = arr[p++];
        }

        while (q <= right) {
            temp[k++] = arr[q++];
        }

        for (q = 0; q <= right - left; q++) {
            arr[q + left] = temp[q];
        }
    }

    public static void main(String[] args) {

        int[] arr = new int[]{2, 3, 1, 9, 4, 7, 0};
        mergeSort1(arr, 0, 6);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
