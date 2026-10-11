import java.util.*;

// 프로그래머스 Lv.2
public class 괄호_회전하기 {

    private final List<Character> leftBracket = List.of('(', '{', '[');
    private final List<Character> rightBracket = List.of(')', '}', ']');

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int j = 0; j < s.length(); j++) {
                Character currentBracket = s.charAt((i + j) % s.length());
                if (leftBracket.contains(currentBracket)) {
                    stack.push(currentBracket);
                    continue;
                }

                int rightIdx = rightBracket.indexOf(currentBracket);
                if (stack.isEmpty() || stack.pop() != leftBracket.get(rightIdx)) {
                    break;
                }
                if (j == s.length() - 1 && stack.isEmpty()) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        괄호_회전하기 solution = new 괄호_회전하기();

        System.out.println(solution.solution("[](){}"));
        System.out.println(solution.solution("}]()[{"));
        System.out.println(solution.solution("[)(]"));
        System.out.println(solution.solution("}}}"));
    }
}
