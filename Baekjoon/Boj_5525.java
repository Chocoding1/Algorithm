import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5525 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());
        String S = br.readLine();

        String P = "I" + "OI".repeat(N);

        int result = 0;
        int ioiCnt = 0;
        for (int i = 1; i < M - 1; i++) {
            if (S.charAt(i - 1) == 'I' && S.charAt(i) == 'O' && S.charAt(i + 1) == 'I') {
                ioiCnt++;

                if (ioiCnt == N) {
                    result++;
                    ioiCnt--;
                }
                i++;
            } else {
                ioiCnt = 0;
            }
        }

        System.out.println(result);
    }
}
