package Lv2;

public class 다음_큰_숫자 {

    static int solution(int n) {
        int nOneCount = Integer.bitCount(n);
        while (true) {
            int nextOneCount = Integer.bitCount(++n);

            if (nOneCount == nextOneCount) {
                return n;
            }
        }
    }

    public static void main(String[] args) {
        System.out.println(solution(78));
    }
}
