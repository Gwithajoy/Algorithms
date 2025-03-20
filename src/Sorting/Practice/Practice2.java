package Sorting.Practice;

// Practice2
// 문자열 배열 strs 가 주어졌을 때 anagram 으로 묶어서 출력하는 프로그램을 작성하세요.
// anagram 은 철자 순서를 바꾸면 같아지는 문자를 의미한다.
// 예) elvis <-> lives
// anagram 그룹 내에서 출력 순서는 상관 없다.

// 입출력 예시
// 입력: "eat", "tea", "tan", "ate", "nat", "bat"
// 출력: [[eat, tea, ate], [bat], [tan, nat]]


import java.util.ArrayList;
import java.util.HashMap;

public class Practice2 {
    public static ArrayList<ArrayList<String>> solution(String[] strs) {
        if (strs == null || strs.length == 0) { // 입력이 null이거나 아무것도 없으면, 빈리스트 반환
            return new ArrayList<>();
        }

        HashMap<String, ArrayList<String>> map = new HashMap<>(); // 아나그램끼리 묶기위해, key로 구분, value로 단어 리스트 모으기

        for(String s : strs) { // 문자열 하나씩 꺼내서 정렬하고 그룹에 찾아 넣기
            char[] cArr = s.toCharArray(); // 문자 하나하나 정렬을 위해 char 배열로 변경
            sort(cArr); // Arrays.sort()가 있으나, 삽입정렬로 구현
            String key = String.valueOf(cArr); // 정렬 후, String으로 변환 아나그램 구분 키

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>()); // 처음 보는 아나그램의 키면 리스트 새로 생성
            }
            map.get(key).add(s); // 같은 아나그램 그룹이면 여기에 추가
        }
        return new ArrayList<>(map.values());
    }

    public static void sort(char[] arr) {
        for (int i = 1; i < arr.length; i++) {
            for (int j = i; j > 0; j--){
                if (arr[j] < arr[j-1]) {
                    char tmp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        // Test code
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(solution(strs));

        strs = new String[]{"abc", "bac", "bca", "xyz", "zyx", "aaa"};
        System.out.println(solution(strs));
    }
}
