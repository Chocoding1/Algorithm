import java.util.Arrays;

// 프로그래머스 Lv.3
public class 입국심사 {

    public long solution(int n, int[] times) {
        long answer = 0;
        long left = 0;
        long right = (long) Arrays.stream(times).min().getAsInt() * n;

        while (left <= right) {
            if (left == right) {
                answer = left;
                break;
            }

            long mid = (left + right) / 2;
            long count = 0;
            for (int time : times) {
                count += mid / time;
            }

            if (count < n) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        입국심사 solution = new 입국심사();

        System.out.println(solution.solution(6, new int[]{7, 10})); // 28
    }
}
