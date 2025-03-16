package Sorting.ComparisonBasedSorting;// 힙 정렬

import java.util.Arrays;

public class HeapSort {
    
    public static void heapSort(int[] arr) {

    }

    public static void heapify(int[] arr, int parentIdx, int size) {

    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        heapSort(arr);
        System.out.println("힙 정렬: " + Arrays.toString(arr));
    }
}
