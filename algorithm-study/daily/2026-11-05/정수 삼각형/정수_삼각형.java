import java.util.Arrays;

// 프로그래머스 Lv.3
public class 정수_삼각형 {

    private int n;
    private int[][] maxSum;

    public int solution(int[][] triangle) {
        n = triangle.length;
        maxSum = new int[n][triangle[n - 1].length];
        for (int[] row : maxSum) {
            Arrays.fill(row, -1);
        }

        return search(0, 0, triangle);
    }

    private int search(int i, int j, int[][] triangle) {
        if (i == n - 1) {
            return triangle[i][j];
        }
        if (maxSum[i][j] != -1) {
            return maxSum[i][j];
        }
        maxSum[i][j] = triangle[i][j] + Math.max(search(i + 1, j, triangle), search(i + 1, j + 1, triangle));
        return maxSum[i][j];
    }

    public static void main(String[] args) {
        정수_삼각형 solution = new 정수_삼각형();

        System.out.println(solution.solution(new int[][]{
                {7},
                {3, 8},
                {8, 1, 0},
                {2, 7, 4, 4},
                {4, 5, 2, 6, 5}
        })); // 30
    }
}
