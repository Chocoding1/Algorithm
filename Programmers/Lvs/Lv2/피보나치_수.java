package Lv2;

public class 피보나치_수 {

    private static final int MOD = 1234567;

    static int solution(int n) {
        int prev2 = 0;
        int prev1 = 1;
        int current = 0;

        for (int i = 2; i <= n; i++) {
            // 더하는 단계에서 바로 MOD 연산을 해주어야 오버플로우가 안 납니다.
            current = (prev1 + prev2) % MOD;

            // 다음 계산을 위해 값 한 칸씩 밀기
            prev2 = prev1;
            prev1 = current;
        }

        return current;
    }

    public static void main(String[] args) {
        System.out.println(solution(5));
    }
}
