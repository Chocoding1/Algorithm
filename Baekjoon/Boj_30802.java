import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_30802 {

    /**
     * T : 각 신청자 수를 T로 나눴을 때 나머지가 있으면 나눈 몫 + 1, 나머지가 없으면 나눈 몫으로 사이즈별 최소 묶음 계산 -> sum
     * P : 참가자 수를 P로 나눈 몫(묶음), 나머지(자루)
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] counts = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        int tOrder = 0;
        for (int count : counts) {
            if (count % T == 0) {
                tOrder += count / T;
            } else {
                tOrder += count / T + 1;
            }
        }
        sb.append(tOrder).append("\n");
        sb.append(N / P).append(" ").append(N % P);

        System.out.println(sb);
    }
}
