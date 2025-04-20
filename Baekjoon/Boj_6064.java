import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_6064 {

    private static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        int x, y;
        StringBuilder sb = new StringBuilder();
        for (int t = 0; t < T; t++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            M = Integer.parseInt(st.nextToken());
            N = Integer.parseInt(st.nextToken());
            x = Integer.parseInt(st.nextToken()) - 1;
            y = Integer.parseInt(st.nextToken()) - 1;

            // 최소공배수 구하기
            int lcm = calLcm();

            int result = -1;
            int curM = x;
            while (curM <= lcm) {
                if (curM % N == y) {
                    result = curM + 1;
                    break;
                }
                curM += M;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static int calLcm() {
        return M * N / calGcd(M, N);
    }

    private static int calGcd(int m, int n) {
        if (n == 0) {
            return m;
        }

        return calGcd(n, m % n);
    }
}
