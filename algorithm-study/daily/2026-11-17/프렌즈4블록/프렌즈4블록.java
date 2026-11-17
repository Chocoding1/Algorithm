// 프로그래머스 Lv.2
public class 프렌즈4블록 {

    private boolean[][] removed;
    private boolean[][] removedResult;

    public int solution(int m, int n, String[] board) {
        removed = new boolean[m][n];
        removedResult = new boolean[m][n];

        int answer = 0;
        while (true) {
            removed = new boolean[m][n];
            for (int i = m - 1; i >= 0; i--) {
                for (int j = 0; j < n; j++) {
                    checkRemove(i, j, n, board);
                }
            }
            int count = 0;
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (removed[i][j]) {
                        removedResult[i][j] = true;
                        count++;
                    }
                }
            }
            if (count == 0) {
                break;
            }
            answer += count;
        }
        return answer;
    }

    private void checkRemove(int i, int j, int n, String[] board) {
        int startI1 = getUpBlockI(i, j);
        if (startI1 == -1) {
            return;
        }
        char startBlock = board[startI1].charAt(j);
        if (startI1 - 1 < 0 || j + 1 >= n) {
            return;
        }

        int startI2 = getUpBlockI(i, j + 1);
        if (startI2 == -1) {
            return;
        }
        if (board[startI2].charAt(j + 1) != startBlock) {
            return;
        }

        int upBlockI1 = getUpBlockI(startI1 - 1, j);
        if (upBlockI1 == -1) {
            return;
        }

        int upBlockI2 = getUpBlockI(startI2 - 1, j + 1);
        if (upBlockI2 == -1) {
            return;
        }

        if (board[upBlockI1].charAt(j) != startBlock || board[upBlockI2].charAt(j + 1) != startBlock) {
            return;
        }

        removed[startI1][j] = true;
        removed[startI2][j + 1] = true;
        removed[upBlockI1][j] = true;
        removed[upBlockI2][j + 1] = true;
    }

    private int getUpBlockI(int startI, int j) {
        for (int i = startI; i >= 0 ; i--) {
            if (removedResult[i][j]) {
                continue;
            }
            return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        프렌즈4블록 solution = new 프렌즈4블록();

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
