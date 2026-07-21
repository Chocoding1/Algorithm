package Lv1;

import java.util.Arrays;

public class 문자열_내림차순으_배치하기 {

    static String solution(String s) {
        char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        return new StringBuilder(new String(charArray)).reverse().toString();
    }

    public static void main(String[] args) {
        System.out.println(solution("Zbcdefg"));
    }
}
