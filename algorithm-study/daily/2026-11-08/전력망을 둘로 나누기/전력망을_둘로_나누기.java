import java.util.ArrayList;
import java.util.List;

// 프로그래머스 Lv.2
public class 전력망을_둘로_나누기 {

    private List<Integer>[] network;
    private boolean[] visited;
    private int totalCount;

    public int solution(int n, int[][] wires) {
        network = new ArrayList[n + 1];
        for (int i = 0; i < n + 1; i++) {
            network[i] = new ArrayList<>();
        }

        for (int[] wire : wires) {
            int v1 = wire[0];
            int v2 = wire[1];
            network[v1].add(v2);
            network[v2].add(v1);
        }

        visited = new boolean[n + 1];
        int result = n;
        for (int[] deleteWire : wires) {
            totalCount = 1;
            visited[1] = true;
            search(n, deleteWire, 1);
            visited[1] = false;

            int remainCount = n - totalCount;

            result = Math.min(result, Math.abs(totalCount - remainCount));
        }
        return result;
    }

    private void search(int n, int[] deleteWire, int curV) {

        for (int nextV : network[curV]) {
            if (isDeleted(deleteWire, curV, nextV) || visited[nextV]) {
                continue;
            }
            totalCount++;

            visited[nextV] = true;
            search(n, deleteWire, nextV);
            visited[nextV] = false;
        }
    }

    private boolean isDeleted(int[] deleteWire, int curV, int nextV) {
        return deleteWire[0] == curV && deleteWire[1] == nextV || deleteWire[0] == nextV && deleteWire[1] == curV;
    }

    public static void main(String[] args) {
        전력망을_둘로_나누기 solution = new 전력망을_둘로_나누기();

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
