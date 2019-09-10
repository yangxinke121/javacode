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
        int i = left;
        int j = mid + 1;
        int k = 0;
        int[] temp = new int[right - left + 1];
        while (i <= mid && j <= right) {
            if (arr[i] > arr[j]) {
                temp[k++] = arr[j++];
            } else {
                temp[k++] = arr[i++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= right) {
            temp[k++] = arr[j++];
        }
        for (i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
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
