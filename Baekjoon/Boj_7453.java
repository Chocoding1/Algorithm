import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_7453 {

    private static int n;
    private static int[] A, B, C, D;

    /**
     * 단순 풀 탐색은 4000^4 => O(1000000000000) - 1조의 시간복잡도 => 시간 초과
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        A = new int[n];
        B = new int[n];
        C = new int[n];
        D = new int[n];

        StringTokenizer st;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(useMap());
    }

    private static long useMap() {
        int[] sumAB= sumAB();
        int[] sumCD = sumCD();
        Arrays.sort(sumAB);
        Arrays.sort(sumCD);
        long cnt = 0;
        int left = 0;
        int right = n * n - 1;

        while (left < n * n && right >= 0) {
            if (sumAB[left] + sumCD[right] < 0) {
                left++;
            } else if (sumAB[left] + sumCD[right] > 0) {
                right--;
            } else {
                long leftCnt = 1, rightCnt = 1;
                while (left + 1 < n * n && sumAB[left] == sumAB[left + 1]) {
                    leftCnt++;
                    left++;
                }

                while (right - 1 >= 0 && sumCD[right] == sumCD[right - 1]) {
                    rightCnt++;
                    right--;
                }

                cnt += leftCnt * rightCnt;
                left++;
            }
        }
        return cnt;
    }

    private static int[] sumAB() {
        int[] sumAB = new int[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumAB[index++] = A[i] + B[j];
            }
        }
        return sumAB;
    }

    private static int[] sumCD() {
        int[] sumCD = new int[n * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                sumCD[index++] = C[i] + D[j];
            }
        }
        return sumCD;
    }
}
