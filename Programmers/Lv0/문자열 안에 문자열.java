public class 문자열_안에_문자열 {
    public int solution(String str1, String str2) {
        if (str1.contains(str2)) {
            return 1;
        } else {
            return 2;
        }

        // 삼항연산자 사용
//        return (str1.contains(str2) ? 1 : 2);
    }
}
