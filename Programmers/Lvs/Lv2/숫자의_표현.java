package Lv2;

public class 숫자의_표현 {

    static int solution(int n) {
        int answer = 0;
        int start = 1, end = 1;
        int sum = 0;

        while (start <= n) {
            if (sum < n) {
                sum += end++;
            } else if (sum > n) {
                sum -= start++;
            } else {
                answer++;
                sum -= start++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(15));
    }
}