import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_16724 {

    private static int[][] map;
    private static int[][] visited;
    private static int[][] coord = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int cnt = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        visited = new int[N][M];

        for (int i = 0; i < N; i++) {
            String input = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = input.charAt(j);

                if (c == 'U') map[i][j] = 0;
                else if (c == 'D') map[i][j] = 1;
                else if (c == 'L') map[i][j] = 2;
                else map[i][j] = 3;
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (visited[i][j] == 0) {
                    search(i, j);
                }
            }
        }

        System.out.println(cnt);
    }

    private static void search(int i, int j) {
        visited[i][j] = 1;

        int dir = map[i][j];

        int nxtI = i + coord[dir][0];
        int nxtJ = j + coord[dir][1];

        if (visited[nxtI][nxtJ] == 0) {
            search(nxtI, nxtJ);
        } else if (visited[nxtI][nxtJ] == 1) {
            cnt++;
        }

        visited[i][j] = 2;
    }
}
