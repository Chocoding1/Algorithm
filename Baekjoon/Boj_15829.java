import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 모듈러 연산 특징
 * (A + B) mod M = ((A mod M) + (B mod M)) mod M
 * (A * B) mod M = ((A mod M) * (B mod M)) mod MM
 */
public class Boj_15829 {

//    static final int r = 31;
    static final int M = 1234567891;

    // 내가 처음 푼 풀이(왜 틀린지 아직 못 찾음)
/*
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        long result = 0;
        for (int i = 0; i < L; i++) {
            result += (long) (((int) str[i] - 96) * Math.pow(r, i) % M) % M;
        }

        System.out.println(result % M);
    }
*/
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        long result = 0;
        long r = 1;
        for (int i = 0; i < L; i++) {
            result += (((int) str[i] - 96) * r) % M;
            r = (r * 31) % M;
        }

        System.out.println(result % M);
    }
}
