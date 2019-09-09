package org.sortorsearch.quicksort;

public class QuickSort {

    public static void qsort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int partition = partition(arr, left, right);
        qsort(arr, left, partition - 1);
        qsort(arr, partition + 1, right);

    }

    private static int partition(int[] arr, int p, int q) {
        int temp = arr[p];
        while (p < q) {
            while (p < q && arr[q] >= temp) {
                q--;
            }
            arr[p] = arr[q];
            while (p < q && arr[p] <= temp) {
                p++;
            }
            arr[q] = arr[p];
        }
        arr[q] = temp;
        return q;
    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 1, 5, 8, 3, 1};
        qsort(arr, 0, 6);
        for (int i : arr) {
            System.out.print(i + " ");
        }
    }
}
