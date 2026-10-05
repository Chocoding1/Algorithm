import java.util.ArrayDeque;
import java.util.Arrays;

// 프로그래머스 Lv.2
public class 뒤에_있는_큰_수_찾기 {

    public int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        ArrayDeque<Integer> stack = new ArrayDeque<>();

        for (int i = 0; i < numbers.length; i++) {
            while (!stack.isEmpty() && numbers[stack.peek()] < numbers[i]) {
                Integer lastIndex = stack.pop();
                answer[lastIndex] = numbers[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            answer[stack.pop()] = -1;
        }
        return answer;
    }

    public static void main(String[] args) {
        뒤에_있는_큰_수_찾기 solution = new 뒤에_있는_큰_수_찾기();

        System.out.println(Arrays.toString(
                solution.solution(new int[]{2, 3, 3, 5})
        ));
        System.out.println(Arrays.toString(
                solution.solution(new int[]{9, 1, 5, 3, 6, 2})
        ));
    }
}
