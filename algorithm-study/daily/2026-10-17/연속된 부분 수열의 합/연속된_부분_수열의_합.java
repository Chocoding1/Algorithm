import java.util.Arrays;

// 프로그래머스 Lv.2
public class 연속된_부분_수열의_합 {

    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        answer[1] = sequence.length - 1;

        int left = 0, right = 0;
        int sum = sequence[left];

        while (left <= right && left < sequence.length && right < sequence.length) {
            if (sum == k) {
                int minLength = answer[1] - answer[0] + 1;
                int curLength = right - left + 1;
                if (curLength < minLength) {
                    answer[0] = left;
                    answer[1] = right;
                }
            }

            if (sum < k) {
                if (right + 1 >= sequence.length) {
                    break;
                }
                sum += sequence[++right];
                continue;
            }

            sum -= sequence[left++];
        }
        return answer;
    }

    public static void main(String[] args) {
        연속된_부분_수열의_합 solution = new 연속된_부분_수열의_합();

        System.out.println(Arrays.toString(solution.solution(
                new int[]{1, 2, 3, 4, 5}, 7)));
        System.out.println(Arrays.toString(solution.solution(
                new int[]{1, 1, 1, 2, 3, 4, 5}, 5)));
        System.out.println(Arrays.toString(solution.solution(
                new int[]{2, 2, 2, 2, 2}, 6)));
    }
}
