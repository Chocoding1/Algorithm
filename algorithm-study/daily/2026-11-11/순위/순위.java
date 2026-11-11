import java.util.ArrayList;
import java.util.List;

// 프로그래머스 Lv.3
public class 순위 {

    public int solution(int n, int[][] results) {
        List<Integer>[] graph = createGraph(n);
        List<Integer>[] reversedGraph = createGraph(n);

        for (int[] result : results) {
            int winner = result[0];
            int loser = result[1];

            graph[winner].add(loser);
            reversedGraph[loser].add(winner);
        }

        int[] win = new int[n + 1];
        int[] lose = new int[n + 1];

        for (int player = 1; player <= n; player++) {
            win[player] = countReachablePlayers(
                    player,
                    graph,
                    new boolean[n + 1]
            );
            lose[player] = countReachablePlayers(
                    player,
                    reversedGraph,
                    new boolean[n + 1]
            );
        }

        int answer = 0;
        for (int player = 1; player <= n; player++) {
            if (win[player] + lose[player] == n - 1) {
                answer++;
            }
        }

        return answer;
    }

    private List<Integer>[] createGraph(int n) {
        List<Integer>[] graph = new ArrayList[n + 1];
        for (int player = 1; player <= n; player++) {
            graph[player] = new ArrayList<>();
        }
        return graph;
    }

    private int countReachablePlayers(
            int current,
            List<Integer>[] graph,
            boolean[] visited
    ) {
        visited[current] = true;
        int count = 0;

        for (int next : graph[current]) {
            if (visited[next]) {
                continue;
            }

            count += 1;
            count += countReachablePlayers(next, graph, visited);
        }

        return count;
    }

    public static void main(String[] args) {
        순위 solution = new 순위();

        System.out.println(solution.solution(
                5,
                new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}
        )); // 2
    }
}
