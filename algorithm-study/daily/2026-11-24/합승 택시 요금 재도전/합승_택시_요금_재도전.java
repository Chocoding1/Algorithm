import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

// 프로그래머스 Lv.3
public class 합승_택시_요금_재도전 {

    private static final int INF = Integer.MAX_VALUE / 4;

    private List<int[]>[] graph;

    public int solution(int n, int s, int a, int b, int[][] fares) {
        graph = new ArrayList[n + 1];

        for (int node = 1; node <= n; node++) {
            graph[node] = new ArrayList<>();
        }

        for (int[] fare : fares) {
            int from = fare[0];
            int to = fare[1];
            int cost = fare[2];

            graph[from].add(new int[]{to, cost});
            graph[to].add(new int[]{from, cost});
        }

        int[] distanceFromS = dijkstra(s, n);
        int[] distanceFromA = dijkstra(a, n);
        int[] distanceFromB = dijkstra(b, n);

        int minCost = INF;

        for (int splitPoint = 1; splitPoint <= n; splitPoint++) {
            if (distanceFromS[splitPoint] == INF
                    || distanceFromA[splitPoint] == INF
                    || distanceFromB[splitPoint] == INF) {
                continue;
            }

            int totalCost = distanceFromS[splitPoint]
                    + distanceFromA[splitPoint]
                    + distanceFromB[splitPoint];

            minCost = Math.min(minCost, totalCost);
        }

        return minCost;
    }

    private int[] dijkstra(int start, int n) {
        int[] distances = new int[n + 1];
        Arrays.fill(distances, INF);

        PriorityQueue<int[]> candidates = new PriorityQueue<>(
                Comparator.comparingInt(candidate -> candidate[1])
        );

        distances[start] = 0;
        candidates.offer(new int[]{start, 0});

        while (!candidates.isEmpty()) {
            int[] current = candidates.poll();
            int currentNode = current[0];
            int currentCost = current[1];

            if (currentCost > distances[currentNode]) {
                continue;
            }

            for (int[] edge : graph[currentNode]) {
                int nextNode = edge[0];
                int nextCost = currentCost + edge[1];

                if (nextCost >= distances[nextNode]) {
                    continue;
                }

                distances[nextNode] = nextCost;
                candidates.offer(new int[]{nextNode, nextCost});
            }
        }

        return distances;
    }

    public static void main(String[] args) {
        합승_택시_요금_재도전 solution = new 합승_택시_요금_재도전();

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
        )); // 82

        System.out.println(solution.solution(
                7,
                3,
                4,
                1,
                new int[][]{
                        {5, 7, 9}, {4, 6, 4}, {3, 6, 1},
                        {3, 2, 3}, {2, 1, 6}
                }
        )); // 14

        System.out.println(solution.solution(
                6,
                4,
                5,
                6,
                new int[][]{
                        {2, 6, 6}, {6, 3, 7}, {4, 6, 7},
                        {6, 5, 11}, {2, 5, 12}, {5, 3, 20},
                        {2, 4, 8}, {4, 3, 9}
                }
        )); // 18
    }
}
