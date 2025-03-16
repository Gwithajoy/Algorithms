package Sorting.ComparisonBasedSorting;// 퀵 정렬

import java.util.Arrays;

public class QuickSort {

    public static void quickSort(int[] arr, int left, int right) {

    }

    public static int partition(int[] arr, int left, int right) {

        return 0;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 7, 9, 4, 5, 8};
        quickSort(arr, 0, arr.length - 1);
        System.out.println("퀵 정렬: " + Arrays.toString(arr));
    }
}
