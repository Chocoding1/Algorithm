import java.util.ArrayDeque;
import java.util.Deque;
import java.util.List;
import java.util.Stack;

// 프로그래머스 Lv.2
public class 괄호_회전하기_재도전 {

    private final List<Character> leftBracket = List.of('(', '{', '[');
    private final List<Character> rightBracket = List.of(')', '}', ']');

    public int solution(String s) {
        int answer = 0;
        for (int i = 0; i < s.length(); i++) {
            Deque<Character> stack = new ArrayDeque<>();
            for (int j = 0; j < s.length(); j++) {
                char curC = s.charAt((i + j) % s.length());
                if (leftBracket.contains(curC)) {
                    stack.push(curC);
                    continue;
                }

                if (stack.isEmpty()) {
                    break;
                }

                int leftIdx = leftBracket.indexOf(stack.peek());
                int rightIdx = rightBracket.indexOf(curC);
                if (leftIdx != rightIdx) {
                    break;
                }

                stack.pop();

                if (j == s.length() - 1 && stack.isEmpty()) {
                    answer++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        괄호_회전하기_재도전 solution = new 괄호_회전하기_재도전();

        System.out.println(solution.solution("[](){}"));
        System.out.println(solution.solution("}]()[{"));
        System.out.println(solution.solution("[)(]"));
        System.out.println(solution.solution("}}}"));
    }
}
