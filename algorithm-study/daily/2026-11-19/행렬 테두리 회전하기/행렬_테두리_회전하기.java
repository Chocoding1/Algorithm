import java.util.Arrays;

// 프로그래머스 Lv.2
public class 행렬_테두리_회전하기 {

    private int[][] origin;
    private int[] answer;

    public int[] solution(int rows, int columns, int[][] queries) {
        origin = new int[rows + 1][columns + 1];
        int value = 1;
        for (int i = 1; i < rows + 1; i++) {
            for (int j = 1; j < columns + 1; j++) {
                origin[i][j] = value++;
            }
        }
        answer = new int[queries.length];
        for (int i = 0; i < queries.length; i++) {
            int[] query = queries[i];

            int[][] temp = move(rows, columns, query, i);
            changeOrigin(query, temp);
        }

        return answer;
    }

    private int[][] move(int rows, int columns, int[] query, int answerIndex) {
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];
        int[][] temp = new int[rows + 1][columns + 1];
        int minValue = Integer.MAX_VALUE;
        // 왼 -> 오
        for (int j = y1; j < y2 + 1; j++) {
            if (j + 1 > columns) {
                break;
            }
            temp[x1][j + 1] = origin[x1][j];
            minValue = Math.min(minValue, origin[x1][j]);
        }
        // 위 -> 아래
        for (int i = x1; i < x2 + 1; i++) {
            if (i + 1 > rows) {
                break;
            }
            temp[i + 1][y2] = origin[i][y2];
            minValue = Math.min(minValue, origin[i][y2]);
        }
        // 오 -> 외
        for (int j = y2; j > y1 - 1; j--) {
            if (j - 1 < 0) {
                break;
            }
            temp[x2][j - 1] = origin[x2][j];
            minValue = Math.min(minValue, origin[x2][j]);
        }
        // 아래 -> 위
        for (int i = x2; i > x1 - 1; i--) {
            if (i - 1 < 0) {
                break;
            }
            temp[i - 1][y1] = origin[i][y1];
            minValue = Math.min(minValue, origin[i][y1]);
        }

        answer[answerIndex] = minValue;

        return temp;
    }

    private void changeOrigin(int[] query, int[][] temp) {
        int x1 = query[0];
        int y1 = query[1];
        int x2 = query[2];
        int y2 = query[3];

        for (int j = y1; j < y2 + 1; j++) {
            origin[x1][j] = temp[x1][j];
        }
        for (int i = x1; i < x2 + 1; i++) {
            origin[i][y2] = temp[i][y2];
        }
        for (int j = y2; j > y1 - 1; j--) {
            origin[x2][j] = temp[x2][j];
        }
        for (int i = x2; i > x1 - 1; i--) {
            origin[i][y1] = temp[i][y1];
        }
    }

    public static void main(String[] args) {
        행렬_테두리_회전하기 solution = new 행렬_테두리_회전하기();

        System.out.println(Arrays.toString(solution.solution(
                6,
                6,
                new int[][]{
                        {2, 2, 5, 4},
                        {3, 3, 6, 6},
                        {5, 1, 6, 3}
                }
        ))); // [8, 10, 25]

        System.out.println(Arrays.toString(solution.solution(
                3,
                3,
                new int[][]{
                        {1, 1, 2, 2},
                        {1, 2, 2, 3},
                        {2, 1, 3, 2},
                        {2, 2, 3, 3}
                }
        ))); // [1, 1, 5, 3]

        System.out.println(Arrays.toString(solution.solution(
                100,
                97,
                new int[][]{{1, 1, 100, 97}}
        ))); // [1]
    }
}
