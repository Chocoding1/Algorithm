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
 * dfs의 파라미터로 넘겨주는 수를 long이 아닌 int로 설정해서 틀린 문제
 * 이떄 왜 10^9인데 INT형을 사용하면 안되는가? 라는 생각이 듭니다. 이유는 B값(10^9)보다 크면 애초에 중단시키는데 말입니다.
 * 반례를 제시해보겠습니다.9*10^8 이 주어졌다고 가정합니다. 이떄 2*9*10^8 이 곱해질경우에는 안전합니다.10*9*10^8 + 1이 될경우에는?  90억 + 1 이 되면서 INT형의 범위 21억(2^31 - 1)을 초과합니다.
 * 출처 : https://passionfruit200.tistory.com/453
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
