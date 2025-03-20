package Sorting.Practice;

// Practice3
// intervals 라는 구간으로 이루어진 배열이 주어졌을 때,
// 오버랩 되는 구간을 합치는 프로그램을 작성하세요.

// 입출력 예시
// 입력: [2, 6], [1, 3], [15, 18], [8, 10]
// 출력: [1, 6] [8, 10] [15, 18]

import java.util.ArrayList;
import java.util.Arrays;

/**
 * [문제 핵심]
 * - intervals 배열(구간들)이 주어졌을 때 오버랩 되는 구간을 병합
 * - 결과는 오름차순 정렬된 상태로 반환
 *
 * [핵심 키워드 & 아이디어]
 * - 구간(intervals)
 * - 오버랩(겹침) 발생 시 병합
 * - 시작점 기준 정렬 후 순서대로 탐색
 *
 * [조건 / 제한 사항]
 * - 구간의 시작점과 끝점은 정수
 * - 시간복잡도 고려 (최대 N log N)
 *
 * [전략]
 * 1. 시작점 기준으로 정렬
 * 2. 첫 번째 구간부터 순서대로 탐색
 * 3. 현재 구간의 끝 >= 다음 구간의 시작이면 병합
 * 4. 병합이 끝나면 result에 저장
 * 5. 완성된 result 반환
 *
 * [예상 시간복잡도]
 * - O(N log N) (정렬) + O(N) (병합) → O(N log N)
 */

public class Practice3 {

    public static ArrayList<int[]> solution(int[][] intervals) {
        if (intervals == null || intervals.length < 2) {
            return new ArrayList<>();
        }

        // 첫 번째 수 기준으로 정렬
        // # 1
        sort(intervals);

        // # 2
//        Arrays.sort(intervals, (x, y) -> Integer.compare(x[0], y[0]));

        ArrayList<int[]> result = new ArrayList<>();
        // 첫 구간 우선 넣고 시작
        int[] curInterval = intervals[0];
        result.add(curInterval);

        for (int i = 1; i < intervals.length; i++) {
            // 구간 오버랩 도는 경우 구간 합치기
            if (curInterval[1] >= intervals[i][0]) {
                curInterval[1] = intervals[i][1];
            } else {
                // 오버랩 구간 아닌 경우 curInterval 업데이트 후 추가
                curInterval = intervals[i];
                result.add(curInterval);
            }
        }

        return result;
    }

    public static void sort(int[][] intervals) {
        quickSort(intervals, 0, intervals.length - 1);
    }

    public static void quickSort(int[][] arr, int left, int right) {
        if(left >= right) {
            return;
        }

        // 분할
        int pivot = partition(arr, left, right);

        // 기준값 중심으로 좌우 재귀 호출
        quickSort(arr, left, pivot - 1);
        quickSort(arr, pivot + 1, right);
    }

    public static int partition(int[][] arr, int left, int right) {
        int pivot = arr[left][0];
        int i = left;
        int j = right;

        while(i < j) {
            while (arr[j][0] > pivot && i < j) {
                j--;
            }

            while(arr[i][0] <= pivot && i < j) {
                i++;
            }

            swap(arr, i, j);
        }
        swap(arr, left, i);

        return i;
    }

    public static void swap(int[][] arr, int i, int j) {
        int[] temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        // Test code
        int[][] intervals = {{2, 6}, {1, 3}, {15, 18}, {8, 10}};

        for (int[] item: solution(intervals)) {
            System.out.print(Arrays.toString(item) + " ");
        }
        System.out.println();
    }
}
