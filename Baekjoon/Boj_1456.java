import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1456 {

    static long A;
    static long B;
    static boolean[] sosu;
    static int limit;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        limit = (int) Math.sqrt(B); // 입력받은 B의 제곱근까지만 소수 구하기

        sosu = new boolean[limit + 1]; // 소수 판별 리스트

        erato(); // 소수 판별

        System.out.println(finalCal()); // 거의 소수 개수 구하기
    }

    private static int finalCal() {
        int cnt = 0;

        for (int i = 1; i < limit + 1; i++) { // 소수 판별 리스트를 돌면서
            if (!sosu[i]) { // 소수이면
                long curSosu = i; // 밑
                int k = 1; // 지수(처음 거듭제곱은 지수가 2일 테니 1로 초기화하여 나눠준다.)
                while (curSosu <= B / Math.pow(curSosu, k)) { // 이항 정리 사용
                    if ( A / Math.pow(curSosu, k) <= curSosu) { // 이항 정리 사용
                        cnt++; // 계산한 거의 소수가 범위 내에 존재하면 결과값 + 1
                    }
                    k++;
                }
            }
            // 해당 코드도 가능(굳이 나눠주지 않아도 long 자료형인 curSosu에 범위를 넘어서는 숫자는 들어가지 않기 때문)
/*
            if (!sosu[i]) {
                long curSosu = i;
                int k = 2; // 이 경우 이항정리를 하지 않기 때문에 지수는 2부터 시작
                while (Math.pow(curSosu, k) <= B) {
                    if ( A <= Math.pow(curSosu, k)) {
                        cnt++;
                    }
                    k++;
                }
            }
*/
        }
        return cnt;
    }

    private static void erato() {
        sosu[0] = sosu[1] = true;
        for (int i = 2; i < Math.sqrt(limit) + 1; i++) {
            if (!sosu[i]) {
                for (int j = i * i; j < limit + 1; j += i) {
                    sosu[j] = true;
                }
            }
        }
    }
}