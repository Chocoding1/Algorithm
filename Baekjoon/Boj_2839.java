import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_2839 {

    /**
     * 1. 5로 나눈 몫 계산
     * 2. 5킬로 봉지를 0봉지부터 나눈 몫만큼의 봉지까지 따지면서 각각의 경우의 수에 3키로 봉지가 몇 봉지가 필요한지, 또는 -1인지 판단
     * 시간복잡도 : N의 최대인 5000을 5로 나눈 1000만큼의 반복이 최대일 듯 하다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int fiveCount = N / 5;
        int totalCount, remainN;
        int result = Integer.MAX_VALUE;
        boolean isMinus;

        for (int i = 0; i < fiveCount + 1; i++) {
            totalCount = 0;
            // i : 5키로 봉지의 수
            // 1. 5키로 봉지 수 totalCount에 플러스
            totalCount += i;
            // 2. 5 * i키로만큼 N에서 마이너스
            remainN = N - 5 * i;
            // 3. 남은 N을 3으로 나눗셈
            // 4. 나눈 나머지가 0이면 나눈 몫을 totalCount에 플러스
            // 5. 나눈 나머지가 0이 아니면 -1
            if (remainN % 3 == 0) {
                totalCount += remainN / 3;
            } else {
                continue;
            }

            result = Math.min(result, totalCount);
        }

        if (result != Integer.MAX_VALUE) {
            System.out.println(result);
        } else {
            System.out.println(-1);
        }
    }
}
