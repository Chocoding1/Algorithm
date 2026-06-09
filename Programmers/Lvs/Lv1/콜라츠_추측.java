package Lv1;

public class 콜라츠_추측 {

    static int solution(long num) {
        int answer = 0;

        while (num > 1) {
            if (answer >= 500) {
                return -1;
            }

            answer++;
            if (num % 2 == 0) {
                num /= 2;
            } else {
                num *= 3;
                num += 1;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
//        System.out.println(solution(6));
//        System.out.println(solution(16));
        System.out.println(solution(626331));
    }
}
