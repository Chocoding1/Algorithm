import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 모듈러 연산 특징
 * (A + B) mod M = ((A mod M) + (B mod M)) mod M
 * (A * B) mod M = ((A mod M) * (B mod M)) mod MM
 */
public class Boj_15829 {

    static final int r = 31;
    static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        long result = 0;
        long powValue = 1;
        for (int i = 0; i < L; i++) {
            result += (((int) str[i] - 96) * powValue) % M;
            powValue = (powValue * r) % M;
        }

        System.out.println(result % M);

        /**
         * 초기 코드 (오답)
         * result += (((int) str[i] - 96) * (Math.pow(r, i) % M)) % M
         * Math.pow()에서 이미 long 범위를 넘어가기 때문에 M으로 바로 나눠준다고 해도 범위 초과
         */
    }
}
