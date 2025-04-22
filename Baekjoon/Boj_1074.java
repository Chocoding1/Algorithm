import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1074 {

    private static int r, c;
    private static int seq = 0;
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        N = (int) Math.pow(2, N);

        visit(0, 0, N);

        System.out.println(result);
    }

    private static void visit(int startI, int startJ, int n) {
        if (result != -1) { // 정답이 나왔으면 그 다음 재귀들은 안 해도 됨
            return;
        }

        if (r < startI || startI + n - 1 < r || c < startJ || startJ + n - 1 < c) {
            seq += (int) Math.pow(n, 2);
            return;
        }

        if (n == 2) {
            for (int i = startI; i < startI + n; i++) {
                for (int j = startJ; j < startJ + n; j++) {
                    if (i == r && j == c) {
                        result = seq;
                        return;
                    }
                    seq++;
                }
            }
        } else {
            visit(startI, startJ, n / 2);
            visit(startI, startJ + n / 2, n / 2);
            visit(startI + n / 2, startJ, n / 2);
            visit(startI + n / 2, startJ + n / 2, n / 2);
        }
    }
}
