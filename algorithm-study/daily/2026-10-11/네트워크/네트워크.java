// 프로그래머스 Lv.3
public class 네트워크 {

    private boolean[] visited;

    public int solution(int n, int[][] computers) {
        int answer = 0;
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, n, computers);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(int comIdx, int n, int[][] computers) {
        int[] linkedComputers = computers[comIdx];
        for (int i = 0; i < n; i++) {
            if (linkedComputers[i] == 1 && !visited[i]) {
                visited[i] = true;
                dfs(i, n, computers);
            }
        }
    }

    public static void main(String[] args) {
        네트워크 solution = new 네트워크();

        System.out.println(solution.solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        }));
        System.out.println(solution.solution(3, new int[][]{
                {1, 1, 0},
                {1, 1, 1},
                {0, 1, 1}
        }));
    }
}
