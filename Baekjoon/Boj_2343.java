import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2343 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] video = new int[N];

        int start = 0;
        int end = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            video[i] = Integer.parseInt(st.nextToken());

            end += video[i];
            start = Math.max(start, video[i]);
        }

        int result = end;
        while (start <= end) {
            int bluSize = (start + end) / 2;

            int subSize = 0;
            int m = 0;
            for (int size : video) {
                if (subSize + size > bluSize) {
                    m++;
                    subSize = 0;
                }
                subSize += size;
            }

            if (subSize != 0) {
                m++;
            }

            if (m <= M) {
                result = Math.min(result, bluSize);
                end = bluSize - 1;
            } else {
                start = bluSize + 1;
            }
        }

        System.out.println(result);
    }
}
