import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2638 {

    private static int N, M;
    private static int[][] grid;
    private static boolean[][] visited;
    private static List<Pos> cheeseList = new ArrayList<>();
    private static int time;
    private static final int[] di = {0, 1, 0, -1};
    private static final int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        grid = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                grid[i][j] = Integer.parseInt(st.nextToken());
                if (grid[i][j] == 1) {
                    cheeseList.add(new Pos(i, j));
                }
            }
        }

        time = 0;
        while (!cheeseList.isEmpty()) {
            visited = new boolean[N][M];
            airCheck();
            meltingCheese();
            time++;
        }

        System.out.println(time);
    }

    private static void airCheck() {
        Queue<Pos> queue = new LinkedList<>();
        queue.offer(new Pos(0, 0));
        grid[0][0] = 2;
        visited[0][0] = true;

        while (!queue.isEmpty()) {
            Pos pos = queue.poll();

            for (int k = 0; k < 4; k++) {
                int nxtI = pos.i + di[k];
                int nxtJ = pos.j + dj[k];
                if (0 <= nxtI && nxtI < N && 0 <= nxtJ && nxtJ < M) {
                    if (grid[nxtI][nxtJ] == 1 || visited[nxtI][nxtJ]) {
                        continue;
                    }

                    queue.offer(new Pos(nxtI, nxtJ));
                    grid[nxtI][nxtJ] = 2;
                    visited[nxtI][nxtJ] = true;
                }

            }
        }
    }

    private static void meltingCheese() {
        for (int idx = 0; idx < cheeseList.size(); idx++) {
            Pos pos = cheeseList.get(idx);

            int zeroCnt = 0;
            for (int k = 0; k < 4; k++) {
                int nxtI = pos.i + di[k];
                int nxtJ = pos.j + dj[k];
                if (0 <= nxtI && nxtI < N && 0 <= nxtJ && nxtJ < M) {
                    if (grid[nxtI][nxtJ] == 2) {
                        zeroCnt++;
                    }
                }
            }
            if (zeroCnt >= 2) {
                grid[pos.i][pos.j] = 0;
                cheeseList.remove(idx--);
            }
        }
    }

    private static class Pos {
        int i;
        int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
