import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1967 {

    private static class Node implements Comparable<Node> {
        private final int idx;
        private final int weight;

        public Node(int idx, int weight) {
            this.idx = idx;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight - o.weight;
        }
    }

    private static int N;
    private static List<Node>[] tree;
    private static int[] minWeight;
    private static boolean[] visited;
    private static int INF = 10000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        tree = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            tree[i] = new ArrayList<>();
        }

        minWeight = new int[N + 1];
        visited = new boolean[N + 1];

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            tree[from].add(new Node(to, weight));
            tree[to].add(new Node(from, weight));
        }

        int maxIdx = dijkstra(1);
        int resultIdx = dijkstra(maxIdx);
        System.out.println(minWeight[resultIdx]);
    }

    private static int dijkstra(int start) {
        Arrays.fill(minWeight, INF);
        Arrays.fill(visited, false);
        PriorityQueue<Node> queue = new PriorityQueue<>();
        minWeight[start] = 0;
        queue.offer(new Node(start, 0));

        int maxIdx = -1;
        int maxWeight = -1;
        while (!queue.isEmpty()) {
            Node curNode = queue.poll();

            if (visited[curNode.idx]) {
                continue;
            }
            visited[curNode.idx] = true;
            if (maxWeight < curNode.weight) {
                maxIdx = curNode.idx;
                maxWeight = curNode.weight;
            }

            for (Node nxtNode : tree[curNode.idx]) {
                if (minWeight[nxtNode.idx] > curNode.weight + nxtNode.weight) {
                    minWeight[nxtNode.idx] = curNode.weight + nxtNode.weight;
                    queue.offer(new Node(nxtNode.idx, minWeight[nxtNode.idx]));
                }
            }
        }

        return maxIdx;
    }
}
