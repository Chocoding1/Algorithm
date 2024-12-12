import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1747 {

    static int N;
    static int limit = 2000000; // N보다 큰 펠린드롬을 구해야 하기 때문에 N의 최댓값보다 크게 범위를 확장해 소수를 구해야 한다.
    static boolean[] isPrime = new boolean[limit + 1]; // 늘린 범위에 맞춰 소수 판별 리스트 초기화

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        erato(); // 소수 구하기

        palindrome(); // 펠린드롬 출력
    }

    /**
     * 펠린드롬 출력 함수
     */
    private static void palindrome() {
        for (int i = N; i < limit + 1; i++) {
            if (!isPrime[i] & isPalindrome(i)) { // 현재 숫자가 소수이면서 동시에 펠린드롬이라면
                System.out.println(i); // 출력하고
                break; // 반복문 탈출 -> 프로그램 종료
            }
        }
    }

    /**
     * 펠린드롬 판별 함수
     */
    private static boolean isPalindrome(int i) {
        String num = String.valueOf(i); // 파라미터로 받은 수를 문자열로 변환(한 자릿수 단위로 비교해야 하기 때문)

        int mid = num.length() / 2; // 숫자의 절반까지만 가도 펠린드롬을 판별할 수 있기 때문에 숫자의 절반 인덱스 계산
        for (int j = 0; j < mid; j++) {
            if (num.charAt(j) != num.charAt(num.length() - 1 - j)) { // 펠린드롬이 아니라면
                return false; // false 반환
            }
        }
        
    }

    /**
     * 소수 판별 함수
     */
    private static void erato() {
        /**
         * false -> 소수 O
         * true -> 소수 X
         */
        isPrime[0] = isPrime[1] = true; // 0과 1은 소수가 아니므로 소수가 아닌 것으로 처리

        for (int i = 2; i < Math.sqrt(limit) + 1; i++) { // 구할 소수의 최대 범위의 제곱근까지만 반복
            if (isPrime[i]) { // 현재 수가 소수가 아니라면
                continue; // 다음 수로 넘어가
            }

            // 현재 수가 소수라면
            for (int j = i * i; j < limit + 1; j += i) { // 구할 소수 최대 범위까지 가면서
                isPrime[j] = true; // 현재 수의 배수들을 소수가 아닌 것으로 처리
            }
        }
    }

}
