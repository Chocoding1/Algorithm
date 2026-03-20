import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class boj_30805_1 {

    private static int N, M;
    private static String[] A, B;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = new String[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = st.nextToken();
        }
        M = Integer.parseInt(br.readLine());
        B = new String[M];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            B[i] = st.nextToken();
        }

        int[] lcs = getLCS();
        printResult(lcs);

    }

    private static int[] getLCS() {
        String[][] lcsMaker = new String[N + 1][M + 1];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < M + 1; j++) {
                if (i == 0 || j == 0) {
                    lcsMaker[i][j] = "";
                    continue;
                }

                if (A[i - 1].equals(B[j - 1])) {
                    if (lcsMaker[i - 1][j - 1].isEmpty()) {
                        lcsMaker[i][j] = A[i - 1];
                    } else {
                        lcsMaker[i][j] = String.join(",", lcsMaker[i - 1][j - 1], A[i - 1]);
                    }
                } else {
                    lcsMaker[i][j] = lcsMaker[i - 1][j].length() > lcsMaker[i][j - 1].length() ? lcsMaker[i - 1][j]
                            : lcsMaker[i][j - 1];
                }
            }
        }

        return Arrays.stream(lcsMaker[N][M].split(","))
                .mapToInt(Integer::parseInt)
                .toArray();
    }

    private static void printResult(int[] lcs) {
        Deque<Integer> deque = new LinkedList<>();

        for (int number : lcs) {
            if (deque.isEmpty()) {
                deque.offerLast(number);
                continue;
            }

            while (!deque.isEmpty()) {
                if (number <= deque.peekLast()) {
                    break;
                }
                deque.pollLast();
            }
            deque.offerLast(number);
        }

        System.out.println(deque.size());
        while (!deque.isEmpty()) {
            System.out.print(deque.pollFirst() + " ");
        }
    }
}
