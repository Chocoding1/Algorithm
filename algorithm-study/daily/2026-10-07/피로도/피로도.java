// 프로그래머스 Lv.2
public class 피로도 {

    boolean[] visited;
    private int answer = 0;

    public int solution(int k, int[][] dungeons) {
        visited = new boolean[dungeons.length];

        visit(k, dungeons, 0);
        return answer;
    }

    private void visit(int k, int[][] dungeons, int count) {
        answer = Math.max(answer, count);
        if (k == 0) {
            return;
        }

        for (int i = 0; i < dungeons.length; i++) {
            if (k >= dungeons[i][0] && !visited[i]) {
                visited[i] = true;
                visit(k - dungeons[i][1], dungeons, count + 1);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        피로도 solution = new 피로도();

        System.out.println(solution.solution(
                80,
                new int[][]{{80, 20}, {50, 40}, {30, 10}}
        ));
    }
}
