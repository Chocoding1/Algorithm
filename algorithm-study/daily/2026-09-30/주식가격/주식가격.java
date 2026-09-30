import java.util.ArrayDeque;
import java.util.Arrays;

// 프로그래머스 Lv.2
public class 주식가격 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int current = 0; current < prices.length; current++) {
            while (!stack.isEmpty()
                    && prices[stack.peek()] > prices[current]) {
                int previous = stack.pop();
                answer[previous] = current - previous;
            }

            stack.push(current);
        }

        int lastIndex = prices.length - 1;
        while (!stack.isEmpty()) {
            int index = stack.pop();
            answer[index] = lastIndex - index;
        }

        return answer;
    }

    public static void main(String[] args) {
        주식가격 solution = new 주식가격();

        System.out.println(Arrays.toString(
                solution.solution(new int[]{1, 2, 3, 2, 3})
        ));
    }
}
