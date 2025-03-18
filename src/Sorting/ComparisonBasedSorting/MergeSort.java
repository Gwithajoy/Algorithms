package Sorting.ComparisonBasedSorting;

// 합병 정렬 (Divide and Conquer: 분할 정복)

import java.util.Arrays;

public class MergeSort {

    // arr: 정렬할 배열
    // tmp: 임시로 값을 저장할 배열
    // left, right: 현재 정렬할 배열의 구간
    public static void mergeSort(int[] arr, int[] tmp, int left, int right) {
        if (left < right) { // 하나짜리가 될 때까지 쪼갠다
            int mid = (left + right) / 2;

            // 왼쪽 절반 정렬
            mergeSort(arr, tmp, left, mid);
            // 오른쪽 절반 정렬
            mergeSort(arr, tmp, mid + 1, right);
            // 정렬된 두 구간을 병합
            merge(arr, tmp, left, right, mid);
        }
    }

    // 두 부분 배열을 병합하는 과정
    public static void merge(int[] arr, int[] tmp, int left, int right, int mid) {
        int p = left;      // 왼쪽 절반 시작 포인터
        int q = mid + 1;   // 오른쪽 절반 시작 포인터
        int idx = left;    // tmp에 저장할 위치 포인터

        // 왼쪽과 오른쪽을 비교해가며 작은 값을 tmp에 저장
        while (p <= mid && q <= right) {
            if (arr[p] <= arr[q]) {
                tmp[idx++] = arr[p++];
            } else {
                tmp[idx++] = arr[q++];
            }
        }

        // 왼쪽 절반이 남았으면 다 복사
        while (p <= mid) {
            tmp[idx++] = arr[p++];
        }

        // 오른쪽 절반이 남았으면 다 복사
        while (q <= right) {
            tmp[idx++] = arr[q++];
        }

        // tmp에 정렬된 내용을 원래 배열로 복사
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }

    public static void main(String[] args) {
        // 테스트 배열
        int[] arr = {3, 5, 2, 7, 1, 4, 6};
        int[] tmp = new int[arr.length];

        // 정렬 실행
        mergeSort(arr, tmp, 0, arr.length - 1);

        // 결과 출력
        System.out.println("합병 정렬 결과: " + Arrays.toString(arr));
    }
}
