package Lv2;

public class JadenCase_문자열_만들기 {

    public String solution(String s) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;
        for (int i = 0; i < s.length(); i++) {
            char curS = s.charAt(i);
            if (Character.isLetter(curS)) {
                if (isFirst) {
                    sb.append(Character.toUpperCase(curS));
                    isFirst = false;
                } else {
                    sb.append(Character.toLowerCase(curS));
                }
            } else if (curS == ' ') {
                sb.append(curS);
                isFirst = true;
            } else {
                sb.append(curS);
                isFirst = false;
            }
        }

        return sb.toString();
    }
}
