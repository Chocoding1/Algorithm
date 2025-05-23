import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_12851 {

    private static int N, K;
    private static int resultTime = Integer.MAX_VALUE;
    private static int resultCnt = 0;
    private static final int[] time = new int[100001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        if (N == K) {
            System.out.println(0);
            System.out.println(1);
            return;
        }

        Queue<Integer> queue = new LinkedList<>();

        queue.offer(N);

        while (!queue.isEmpty()) {
            int curNum = queue.poll();

            if (time[curNum] == resultTime) {
                break;
            }

            int nxtNum;
            for (int i = 0; i < 3; i++) {
                if (i == 0) {
                    nxtNum = curNum - 1;
                } else if (i == 1) {
                    nxtNum = curNum + 1;
                } else {
                    nxtNum = curNum * 2;
                }

                if (nxtNum == K) {
                    if (time[curNum] + 1 < resultTime) {
                        resultTime = time[curNum] + 1;
                        resultCnt = 1;
                    } else if (time[curNum] + 1 == resultTime) {
                        resultCnt++;
                    }
                    continue;
                }

                if (nxtNum == N || nxtNum < 0 || 100000 < nxtNum) {
                    continue;
                }

                if (time[nxtNum] == 0 || time[nxtNum] == time[curNum] + 1) {
                    queue.offer(nxtNum);
                    time[nxtNum] = time[curNum] + 1;
                }
            }
        }

        System.out.println(resultTime);
        System.out.println(resultCnt);
    }
}
