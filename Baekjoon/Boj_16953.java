import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_16953 {

    private static int A, B;
    private static int result = -1;
    private static HashSet<Integer> history = new HashSet<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        int cnt = 0;
        while (B >= A) {
            if (B == A) {
                result = ++cnt;
                break;
            }
            if (B % 10 == 1) {
                B /= 10;
            } else if (B % 2 == 0) {
                B /= 2;
            } else {
                break;
            }
            cnt++;
        }


        System.out.println(result);
    }
}
/**
 * DFS로도 풀이 가능
 */
/*
public class Main {

    private static int A, B;
    private static int result = -1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        A = Integer.parseInt(st.nextToken());
        B = Integer.parseInt(st.nextToken());

        dfs(A, 0);
        System.out.println(result);
    }

    private static void dfs(long num, int cnt) {
        if (num == B) {
            if (result == -1) {
                result = cnt + 1;
            } else {
                result = Math.min(result, cnt + 1);
            }
            return;
        }

        if (num > B) {
            return;
        }

        dfs(num * 10 + 1, cnt + 1);
        dfs(num * 2, cnt + 1);
    }
}
*/
