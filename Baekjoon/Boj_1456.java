import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
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

        limit = (int) Math.sqrt(B);

        sosu = new boolean[limit + 1]; //10^7승까지만 소수를 구해도 된다.
        // 그 이후의 소수를 구해도 거의 소수를 구하기 위해 제곱을 하면 10^14승을 넘어가버리기 때문

        erato(); // 소수 판별

        System.out.println(finalCal());
    }

    private static int finalCal() {
        int cnt = 0;

        for (int i = 1; i < limit + 1; i++) {
            if (!sosu[i]) {
                long curSosu = i;
                int k = 1;
                while (curSosu <= B / Math.pow(curSosu, k)) {
                    if ( A / Math.pow(curSosu, k) <= curSosu) {
                        cnt++;
                    }
                    k++;
                }
            }
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