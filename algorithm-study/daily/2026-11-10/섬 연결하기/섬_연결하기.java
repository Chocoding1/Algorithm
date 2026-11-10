import java.util.PriorityQueue;

// 프로그래머스 Lv.3
public class 섬_연결하기 {

    private int[] uf;

    public int solution(int n, int[][] costs) {
        uf = new int[n];
        for (int i = 0; i < n; i++) {
            uf[i] = i;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        for (int[] cost : costs) {
            pq.offer(cost);
        }

        int result = 0;
        while (!pq.isEmpty()) {
            int[] edge = pq.poll();
            if (find(edge[0]) == find(edge[1])) {
                continue;
            }

            union(edge[0], edge[1]);
            result += edge[2];
        }
        return result;
    }

    private int find(int idx) {
        if (idx == uf[idx]) {
            return idx;
        }

        uf[idx] = find(uf[idx]);
        return uf[idx];
    }

    private void union(int idx1, int idx2) {
        uf[find(idx1)] = find(idx2);
    }

    public static void main(String[] args) {
        섬_연결하기 solution = new 섬_연결하기();

        System.out.println(solution.solution(
                4,
                new int[][]{
                        {0, 1, 1},
                        {0, 2, 2},
                        {1, 2, 5},
                        {1, 3, 1},
                        {2, 3, 8}
                }
        ));
    }
}
