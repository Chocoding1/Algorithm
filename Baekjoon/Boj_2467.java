import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2467 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] values = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            values[i] = Long.parseLong(st.nextToken());
        }

        long totValue = 2000000000;
        long v1 = 0;
        long v2 = 0;
        int left = 0;
        int right = N - 1;
        while (left < right) {
            long sum = values[left] + values[right];
            if (totValue > Math.abs(sum)) {
                totValue = Math.abs(sum);
                v1 = values[left];
                v2 = values[right];
            }

            if (sum >= 0) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(new StringBuilder().append(v1).append(" ").append(v2));
    }
}
