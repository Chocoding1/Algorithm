// 프로그래머스 Lv.2
public class 땅따먹기 {

    public int solution(int[][] land) {
        int[] maxScores = land[0].clone();

        for (int row = 1; row < land.length; row++) {
            int[] nextScores = new int[4];

            for (int currentCol = 0; currentCol < 4; currentCol++) {
                for (int previousCol = 0; previousCol < 4; previousCol++) {
                    if (currentCol == previousCol) {
                        continue;
                    }

                    nextScores[currentCol] = Math.max(
                            nextScores[currentCol],
                            maxScores[previousCol] + land[row][currentCol]
                    );
                }
            }

            maxScores = nextScores;
        }

        int answer = 0;
        for (int score : maxScores) {
            answer = Math.max(answer, score);
        }
        return answer;
    }

    public static void main(String[] args) {
        땅따먹기 solution = new 땅따먹기();

        System.out.println(solution.solution(new int[][]{
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        })); // 16
    }
}
