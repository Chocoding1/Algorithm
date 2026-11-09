import java.util.Arrays;

// 프로그래머스 Lv.3
public class 입국심사_재도전 {

    public long solution(int n, int[] times) {
        int minTime = Arrays.stream(times).min().getAsInt();
        long left = 0L, right = (long) minTime * n;

        while (left < right) {
            long mid = (left + right) / 2;
            long availableCount = 0;
            for (int time : times) {
                availableCount += mid / time;
            }

            if (availableCount >= n) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return right;
    }

    public static void main(String[] args) {
        입국심사_재도전 solution = new 입국심사_재도전();

        System.out.println(solution.solution(6, new int[]{7, 10})); // 28
    }
}
