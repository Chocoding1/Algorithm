import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 프로그래머스 Lv.3
public class 합승_택시_요금 {

    private static final int INF = Integer.MAX_VALUE;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        List<Edge>[] graph = createGraph(n, fares);

        int[] distanceFromStart = dijkstra(s, graph);
        int[] distanceFromA = dijkstra(a, graph);
        int[] distanceFromB = dijkstra(b, graph);

        int answer = INF;

        for (int split = 1; split <= n; split++) {
            if (distanceFromStart[split] == INF
                    || distanceFromA[split] == INF
                    || distanceFromB[split] == INF) {
                continue;
            }

            int totalCost = distanceFromStart[split]
                    + distanceFromA[split]
                    + distanceFromB[split];

            answer = Math.min(answer, totalCost);
        }

        return answer;
    }

    @SuppressWarnings("unchecked")
    private List<Edge>[] createGraph(int n, int[][] fares) {
        List<Edge>[] graph = new ArrayList[n + 1];

        for (int node = 1; node <= n; node++) {
            graph[node] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            graph[from].add(new Edge(to, cost));
            graph[to].add(new Edge(from, cost));
        }

        return graph;
    }

    private int[] dijkstra(int start, List<Edge>[] graph) {
        int[] distance = new int[graph.length];
        Arrays.fill(distance, INF);
        distance[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(
                Comparator.comparingInt(node -> node.cost)
        );
        queue.offer(new Node(start, 0));

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.cost > distance[current.number]) {
                continue;
            }

            for (Edge edge : graph[current.number]) {
                int nextCost = current.cost + edge.cost;

                if (nextCost >= distance[edge.to]) {
                    continue;
                }

                distance[edge.to] = nextCost;
                queue.offer(new Node(edge.to, nextCost));
            }
        }

        return distance;
    }

    private static class Edge {
        private final int to;
        private final int cost;

        private Edge(int to, int cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    private static class Node {
        private final int number;
        private final int cost;

        private Node(int number, int cost) {
            this.number = number;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        합승_택시_요금 solution = new 합승_택시_요금();

        System.out.println(solution.solution(
                6,
                4,
                6,
                2,
                new int[][]{
                        {4, 1, 10}, {3, 5, 24}, {5, 6, 2},
                        {3, 1, 41}, {5, 1, 24}, {4, 6, 50},
                        {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
                }
        ));
        System.out.println(solution.solution(
                7,
                3,
                4,
                1,
                new int[][]{
                        {5, 7, 9}, {4, 6, 4}, {3, 6, 1},
                        {3, 2, 3}, {2, 1, 6}
                }
        ));
        System.out.println(solution.solution(
                6,
                4,
                5,
                6,
                new int[][]{
                        {2, 6, 6}, {6, 3, 7}, {4, 6, 7}, {6, 5, 11},
                        {2, 5, 12}, {5, 3, 20}, {2, 4, 8}, {4, 3, 9}
                }
        ));
    }
}
