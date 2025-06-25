import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1504 {

    private static class Node implements Comparable<Node> {
        private final int to;
        private final int length;

        public Node(int to, int length) {
            this.to = to;
            this.length = length;
        }

        @Override
        public int compareTo(Node o) {
            return this.length - o.length;
        }
    }

    private static int N, E, v1, v2;
    private static List<Node>[] graph;
    private static boolean[] visited;
    private static int[] minLength;
    private static int INF = 200000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        visited = new boolean[N + 1];
        minLength = new int[N + 1];

        // 인접 리스트 배열 초기화
        graph = new List[N + 1];
        for (int i = 1; i <= N; i++) {
            graph[i] = new ArrayList<>();
        }

        // 인접 리스트 초기화
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            graph[s].add(new Node(e, l));
            graph[e].add(new Node(s, l));
        }

        st = new StringTokenizer(br.readLine());
        v1 = Integer.parseInt(st.nextToken());
        v2 = Integer.parseInt(st.nextToken());

        int res1 = 0;
        res1 += dijkstra(1, v1);
        res1 += dijkstra(v1, v2);
        res1 += dijkstra(v2, N);

        int res2 = 0;
        res2 += dijkstra(1, v2);
        res2 += dijkstra(v2, v1);
        res2 += dijkstra(v1, N);

        if (res1 >= INF && res2 >= INF) {
            System.out.println(-1);
        } else {
            System.out.println(Math.min(res1, res2));
        }
    }

    private static int dijkstra(int start, int end) {
        Arrays.fill(visited, false);
        Arrays.fill(minLength, INF);

        PriorityQueue<Node> queue = new PriorityQueue<>();

        minLength[start] = 0;
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (visited[curNode.to]) {
                continue;
            }
            visited[curNode.to] = true;

            for (Node nxtNode : graph[curNode.to]) {
                if (minLength[nxtNode.to] > curNode.length + nxtNode.length) {
                    minLength[nxtNode.to] = curNode.length + nxtNode.length;
                    queue.offer(new Node(nxtNode.to, minLength[nxtNode.to]));
                }
            }
        }

        return minLength[end];
    }
}
