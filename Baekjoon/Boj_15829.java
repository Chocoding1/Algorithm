import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_15829 {

    static final int r = 31;
    static final int M = 1234567891;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());
        char[] str = br.readLine().toCharArray();

        int result = 0;
        for (int i = 0; i < L; i++) {
            result += (int) (((int) str[i] - 96) * Math.pow(r, i)) % M;
        }

        System.out.println(result % M);
    }
}
