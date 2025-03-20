package Sorting.Practice;

// Practice4
// 정수 배열 nums 가 주어졌을 때
// 오름차순으로 정렬하기 위해 배열 내에서 정렬이 필요한 구간의 길이를 출력하는 프로그램을 작성하세요.

// 입출력 예시
// 입력: 2, 6, 4, 8, 5, 3, 9, 10
// 출력: 5

// 입력: 1, 3, 1
// 출력: 2


/**
 * [문제 핵심]
 * - 오름차순으로 정렬
 * - 정렬이 필요한 구간의 길이
 *
 *
 * [핵심 키워드 & 아이디어]
 * - 정렬 후 비교
 * - 처음(left)의 흐름에서 다르게 변화하는 부분
 * - 정렬이 끝나야 하는 마지막 인덱스(right)
 * - right - left + 1 -> 처음과 마지막의 구간 길이
 *
 * [조건 / 제한 사항]
 * - 시간 복잡도는 O(N log N) 이내
 *
 * [전략]
 * 1. 배열 복사
 * 2. 복사본을 정렬
 * 3. 원본과 정렬된 배열 비교 -> 처음 차이나는 index -> left
 * 4. 구간 길이 = right - left + 1
 * 5. 만약 전체가 정렬된 경우 return 0
 *
 * [예상 시간복잡도]
 * - O(N log N) (정렬) + O(N) (비교) → 최종 O(N log N)
 */

public class Practice4 {
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0; // 배열이 0 or 원소가 1개 이하면 이미 정렬되었음
        }
        // 정렬을 시작해야 하는 구간의 앞쪽 경계 firstIdx를 찾는 과정 = 오른쪽에 더 작은 숫자가 있는 순간 찾기
        // firstIdx = 어디서부터 정렬해야 하는지
        int min  = Integer.MAX_VALUE;
        int firstIdx = 0;
        for (int i = nums.length - 1; i >= 0; i--) {
            min = Math.min(min, nums[i]);
            if (nums[i] > min)
                firstIdx = i;
        }
        // 정렬을 끝내야 하는 구간의 뒤쪽 경계 lastIdx를 찾는 과정 = 왼쪽에 더 큰 숫자가 있던 순간을 찾기
        // lastIdx = 어디까지 정렬해야 하는지
        int max = 0;
        int lastIdx = -1;
        for (int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]); // 앞에서부터 max값을 갱신하며 검사
            if (nums[i] < max) // 이 경우에는 오름차순 깨진 지점 발견
                lastIdx = i;
        }
        return lastIdx - firstIdx + 1;
    }

    public static void main(String[] args) {
        // Test code
        int[] nums = {2, 6, 4, 8, 5, 3, 9, 10};
        System.out.println(solution(nums));

        nums = new int[]{1, 3, 1};
        System.out.println(solution(nums));

        nums = new int[]{1, 9, 3, 4, 5};
        System.out.println(solution(nums));

        nums = new int[]{1, 2, 3, 4, 5};
        System.out.println(solution(nums));
    }
}
