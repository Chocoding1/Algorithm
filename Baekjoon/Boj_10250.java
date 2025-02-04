import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10250 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < T; i++) {
            st = new StringTokenizer(br.readLine());
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            StringBuilder sb = new StringBuilder();

            // 방법 1
/*
            if (N % H == 0) {
                sb.append(H);
                if (N / H < 10) {
                    sb.append(0);
                }
                sb.append(N / H);
            } else {
                sb.append(N % H);
                if (N / H + 1 < 10) {
                    sb.append(0);
                }
                sb.append(N / H + 1);
            }
*/

            // 방법 2
            if (N % H == 0) {
                sb.append((H * 100) + (N / H));
            } else {
                sb.append((N % H) * 100 + (N / H) + 1);
            }

            System.out.println(sb);
        }

    }
}
