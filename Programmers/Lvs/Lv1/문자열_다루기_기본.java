package Lv1;

public class 문자열_다루기_기본 {

    static boolean solution(String s) {
        if (s.length() != 4 && s.length() != 6) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(solution("a234"));
        System.out.println(solution("1234"));
    }
}
