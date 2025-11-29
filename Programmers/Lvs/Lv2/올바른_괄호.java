package Lv2;

public class 올바른_괄호 {

    boolean solution(String s) {
        int leftParenCnt = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                leftParenCnt++;
            } else {
                if (leftParenCnt == 0) {
                    return false;
                }
                leftParenCnt--;
            }
        }
        return leftParenCnt == 0;
    }
}
