import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.List;

public class Boj_2231 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        int N = Integer.parseInt(input);
        /**
         * start : 분해합을 검사할 시작 지점
         * 1234가 N으로 주어졌을 때, 1부터 검사해야 할까?
         * 각 자리수의 최댓값은 9이다. 따라서 1234에서 9 + 9 + 9 + 9(네자리수이니까)를 뺀 값에서부터 검사를 하면 된다.
         * 1234에서 36(4*9)을 뺀 값보다 작은 값은 어떤 수를 써도 1234가 될 수 없기 때문이다.
         */
        int start = N - input.length() * 9;
        int sum;
        int result = 0;
        int curNum;

        for (int i = start; i < N; i++) {
            curNum = i;
            sum = i;
            int subSum = Arrays.stream(String.valueOf(i).split("")).mapToInt(Integer::parseInt).sum();
            sum += subSum;
/*
            while (curNum != 0) {
                sum += curNum % 10;
                curNum /= 10;
            }
*/
            if (sum == N) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }
}
