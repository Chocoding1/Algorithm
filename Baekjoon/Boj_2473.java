import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_2473 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long[] values = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            values[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(values);

        long minValue = Long.MAX_VALUE;
        long[] result = new long[3];

        for (int std = 0; std < N - 2; std++) {
            int l = std + 1, r = N - 1;

            while (l < r) {
                long sum = values[std] + values[l] + values[r];
                if (Math.abs(sum) < Math.abs(minValue)) {
                    minValue = sum;
                    result[0] = values[std];
                    result[1] = values[l];
                    result[2] = values[r];
                }

                if (sum < 0) {
                    l++;
                } else {
                    r--;
                }
            }
        }

        Arrays.sort(result);

        System.out.println(result[0] + " " + result[1] + " " + result[2]);
    }
}
