package Sorting.NonComparisonBasedSorting;
// 알고리즘 - 정렬_3
// 기수 정렬

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class RadixSort {
    public static void radixSort(int[] arr) {
        ArrayList<Queue<Integer>> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new LinkedList<>());
        }
        int idx = 0;                  // 배열에 다시 넣을 때 사용할 인덱스 (arr에 숫자 넣는 위치)
        int div = 1;                  // 자리수 나누기용 변수 (1의 자리부터 시작 → 10의 자리 → 100의 자리...)
        int maxLen = getMaxLen(arr);  // 배열에서 가장 큰 숫자의 자리수 구하기 (몇 번 반복할지 결정)

// 가장 큰 자리수만큼 반복 (예: maxLen = 2면 1의 자리, 10의 자리 두 번 반복)
        for (int i = 0; i < maxLen; i++) {

            // 배열 전체를 순회하며 각 숫자를 현재 자리수 기준으로 큐에 나눠 담기
            for (int j = 0; j < arr.length; j++) {
                // (arr[j] / div) % 10 → 현재 자리수의 숫자 추출 (예: 32 / 1 % 10 → 2)
                // list.get()으로 해당 숫자에 맞는 큐를 꺼내고 offer()로 큐에 숫자 넣기
                list.get((arr[j] / div) % 10).offer(arr[j]);
            }

            // 0번 큐부터 9번 큐까지 순서대로 꺼내서 다시 배열에 넣기
            for (int j = 0; j < 10; j++) {
                Queue<Integer> queue = list.get(j);   // j번 큐 가져오기

                // 큐가 빌 때까지 하나씩 꺼내서 배열에 저장
                while (!queue.isEmpty()) {
                    arr[idx++] = queue.poll();        // 큐에서 숫자 꺼내서 arr에 넣고 인덱스 증가
                }
            }

            // 다음 자리수를 위해 인덱스 초기화하고 자리수(div) 10배로 늘림
            idx = 0;      // 배열 인덱스 다시 0부터 시작
            div *= 10;     // 자리수 변경 (1의 자리 → 10의 자리 → 100의 자리 ...)
        }
    }

    private static int getMaxLen(int[] arr) {
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            int len = (int)Math.log10(arr[i]) + 1;
            if (maxLen < len) {
                maxLen = len;
            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        // Test code
        int[] arr = {10, 32, 52, 27, 48, 17, 99, 56};
        radixSort(arr);
        System.out.println("기수 정렬: " + Arrays.toString(arr));
    }
}
