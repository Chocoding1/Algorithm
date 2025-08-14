import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_16236 {

    private static int N;
    private static int startI;
    private static int startJ;
    private static int fishSize = 2;
    private static int eatCnt = 0;
    private static int totTime = 0;
    private static int[][] space;
    private static boolean[][] visited;
    private static final int[] di = {0, 1, 0, -1};
    private static final int[] dj = {1, 0, -1, 0};
    private static PriorityQueue<Node> pQueue;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        space = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
                if (space[i][j] == 9) {
                    startI = i;
                    startJ = j;
                    space[i][j] = 0;
                }
            }
        }

        while (true) {
            searchFish(startI, startJ);
            if (pQueue.isEmpty()) {
                break;
            }
            eatFish();
        }

        System.out.println(totTime);
    }

    private static void searchFish(int startI, int startJ) {
        visited = new boolean[N][N];
        pQueue = new PriorityQueue<>();
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(startI, startJ, 0));
        visited[startI][startJ] = true;

        while (!queue.isEmpty()) {
            Node cur = queue.poll();
            int curI = cur.i;
            int curJ = cur.j;
            int curTime = cur.time;

            for (int i = 0; i < 4; i++) {
                int nxtI = curI + di[i];
                int nxtJ = curJ + dj[i];

                if (0 <= nxtI && nxtI < N && 0 <= nxtJ && nxtJ < N) {
                    if (!visited[nxtI][nxtJ] && space[nxtI][nxtJ] <= fishSize) {
                        queue.offer(new Node(nxtI, nxtJ, curTime + 1));
                        visited[nxtI][nxtJ] = true;

                        if (0 < space[nxtI][nxtJ] && space[nxtI][nxtJ] < fishSize) {
                            pQueue.offer(new Node(nxtI, nxtJ, curTime + 1));
                        }
                    }
                }
            }
        }
    }

    private static void eatFish() {
        Node first = pQueue.poll();
        totTime += first.time;
        startI = first.i;
        startJ = first.j;
        space[startI][startJ] = 0;

        if (++eatCnt == fishSize) {
            eatCnt = 0;
            fishSize++;
        }
    }

    private static class Node implements Comparable<Node> {
        private int i;
        private int j;
        private int time;

        public Node(int i, int j, int time) {
            this.i = i;
            this.j = j;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            if (this.time == o.time) {
                if (this.i == o.i) {
                    return this.j - o.j;
                } else {
                    return this.i - o.i;
                }
            } else {
                return this.time - o.time;
            }
        }
    }
}
