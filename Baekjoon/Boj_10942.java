import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10942 {

    private static int[] numbers;
    private static int N, M;
    private static int[][] palindrome;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        numbers = new int[N + 1];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }
        palindrome = new int[N + 1][N + 1];

        makePalindrome();

        M = Integer.parseInt(br.readLine());
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            sb.append(palindrome[Integer.parseInt(st.nextToken())][Integer.parseInt(st.nextToken())]).append("\n");
        }

        System.out.println(sb);
    }

    private static void makePalindrome() {
        for (int i = 1; i < N + 1; i++) {
            for (int j = i; j < N + 1; j++) {
                if (i == j) {
                    palindrome[i][j] = 1;
                    continue;
                }

                if (isPalindrome(i, j)) {
                    palindrome[i][j] = 1;
                } else {
                    palindrome[i][j] = 0;
                }
            }
        }
    }

    private static boolean isPalindrome(int i, int j) {
        while (i < j) {
            if (numbers[i++] != numbers[j--]) {
                return false;
            }
        }
        return true;
    }
}
