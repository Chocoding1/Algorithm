package Lv1;

import java.util.Arrays;

public class 제일_작은_수_제거하기 {

    static int[] solution(int[] arr) {
        if (arr.length == 1) {
            return new int[]{-1};
        }

        int min = Arrays.stream(arr).min().getAsInt();
        return Arrays.stream(arr)
                .filter(num -> num != min)
                .toArray();
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[]{4,3,2,1}));
        System.out.println(solution(new int[]{10}));
    }
}
