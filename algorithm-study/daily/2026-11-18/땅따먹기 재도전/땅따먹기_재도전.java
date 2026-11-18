// 프로그래머스 Lv.2
public class 땅따먹기_재도전 {

    public int solution(int[][] land) {
        int[] results = land[0].clone();

        for (int i = 1; i < land.length; i++) {
            int[] temp = results.clone();
            for (int k = 0; k < 4; k++) {
                for (int j = 0; j < 4; j++) {
                    if (k == j) {
                        continue;
                    }
                    temp[j] = Math.max(temp[j], results[k] + land[i][j]);
                }
            }
            results = temp;
        }

        int answer = 0;
        for (int result : results) {
            answer = Math.max(answer, result);
        }
        return answer;
    }

    public static void main(String[] args) {
        땅따먹기_재도전 solution = new 땅따먹기_재도전();

        System.out.println(solution.solution(new int[][]{
                {1, 2, 3, 5},
                {5, 6, 7, 8},
                {4, 3, 2, 1}
        })); // 16
    }
}
