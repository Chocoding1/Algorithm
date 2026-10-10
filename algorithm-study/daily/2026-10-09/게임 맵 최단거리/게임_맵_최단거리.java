import java.util.ArrayDeque;
import java.util.Queue;

// 프로그래머스 Lv.2
public class 게임_맵_최단거리 {

    private final int[][] coord = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private int n, m;
    private Queue<int[]> queue;
    private boolean[][] visited;

    public int solution(int[][] maps) {
        n = maps.length;
        m = maps[0].length;

        queue = new ArrayDeque<>();
        visited = new boolean[n][m];

        queue.offer(new int[]{0, 0, 1});
        visited[0][0] = true;

        return bfs(maps);
    }

    private int bfs(int[][] maps) {
        while (!queue.isEmpty()) {
            int[] curPos = queue.poll();
            int curI = curPos[0];
            int curJ = curPos[1];
            int curCount = curPos[2];
            for (int i = 0; i < 4; i++) {
                int nxtI = curI + coord[i][0];
                int nxtJ = curJ + coord[i][1];
                int nxtCount = curCount + 1;
                if (nxtI == n - 1 && nxtJ == m - 1) {
                    return nxtCount;
                }
                if (0 <= nxtI && nxtI < n && 0 <= nxtJ && nxtJ < m && maps[nxtI][nxtJ] == 1 &&!visited[nxtI][nxtJ]) {
                    queue.offer(new int[]{nxtI, nxtJ, nxtCount});
                    visited[nxtI][nxtJ] = true;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        게임_맵_최단거리 solution = new 게임_맵_최단거리();

        System.out.println(solution.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 1},
                {0, 0, 0, 0, 1}
        }));
        System.out.println(solution.solution(new int[][]{
                {1, 0, 1, 1, 1},
                {1, 0, 1, 0, 1},
                {1, 0, 1, 1, 1},
                {1, 1, 1, 0, 0},
                {0, 0, 0, 0, 1}
        }));
    }
}
