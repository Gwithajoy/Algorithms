package Sorting.BasicSorting;// 알고리즘 - 정렬_1

import java.util.Arrays;

public class BasicSortingAlgorithms {
    // 오름차순 기준 정렬 알고리즘

    // 버블 정렬
    public static void bubbleSort(int[] arr) {

    }
    
    // 삽입 정렬
    public static void insertionSort(int[] arr) {

    }

    // 선택 정렬
    private static void selectionSort(int[] arr) {

    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {3, 5, 2, 7, 1, 4};
        bubbleSort(arr);
        System.out.println("버블 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        insertionSort(arr);
        System.out.println("삽입 정렬: " + Arrays.toString(arr));

        arr = new int[]{3, 5, 2, 7, 1, 4};
        selectionSort(arr);
        System.out.println("선택 정렬: " + Arrays.toString(arr));

    }
}
