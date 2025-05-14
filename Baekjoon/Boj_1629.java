import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1629 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        System.out.println(comb(A, B, C));
    }

    private static long comb(int base, int exp, int mod) {
        if (exp == 1) {
            return base % mod;
        }

        if (exp == 0) {
            return 1;
        }

        long result = comb(base, exp / 2, mod);

        if (exp % 2 == 1) {
            return (result * result % mod) * base % mod;
        } else {
            return result * result % mod;
        }
    }
}
