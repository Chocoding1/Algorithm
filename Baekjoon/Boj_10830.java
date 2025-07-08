import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10830 {

    private static int N;
    private static int[][] A;
    private static final int MOD = 1000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        long B = Long.parseLong(st.nextToken()); // B는 최대 100,000,000,000까지 가능하기 때문에 long타입 변수로 선언

        A = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                A[i][j] = Integer.parseInt(st.nextToken()) % MOD; // 행렬 인자로 1000이 나올 수 있기 때문에 처음부터 1000으로 나눠준다.
            }
        }

        int[][] result = powMatrix(B);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

    private static int[][] powMatrix(long b) {
        if (b == 1) { // 처음 행렬 나오면 그대로 리턴
            return A;
        }

        int[][] temp = powMatrix(b / 2); // 절반 행렬 계산

        temp = multi(temp, temp); // 제곱해서 b제곱 행렬 계산

        return (b % 2 == 0) ? temp : multi(temp, A);
    }

    private static int[][] multi(int[][] temp1, int[][] temp2) {
        int[][] multiTemp = new int[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < N; k++) {
                    multiTemp[i][j] += temp1[i][k] * temp2[k][j];
                    multiTemp[i][j] %= MOD;
                }
            }
        }
        return multiTemp;
    }
}
