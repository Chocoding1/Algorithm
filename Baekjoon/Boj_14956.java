import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_14956 {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        int n = Integer.parseInt(stringTokenizer.nextToken());
        int m = Integer.parseInt(stringTokenizer.nextToken());

        int[] result = philo(n, m);

        System.out.println(result[0] + " " + result[1]);
    }

    private static int[] philo(int n, int m) {
        if (n == 2) {
            if (m == 1) {
                return new int[]{1, 1};
            }
            if (m == 2) {
                return new int[]{1, 2};
            }
            if (m == 3) {
                return new int[]{2, 2};
            }
            if (m == 4) {
                return new int[]{2, 1};
            }
        }

        int nxtN = n / 2;
        int section = (m - 1) / (nxtN * nxtN);
        int nxtM = m - (nxtN * nxtN * section);

        int[] result = philo(nxtN, nxtM);

        if (section == 0) {
            return new int[]{result[1], result[0]};
        } else if (section == 1) {
            return new int[]{result[0], result[1] + nxtN};
        } else if (section == 2) {
            return new int[]{result[0] + nxtN, result[1] + nxtN};
        } else {
            return new int[]{n - result[1] + 1, nxtN - result[0] + 1};
        }
    }
}
