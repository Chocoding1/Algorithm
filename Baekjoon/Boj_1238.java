import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Array;
import java.util.*;

/**
 * 준비물 : N, M, X, 인접 리스트, X 들렸다가 돌아오는 경로 저장할 배열
 *
 * 풀이 과정
 * 1. N, M, X, 인접 리스트, 경로 저장 배열 초기화
 * 2. X를 제외한 각 마을에서 X까지 가는 최단 경로 계산
 * 3. X부터 모든 마을의 최단 경로 계산
 * 4. 각 마을마다 두 최단 경로를 더해서 가장 큰 값 추출
 */
public class Boj_1238 {

    private static int N, M, X;
    private static List<int[]>[] roadMap;
    private static int[] time;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        X = Integer.parseInt(st.nextToken());


        roadMap = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            roadMap[i] = new ArrayList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            roadMap[s].add(new int[]{e, t});
        }

        time = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            toX(i); // X까지의 최단 거리 구하기
        }
        toHome(); // X로부터 각 마을까지의 최단 거리 구하기

        System.out.println(getMaxTime());
    }

    private static void toX(int startIdx) {
        visited = new boolean[N + 1];
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.offer(new int[]{startIdx, 0});

        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();
            int curIdx = curNode[0];
            int curTime = curNode[1];

            if (curIdx == X) {
                time[startIdx] = curTime;
                return;
            }

            if (visited[curIdx]) {
                continue;
            }

            visited[curIdx] = true;
            for (int[] nxtNode : roadMap[curIdx]) {
                int nxtIdx = nxtNode[0];
                int nxtTime = nxtNode[1];

                queue.offer(new int[]{nxtIdx, curTime + nxtTime});
            }
        }
    }

    private static void toHome() {
        visited = new boolean[N + 1];
        Queue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.offer(new int[]{X, 0});

        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();
            int curIdx = curNode[0];
            int curTime = curNode[1];

            if (visited[curIdx]) {
                continue;
            }

            visited[curIdx] = true;
            time[curIdx] += curTime;

            for (int[] nxtNode : roadMap[curIdx]) {
                int nxtIdx = nxtNode[0];
                int nxtTime = nxtNode[1];

                queue.offer(new int[]{nxtIdx, curTime + nxtTime});
            }
        }
    }

    private static int getMaxTime() {
        int maxTime = 0;
        for (int time : time) {
            if (maxTime < time) {
                maxTime = time;
            }
        }

        return maxTime;
    }
}
