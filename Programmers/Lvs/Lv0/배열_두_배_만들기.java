package Lv0;

import java.util.Arrays;

public class 배열_두_배_만들기 {
    public int[] solution(int[] numbers) {
        return Arrays.stream(numbers).map(x -> 2 * x).toArray();
    }
}
