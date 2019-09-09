package org.sortorsearch.mergesort;

public class MergeSort {

    private static void mergeSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int mid = left + ((right - left) >> 1);
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        merge(arr, left, mid, right);
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        int start = i;
        int end = mid;
        if (j <= right) {
            start = j;
            end = right;
        }
        while (start <= end) {
            temp[k++] = arr[start++];
        }

        for (i = 0; i <= right - left; i++) {
            arr[left + i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] ints = {2, 3, 4, 1, 5, 0};
        mergeSort(ints, 0, 5);
        for (int i : ints) {
            System.out.print(i + " ");
        }
    }
}
