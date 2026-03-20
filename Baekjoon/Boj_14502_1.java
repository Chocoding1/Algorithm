import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14502_1 {

    private static int N, M;
    private static int[][] laboratory;
    private static int[][] copyLaboratory;
    private static int maxSafetyArea = 0;
    private static final List<int[]> virusAreas = new ArrayList<>();
    private static final List<int[]> emptyAreas = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        copyLaboratory = new int[N][M];
        laboratory = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                laboratory[i][j] = Integer.parseInt(st.nextToken());
                if (laboratory[i][j] == 0) {
                    emptyAreas.add(new int[]{i, j});
                    continue;
                }

                if (laboratory[i][j] == 2) {
                    virusAreas.add(new int[]{i, j});
                }
            }
        }

        dfs(-1, 0);
        System.out.println(maxSafetyArea);
    }

    private static void dfs(int emptyAreaIndex, int wallCount) {
        if (wallCount == 3) {
            int countResult = countSafetyAreas();
            maxSafetyArea = Math.max(maxSafetyArea, countResult);
            return;
        }

        for (int i = emptyAreaIndex + 1; i < emptyAreas.size(); i++) {
            int[] curArea = emptyAreas.get(i);
            int curI = curArea[0];
            int curJ = curArea[1];
            laboratory[curI][curJ] = 1;
            dfs(i, wallCount + 1);
            laboratory[curI][curJ] = 0;
        }
    }

    private static int countSafetyAreas() {
        for (int i = 0; i < N; i++) {
            copyLaboratory[i] = laboratory[i].clone();
        }

        for (int[] virusArea : virusAreas) {
            spread(virusArea[0], virusArea[1]);
        }

        return countEmptyAreas();
    }

    private static void spread(int startI, int startJ) {
        int[][] coord = {{0, 1}, {-1, 0}, {0, -1}, {1, 0}};
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{startI, startJ});

        while (!queue.isEmpty()) {
            int[] curArea = queue.poll();
            int curI = curArea[0];
            int curJ = curArea[1];
            for (int i = 0; i < 4; i++) {
                int nxtI = curI + coord[i][0];
                int nxtJ = curJ + coord[i][1];
                if (nxtI < 0 || nxtI >= N || nxtJ < 0 || nxtJ >= M) {
                    continue;
                }
                if (copyLaboratory[nxtI][nxtJ] == 0) {
                    copyLaboratory[nxtI][nxtJ] = 2;
                    queue.offer(new int[]{nxtI, nxtJ});
                }
            }
        }
    }

    private static int countEmptyAreas() {
        int count = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyLaboratory[i][j] == 0) {
                    count++;
                }
            }
        }
        return count;
    }
}
