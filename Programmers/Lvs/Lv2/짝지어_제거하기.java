package Lv2;

import java.util.Stack;

public class 짝지어_제거하기 {

    static public int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (stack.isEmpty()) {
                stack.push(s.charAt(i));
                continue;
            }

            if (stack.peek() == s.charAt(i)) {
                stack.pop();
                continue;
            }

            stack.push(s.charAt(i));
        }

        if (stack.isEmpty()) {
            return 1;
        }
        return 0;
    }

    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
        System.out.println(solution("cdcd"));
    }
}
