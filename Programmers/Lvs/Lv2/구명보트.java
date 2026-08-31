package Lv2;

import java.util.*;
import java.util.stream.Collectors;

public class 구명보트 {

    /**
     * 내 풀이
     */
    static public int solution(int[] people, int limit) {
        Deque<Integer> deque = Arrays.stream(people)
                .boxed()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toCollection(LinkedList::new));

        int boatCount = 0;
        while (deque.size() >= 2) {
            if (deque.pollFirst() + deque.peekLast() <= limit) {
                deque.pollLast();
            }
            boatCount++;
        }
        if (deque.size() == 1) {
            return ++boatCount;
        }
        return boatCount;
    }

    /**
     * AI 풀이
     */
//    static public int solution(int[] people, int limit) {
//        // 1. 기본형 배열을 직접 오름차순 정렬 (Stream과 객체 변환 없이 가장 빠름)
//        Arrays.sort(people);
//
//        int left = 0; // 가장 가벼운 사람의 인덱스
//        int right = people.length - 1; // 가장 무거운 사람의 인덱스
//        int boatCount = 0;
//
//        // 2. 두 포인터가 엇갈릴 때까지 반복
//        while (left <= right) {
//            // 가장 가벼운 사람과 가장 무거운 사람의 합이 제한 이하라면 둘 다 탑승
//            if (people[left] + people[right] <= limit) {
//                left++;
//            }
//            // 무거운 사람은 조건과 상관없이 항상 1순위로 보트에 탐
//            right--;
//            boatCount++; // 보트 1대 출발
//        }
//
//        return boatCount;
//    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution(new int[]{70, 80, 50}, 100));
    }
}
