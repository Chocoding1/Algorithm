import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int[][] fibo = new int[41][2];
        fibo[0][0] = 1;
        fibo[0][1] = 0;
        fibo[1][0] = 0;
        fibo[1][1] = 1;

        StringBuilder sb = new StringBuilder();
        int N;
        for (int i = 0; i < T; i++) {
            N = Integer.parseInt(br.readLine());
            if (N >= 2) {
                for (int j = 2; j <= N; j++) {
                    fibo[j][0] = fibo[j - 1][0] + fibo[j - 2][0];
                    fibo[j][1] = fibo[j - 1][1] + fibo[j - 2][1];
                }
            }

            sb.append(fibo[N][0]).append(" ").append(fibo[N][1]).append("\n");
        }
        System.out.println(sb);
    }
}
