package Lv2;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Stack;

public class 귤_고르기 {

    static public int solution(int k, int[] tangerine) {
        HashMap<Integer, Integer> countMap = new HashMap<>();

        for (int t : tangerine) {
            countMap.put(t, countMap.getOrDefault(t, 0) + 1);
        }

        List<Integer> counts = countMap.values().stream()
                .sorted(Comparator.reverseOrder())
                .toList();

        int totalCount = 0;
        for (int i = 0; i < counts.size(); i++) {
            totalCount += counts.get(i);
            if (totalCount >= k) {
                return i + 1;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        System.out.println(solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3}));
        System.out.println(solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3}));
    }
}
