import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1929 {

    static boolean[] sosu;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        sosu = new boolean[N + 1];

        erato(N);

        StringBuilder sb = new StringBuilder();
        for (int i = M; i < N + 1; i++) {
            if (!sosu[i]) {
                sb.append(i).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void erato(int n) {
        sosu[1] = true;
        for (int i = 2; i < Math.sqrt(n) + 1; i++) {
            if (!sosu[i]) {
                for (int j = i * i; j < n + 1; j+=i) {
                    sosu[j] = true;
                }
            }
        }
    }
}
