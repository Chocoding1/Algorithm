// 프로그래머스 Lv.2
public class 프렌즈4블록_재도전 {

    public int solution(int m, int n, String[] board) {
        char[][] result = new char[m][n];
        for (int i = 0; i < m; i++) {
            result[i] = board[i].toCharArray();
        }

        int answer = 0;
        while (true) {
            boolean[][] removed = new boolean[m][n];
            int removeCount = remove(result, removed, m, n);
            if (removeCount == 0) {
                break;
            }
            answer += removeCount;
            down(result, removed, m, n);
        }

        return answer;
    }


    private int remove(char[][] result, boolean[][] removed, int m, int n) {
        for (int i = 0; i < m - 1; i++) {
            for (int j = 0; j < n - 1; j++) {
                if (canRemove(result, i, j)) {
                    removed[i][j] = true;
                    removed[i][j + 1] = true;
                    removed[i + 1][j] = true;
                    removed[i + 1][j + 1] = true;
                }
            }
        }

        int removeCount = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (removed[i][j]) {
                    result[i][j] = '*';
                    removeCount++;
                }
            }
        }

        return removeCount;
    }

    private boolean canRemove(char[][] result, int i, int j) {
        char standard = result[i][j];
        if (standard == '*') {
            return false;
        }
        if (result[i][j + 1] == standard && result[i + 1][j] == standard && result[i + 1][j + 1] == standard) {
            return true;
        }
        return false;
    }

    private void down(char[][] result, boolean[][] removed, int m, int n) {
        for (int j = 0; j < n; j++) {
            for (int i = m - 1; i >= 0; i--) {
                if (result[i][j] == '*') {
                    int count = 1;
                    int index = i;
                    while (index > 0 && result[--index][j] == '*') {
                        count++;
                    }
                    realDown(i, j, count, result);
                }
            }
        }

    }

    private void realDown(int startI, int stdJ, int count, char[][] result) {
        for (int i = startI; i >= 0; i--) {
            if (i - count < 0) {
                break;
            }
            result[i][stdJ] = result[i - count][stdJ];
        }
        for (int i = 0; i < count; i++) {
            result[i][stdJ] = '*';
        }
    }

    public static void main(String[] args) {
        프렌즈4블록_재도전 solution = new 프렌즈4블록_재도전();

        System.out.println(solution.solution(
                4,
                5,
                new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}
        )); // 14

        System.out.println(solution.solution(
                6,
                6,
                new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}
        )); // 15
    }
}
