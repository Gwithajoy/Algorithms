package BinarySearch.Practice;

// Practice1
// 이진 탐색 추가 구현
// target 값이 arr 내에 있으면 해당 인덱스 반환
// 없으면 해당 값이 있을 경우의 위치에 -1을 곱하고 1을 뺀 값을 반환

// 입출력 예시
// 입력 arr: 1, 2, 5, 10, 20, 30, 40, 50, 60

// target: 30
// 출력: 5

// target: 3
// 출력: -3

/**
 * [문제 핵심]
 * - target 값이 arr 내에 있으면 해당 인덱스를 반환
 * - target 값이 없으면 삽입될 위치의 인덱스를 구한 후, (-(삽입 위치) - 1)을 반환
 *
 * [핵심 키워드 & 아이디어]
 * - 입력 배열은 오름차순으로 정렬되어 있음
 * - 탐색 범위를 절반씩 줄여가는 이진 탐색 (Binary Search) 활용
 * - 값을 찾거나 삽입할 위치를 빠르게 계산 가능
 *
 * [전략]
 * 1. left, right, mid 포인터로 이진 탐색 구현
 * 2. target 값과 arr[mid] 값을 비교해 탐색 범위 조절
 * 3. target을 찾으면 mid 반환
 * 4. 찾지 못하면 삽입될 위치 left를 이용해 -(left) - 1 반환
 *
 * [예상 시간복잡도]
 * - O(log N): 매 탐색마다 절반씩 탐색 범위가 줄어들기 때문
 */
public class Practice1 {
    public static int solution(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            if (target == arr[mid]) {
                return mid;
            } else if (target < arr[mid]) {
                right = mid - 1;
            } else if (target > arr[mid]) {
                left = mid + 1;
            }
        }
        return -(left) - 1;
    }

    public static void main(String[] args) {
        // Test code
        int[] arr = {1, 2, 5, 10, 20, 30, 40, 50, 60};
        System.out.println(solution(arr, 30));  // 5
        System.out.println(solution(arr, 3));   // -3
        System.out.println(solution(arr, 11));  // -5
        System.out.println(solution(arr, 35));  // -7
    }
}
