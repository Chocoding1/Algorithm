import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1300 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());

        int start = 1;
        int end = k;

        int result = 0;
        while (start <= end) {
            int mid = (start + end) / 2;

            int cnt = 0;
            for (int i = 1; i < N + 1; i++) {
                cnt += Math.min(N, (int) mid / i);
            }

            if (cnt < k) {
                start = mid + 1;
            } else {
                result = mid;
                end = mid - 1;
            }
        }

        System.out.println(result);
    }
}
