import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

// 프로그래머스 Lv.2
public class 주식가격_재도전 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Deque<int[]> stack = new ArrayDeque<>();
        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty()) {
                int[] lastPrice = stack.peekLast();
                if (lastPrice[0] <= prices[i]) {
                    break;
                }

                answer[lastPrice[1]] = i - lastPrice[1];
                stack.pollLast();
            }
            stack.offer(new int[]{prices[i], i});
        }
        while (!stack.isEmpty()) {
            int[] lastPrice = stack.pollLast();
            answer[lastPrice[1]] = prices.length - 1 - lastPrice[1];
        }
        return answer;
    }

    public static void main(String[] args) {
        주식가격_재도전 solution = new 주식가격_재도전();

        System.out.println(Arrays.toString(
                solution.solution(new int[]{1, 2, 3, 2, 3})
        ));
    }
}
