import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1541 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] subExp = br.readLine().split("-");

        int result = 0;
        for (int i = 0; i < subExp.length; i++) {
            if (i == 0) {
                result += cal(subExp[i]);
            } else {
                result -= cal(subExp[i]);
            }
        }

        System.out.println(result);
    }

    private static int cal(String s) {
        String[] li = s.split("\\+"); // +는 정규표현식에 사용되는 문자이기 때문에 그대로 사용하면 안 된다.(\\+ or [+] 사용)
        int subSum = 0;
        for (String num : li) {
            subSum += Integer.parseInt(num);
        }

        return subSum;
    }
}
