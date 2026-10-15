import java.util.ArrayDeque;

// 프로그래머스 Lv.2
public class 큰_수_만들기_재도전 {

    public String solution(String number, int k) {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        int deleteCount = 0;

        for (int i = 0; i < number.length(); i++) {
            while (!stack.isEmpty() && stack.peekLast() - '0' < number.charAt(i) - '0' && deleteCount < k) {
                stack.pollLast();
                deleteCount++;
            }
            stack.offerLast(number.charAt(i));
        }

        for (int i = 0; i < k - deleteCount; i++) {
            stack.pollLast();
        }

        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        큰_수_만들기_재도전 solution = new 큰_수_만들기_재도전();

        System.out.println(solution.solution("1924", 2));
        System.out.println(solution.solution("1231234", 3));
        System.out.println(solution.solution("4177252841", 4));
    }
}
