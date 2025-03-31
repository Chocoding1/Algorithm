import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * 계수 정렬 사용
 * 리스트 사용해서 숫자 인덱스에 + 1하고
 * 그 리스트 순회하면서 새로운 리스트에 나온 숫자들만 다시 집어넣어
 * 그럼 각 숫자별 하나씩 들어가 있겠지?
 * 그걸
 */
public class Boj_2108 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int sum = 0;
        int num;
        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        int[] numCnt1 = new int[8001];
        int[][] numCnt = new int[8001][2];
        int[] nums = new int[N];

        for (int i = 0; i < N; i++) {
            num = Integer.parseInt(br.readLine());
            // sum에 더하기
            sum += num;
            // nums에 저장
            nums[i] = num;
            // 최댓값 지정
            maxNum = Math.max(maxNum, num);
            // 최솟값 지정
            minNum = Math.min(minNum, num);
            // 개수 count
            if (numCnt[num + 4000][0] == 0) {
                numCnt[num + 4000][1] = num;
            }
            numCnt[num + 4000][0]++;
        }

        Arrays.sort(nums);

        Arrays.sort(numCnt, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] == o2[0]) {
                    return o1[1] - o2[1];
                } else {
                    return o2[0] - o1[0];
                }
            }
        });


        // 산술평균
        if (Math.round((float) sum / N) == 0) {
            System.out.println(Math.abs(Math.round((float) sum / N)));
        } else {
            System.out.println(Math.round((float) sum / N));
        }
        // 중앙값
        System.out.println(nums[N / 2]);
        // 최빈값
        if (numCnt[0][0] == numCnt[1][0]) {
            System.out.println(numCnt[1][1]);
        } else {
            System.out.println(numCnt[0][1]);
        }
        // 범위
        System.out.println(maxNum - minNum);
    }
}
