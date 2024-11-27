import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10986 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] S = new int[N];
        int[] C = new int[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            if (i == 0) {
                S[i] = Integer.parseInt(st.nextToken());
            } else {
                S[i] = S[i - 1] + Integer.parseInt(st.nextToken());
            }
        }

        int remainder;
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            remainder = S[i] % M;
            if (remainder == 0) {
                cnt += 1;
            }
            C[remainder]++;
        }

        for (int num : C) {
            if (num > 1) {
                cnt += (num * (num - 1) / 2);
            }
        }

        System.out.println(cnt);
    }
}
