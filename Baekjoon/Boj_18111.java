import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_18111 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        int[][] ground = new int[N][M];

        int maxDepth = Integer.MIN_VALUE;
        int minDepth = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                ground[i][j] = Integer.parseInt(st.nextToken());
                maxDepth = Math.max(maxDepth, ground[i][j]);
                minDepth = Math.min(minDepth, ground[i][j]);
            }
        }

        int resultDepth = minDepth;
        int resultTime = Integer.MAX_VALUE;
        for (int depth = minDepth; depth <= maxDepth; depth++) {
            int time = 0;
            int fillCnt = 0;
            int removeCnt = 0;
            int b = B;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (ground[i][j] > depth) {
                        removeCnt += ground[i][j] - depth;
                        b += ground[i][j] - depth;
                    } else if (ground[i][j] < depth){
                        fillCnt += depth - ground[i][j];
                    }
                }
            }

            if (fillCnt > b) {
                continue;
            }
            time += removeCnt * 2;
            time += fillCnt;

            if (resultTime > time) {
                resultTime = time;
                resultDepth = depth;
            } else if (resultTime == time) {
                if (resultDepth < depth) {
                    resultDepth = depth;
                }
            }
        }

        System.out.println(resultTime + " " + resultDepth);
    }
}
