import java.util.ArrayDeque;
import java.util.Deque;

// 프로그래머스 Lv.2
public class 큰_수_만들기 {

    public String solution(String number, int k) {
        Deque<Integer> deque = new ArrayDeque<>();
        int[] digits = number.chars()
                .map(c -> c - '0')
                .toArray();
        int count = 0;
        for (int i = 0; i < digits.length; i++) {
            while (!deque.isEmpty() && deque.peekLast() < digits[i] && count < k) {
                deque.pollLast();
                count++;
            }
            deque.offerLast(digits[i]);
        }
        for (int i = 0; i < k - count; i++) {
            deque.pollLast();
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        큰_수_만들기 solution = new 큰_수_만들기();

        System.out.println(solution.solution("1924", 2));
        System.out.println(solution.solution("1231234", 3));
        System.out.println(solution.solution("4177252841", 4));
    }
}
