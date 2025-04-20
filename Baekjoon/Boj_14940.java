import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_14940 {

    private static int[][] map, result;
    private static boolean[][] visited;
    private static int n, m;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n][m];
        visited = new boolean[n][m];
        result = new int[n][m];
        int startI = 0;
        int startJ = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 2) {
                    startI = i;
                    startJ = j;
                }
                if (map[i][j] != 0) {
                    result[i][j] = -1;
                }
            }
        }

        bfs(startI, startJ);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(result[i][j]).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    private static void bfs(int startI, int startJ) {
        int[] di = {0, 1, 0, -1};
        int[] dj = {1, 0, -1, 0};
        Queue<Coord> queue = new LinkedList<>();

        queue.offer(new Coord(startI, startJ));
        result[startI][startJ] = 0;
        visited[startI][startJ] = true;

        while (!queue.isEmpty()) {
            Coord coord = queue.poll();
            int curI = coord.getI();
            int curJ = coord.getJ();

            for (int i = 0; i < 4; i++) {
                int nxtI = curI + di[i];
                int nxtJ = curJ + dj[i];

                if (0 <= nxtI && nxtI < n && 0 <= nxtJ && nxtJ < m) {
                    if (!visited[nxtI][nxtJ] && map[nxtI][nxtJ] != 0) {
                        queue.offer(new Coord(nxtI, nxtJ));
                        result[nxtI][nxtJ] = result[curI][curJ] + 1;
                        visited[nxtI][nxtJ] = true;
                    }
                }
            }
        }
    }

    private static class Coord {
        private int i;
        private int j;

        public Coord(int i, int j) {
            this.i = i;
            this.j = j;
        }

        public int getI() {
            return i;
        }

        public int getJ() {
            return j;
        }
    }
}
