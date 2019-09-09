package org.learn.shiro.heap;

import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

/**
 * @author: yxk
 * @date: 2019-04-02 13:57
 */
public class Heap {

    // 数组 从下标为1 存储
    private int[] a;
    // 容量
    private int n;
    // 已储存数量
    private int count;

    // public Heap(int capacity) {
    //     a = new int[capacity + 1];
    //     n = capacity;
    // }

    {
        System.out.println("jiazaila");
    }

    static {
        System.out.println("static");
    }

    public void insert(int data) {
        if (count >= n) {
            return;
        }
        ++count;
        a[count] = data;
        int i = count;
        while (i/2 > 0 && a[i] > a[i/2]) {
            swap(a, i, i/2);
            i = i/2;
        }
    }

    private static void buildHeap(int[] arr, int n) {
        for (int i = n / 2; i > 0; i--) {
            heapify(arr, n, i);
        }
    }

    private static void heapify(int[] arr, int n, int i) {
        while (true) {
            int maxPos = i;
            if (2 * i <= n && arr[i] < arr[2 * i]) {
                maxPos = 2 * i;
            }
            if (2 * i + 1 <= n && arr[maxPos] < arr[2 * i + 1]) {
                maxPos = 2 * i + 1;
            }
            if (maxPos == i) {
                break;
            }
            swap(arr, i, maxPos);
            i = maxPos;
        }
    }

    // n 表示数据的个数，数组 a 中的数据从下标 1 到 n 的位置。
    public static void sort(int[] a, int n) {
        buildHeap(a, n);
        int k = n;
        while (k > 1) {
            swap(a, 1, k);
            --k;
            heapify(a, k, 1);
        }
    }



    private static void swap(int[] a, int i, int i1) {
        if (i == i1) {
            return;
        }
        int temp = a[i];
        a[i] = a[i1];
        a[i1] = temp;
    }

    public static void main(String[] args) {
        // Heap heap = new Heap(10);
        // heap.insert(1);
        // heap.insert(4);
        // heap.insert(3);
        //
        //
        // Comparator<Integer> comparator = new Comparator<Integer>() {
        //     @Override
        //     public int compare(Integer o1, Integer o2) {
        //         return o1 - o2;
        //     }
        // };
        //
        // PriorityQueue<Integer> queue = new PriorityQueue<>(comparator);
        // queue.add(2);
        // queue.add(5);
        // queue.add(1);
        //
        // int h;
        // System.out.println((h = "nihao".hashCode()) ^ (h >>> 16));
    }
}
