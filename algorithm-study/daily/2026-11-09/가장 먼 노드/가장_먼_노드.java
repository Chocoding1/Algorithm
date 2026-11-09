import java.util.*;

// 프로그래머스 Lv.3
public class 가장_먼_노드 {

    public int solution(int n, int[][] edge) {
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);

        List<Integer>[] graph = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{1, 0});
        dist[1] = 0;

        int maxDist = 0;
        while (!queue.isEmpty()) {
            int[] curElement = queue.poll();
            int curNode = curElement[0];
            int curDist = curElement[1];
            for (Integer nxtNode : graph[curNode]) {
                if (curDist + 1 < dist[nxtNode]) {
                    queue.offer(new int[]{nxtNode, curDist + 1});
                    dist[nxtNode] = curDist + 1;
                    maxDist = Math.max(maxDist, dist[nxtNode]);
                }
            }
        }

        int result = 0;
        for (int d : dist) {
            if (d == maxDist) {
                result++;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        가장_먼_노드 solution = new 가장_먼_노드();

        System.out.println(solution.solution(
                6,
                new int[][]{
                        {3, 6}, {4, 3}, {3, 2}, {1, 3},
                        {1, 2}, {2, 4}, {5, 2}
                }
        )); // 3
    }
}
