import java.util.*;

// 프로그래머스 Lv.3
public class 부대복귀 {

    private List<Integer>[] graph;
    private boolean[] visited;

    public int[] solution(int n, int[][] roads, int[] sources, int destination) {
        graph = new ArrayList[n + 1];
        for(int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for(int[] road : roads) {
            graph[road[0]].add(road[1]);
            graph[road[1]].add(road[0]);
        }

        List<Integer> result = new ArrayList<>();
        for(int source : sources) {
            visited = new boolean[n + 1];
            result.add(bfs(source, destination));
        }

        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    private int bfs(int start, int destination) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{start, 0});
        visited[start] = true;

        while (!queue.isEmpty()) {
            int[] curArea = queue.poll();
            if (curArea[0] == destination) {
                return curArea[1];
            }
            for (int nxtArea : graph[curArea[0]]) {
                if (!visited[nxtArea]) {
                    queue.offer(new int[]{nxtArea, curArea[1] + 1});
                    visited[nxtArea] = true;
                }
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        부대복귀 solution = new 부대복귀();

        System.out.println(Arrays.toString(solution.solution(
                3,
                new int[][]{{1, 2}, {2, 3}},
                new int[]{2, 3},
                1
        ))); // [1, 2]
    }
}
