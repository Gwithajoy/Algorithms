package BinarySearch;

import java.util.Arrays;

// 자바 기본 binarySearch
public class JavaBasicBinarySearch {
    public static void main(String[] args) {
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        // 찾는 값이 있을 때
        System.out.println(Arrays.binarySearch(arr, 1));  // 0
        System.out.println(Arrays.binarySearch(arr, 10)); // 3
        System.out.println(Arrays.binarySearch(arr, 30)); // 5

        // 찾는 값이 없을 때(- (삽입할 위치 인덱스) - 1)
        System.out.println(Arrays.binarySearch(arr, 3));   // -2
        System.out.println(Arrays.binarySearch(arr, 11));  // -5
        System.out.println(Arrays.binarySearch(arr, 35));  // -7
    }
}
