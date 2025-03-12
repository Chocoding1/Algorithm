import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1966 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int TC = Integer.parseInt(st.nextToken());
        int N, M, idx, cnt;
        Queue<int[]> importances;
        boolean isMax;

        for (int i = 0; i < TC; i++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            importances = new LinkedList<>();

            st = new StringTokenizer(br.readLine());
            idx = 0;
            while (st.hasMoreTokens()) {
                importances.offer(new int[]{idx++, Integer.parseInt(st.nextToken())});
            }

            cnt = 0;
            while (true) {
                int[] target = importances.remove();
                isMax = true;
                for (int[] importance : importances) {
                    if (target[1] < importance[1]) {
                        importances.offer(target);
                        isMax = false;
                        break;
                    }
                }
                if (!isMax) {
                    continue;
                }

                cnt++;
                if (target[0] == M) {
                    break;
                }
            }

            System.out.println(cnt);

        }
    }
}
