import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Boj_10026 {

    private static int N;
    private static char[][] grid;
    private static boolean[][] visited;
    private static int[] di = {0, 1, 0, -1};
    private static int[] dj = {1, 0, -1, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        grid = new char[N][N];
        for (int i = 0; i < N; i++) {
            grid[i] = br.readLine().toCharArray();
        }

        int nonBildCnt = 0;
        int bildCnt = 0;

        // nonBild
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    nonBildBfs(i, j, grid[i][j]);
                    nonBildCnt++;
                }
            }
        }

        // Bild
        visited = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bildBfs(i, j, grid[i][j]);
                    bildCnt++;
                }
            }
        }

        System.out.println(new StringBuilder().append(nonBildCnt).append(" ").append(bildCnt));
    }

    private static void bildBfs(int i, int j, char stdColor) {
        Queue<Picture> queue = new LinkedList<>();
        queue.offer(new Picture(i, j));
        visited[i][j] = true;
        boolean isRG = (stdColor == 'R' || stdColor == 'G');

        while (!queue.isEmpty()) {
            Picture curPicture = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nxtI = curPicture.i + di[k];
                int nxtJ = curPicture.j + dj[k];

                if (0 <= nxtI && nxtI < N && 0 <= nxtJ && nxtJ < N) {
                    if (!visited[nxtI][nxtJ]) {
                        if (isRG) {
                            if (grid[nxtI][nxtJ] == 'R' || grid[nxtI][nxtJ] == 'G') {
                                queue.offer(new Picture(nxtI, nxtJ));
                                visited[nxtI][nxtJ] = true;
                            }
                        } else {
                            if (grid[nxtI][nxtJ] == 'B') {
                                queue.offer(new Picture(nxtI, nxtJ));
                                visited[nxtI][nxtJ] = true;
                            }
                        }
                    }
                }
            }
        }
    }

    private static void nonBildBfs(int i, int j, char stdColor) {
        Queue<Picture> queue = new LinkedList<>();
        queue.offer(new Picture(i, j));
        visited[i][j] = true;

        while (!queue.isEmpty()) {
            Picture curPicture = queue.poll();
            for (int k = 0; k < 4; k++) {
                int nxtI = curPicture.i + di[k];
                int nxtJ = curPicture.j + dj[k];

                if (0 <= nxtI && nxtI < N && 0 <= nxtJ && nxtJ < N) {
                    if (!visited[nxtI][nxtJ] && grid[nxtI][nxtJ] == stdColor) {
                        queue.offer(new Picture(nxtI, nxtJ));
                        visited[nxtI][nxtJ] = true;
                    }
                }
            }
        }
    }

    private static class Picture {
        int i;
        int j;

        public Picture(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }
}
