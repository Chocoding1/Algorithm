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
    static int limit = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Long.parseLong(st.nextToken());
        B = Long.parseLong(st.nextToken());

        sosu = new boolean[limit + 1];

        erato();

        System.out.println(finalCal());
    }

    private static int finalCal() {
        int cnt = 0;

        for (int i = 1; i < Math.sqrt(B) + 1; i++) {
            if (!sosu[i]) {
                long j = i * i;
                while (j < B + 1) {
                    if (A <= j) {
                        cnt += 1;
                    }
                    j *= i;
                }
            }
        }
        return cnt;
    }

    private static void erato() {
        sosu[0] = sosu[1] = true;
        for (int i = 2; i < Math.sqrt(B) + 1; i++) {
            if (!sosu[i]) {
                for (int j = i * i; j < limit + 1; j += i) {
                    sosu[j] = true;
                }
            }
        }
    }
}
