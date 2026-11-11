import java.util.ArrayList;
import java.util.List;

// 프로그래머스 Lv.2
public class 전력망을_둘로_나누기_재도전 {

    private List<Integer>[] graph;
    private boolean[] visited;

    public int solution(int n, int[][] wires) {
        graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] wire : wires) {
            graph[wire[0]].add(wire[1]);
            graph[wire[1]].add(wire[0]);
        }
        visited = new boolean[n + 1];
        int answer = n;
        for (int[] wire : wires) {
            visited[1] = true;
            int count = dfs(1, wire);
            int remainCount = n - count;
            answer = Math.min(answer, Math.abs(count - remainCount));
        }
        return answer;
    }

    private int dfs(int v1, int[] wire) {
        int count = 1;
        for (Integer v2 : graph[v1]) {
            if (visited[v2] || (v1 == wire[0] && v2 == wire[1]) || (v1 == wire[1] && v2 == wire[0])) {
                continue;
            }
            visited[v2] = true;
            count += dfs(v2, wire);
            visited[v2] = false;
        }
        return count;
    }

    public static void main(String[] args) {
        전력망을_둘로_나누기_재도전 solution = new 전력망을_둘로_나누기_재도전();

        System.out.println(solution.solution(
                9,
                new int[][]{
                        {1, 3}, {2, 3}, {3, 4}, {4, 5},
                        {4, 6}, {4, 7}, {7, 8}, {7, 9}
                }
        )); // 3

        System.out.println(solution.solution(
                4,
                new int[][]{{1, 2}, {2, 3}, {3, 4}}
        )); // 0

        System.out.println(solution.solution(
                7,
                new int[][]{
                        {1, 2}, {2, 7}, {3, 7},
                        {3, 4}, {4, 5}, {6, 7}
                }
        )); // 1
    }
}
