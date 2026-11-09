import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// 프로그래머스 Lv.2
public class 배달 {

    public int solution(int N, int[][] road, int K) {
        List<int[]>[] graph = new ArrayList[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] r : road) {
            int start = r[0];
            int end = r[1];
            int time = r[2];
            graph[start].add(new int[]{end, time});
            graph[end].add(new int[]{start, time});
        }
        boolean[] visited = new boolean[N + 1];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        int answer = 0;
        pq.add(new int[]{0, 1});
        while (!pq.isEmpty()) {
            int[] curNode = pq.poll();
            int curTime = curNode[0];
            int curTown = curNode[1];
            if (visited[curTown]) {
                continue;
            }
            visited[curTown] = true;
            answer++;
            for (int[] nxtNode : graph[curTown]) {
                int nxtTown = nxtNode[0];
                int nxtTime = nxtNode[1];
                if (curTime + nxtTime > K) {
                    continue;
                }
                pq.add(new int[]{curTime + nxtTime, nxtTown});
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        배달 solution = new 배달();

        System.out.println(solution.solution(
                5,
                new int[][]{
                        {1, 2, 1}, {2, 3, 3}, {5, 2, 2},
                        {1, 4, 2}, {5, 3, 1}, {5, 4, 2}
                },
                3
        )); // 4

        System.out.println(solution.solution(
                6,
                new int[][]{
                        {1, 2, 1}, {1, 3, 2}, {2, 3, 2}, {3, 4, 3},
                        {3, 5, 2}, {3, 5, 3}, {5, 6, 1}
                },
                4
        )); // 4
    }
}
