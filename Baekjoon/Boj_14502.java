import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 접근법 : 벽을 3개씩 세우고, 그 때마다 바이러스를 퍼뜨린 후, 남아있는 안전 영역 체크
 * 우선 벽을 3개 세우는 것은 조합을 이용, 최대 64개의 영역에서 벽을 세울 3개의 영역을 선택하는 경우의 수 = 41,664. 따라서 O(10,000)
 * 매 조합마다 바이러스를 퍼뜨려야 하는데, BFS를 사용하면 된다. 그래프를 통한 탐색 알고리즘의 경우 전체 탐색 공간이 시간 복잡도와 비례하기 때문에 최대 64가 된다.
 * 따라서 대략 O(640000)정도로 예상되기 때문에 시간 내에 풀 수 있을 것으로 판단
 *
 * <풀이 과정>
 * 1. 입력값 초기화(지도 초기화, 바이러스 BFS를 위한 바이러스 리스트 초기화)
 * 2. 벽 3개 배치
 * 3. 안전영역 체크
 *  3-1. 바이러스 전파
 *  3-2. 안전영역 체크
 */
public class Boj_14502 {

    private static int N, M;
    private static int[][] map;
    private static List<int[]> virus = new ArrayList<>();
    private static int lastIdx;
    private static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    virus.add(new int[] {i, j});
                }
            }
        }

        lastIdx = N * M;
        makeWall(-1, 0);

        System.out.println(result);
    }

    private static void makeWall(int start, int depth) {
        if (depth == 3) {
            checkSafeArea();
            return;
        }

        for (int k = start + 1; k < lastIdx; k++) {
            int i = k / M;
            int j = k % M;
            if (map[i][j] == 0) {
                map[i][j] = 1;
                makeWall(k, depth + 1);
                map[i][j] = 0;
            }
        }
    }

    private static void checkSafeArea() {
        int[][] cloneMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            cloneMap[i] = map[i].clone();
        }
        int[][] coord = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        Queue<int[]> queue = new LinkedList<>(virus);

        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            for (int[] c : coord) {
                int nxtI = curPos[0] + c[0];
                int nxtJ = curPos[1] + c[1];
                if (0 <= nxtI && nxtI < N && 0 <= nxtJ && nxtJ < M) {
                    if (cloneMap[nxtI][nxtJ] == 0) {
                        cloneMap[nxtI][nxtJ] = 2;
                        queue.offer(new int[]{nxtI, nxtJ});
                    }
                }
            }
        }

        int safeAreaCnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cloneMap[i][j] == 0) {
                    safeAreaCnt++;
                }
            }
        }

        result = Math.max(result, safeAreaCnt);
    }
}
