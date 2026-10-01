import java.util.Stack;

// 프로그래머스 Lv.2
public class 올바른_괄호 {

    boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char parenthesis = s.charAt(i);
            if (parenthesis == '(') {
                stack.push(parenthesis);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        올바른_괄호 solution = new 올바른_괄호();

        System.out.println(solution.solution("()()"));
        System.out.println(solution.solution("(())()"));
        System.out.println(solution.solution(")()("));
        System.out.println(solution.solution("(()("));
    }
}
