import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1436 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int titleNum = 666;
        int n = 1;

        while (n < N) {
            titleNum++;
            if (String.valueOf(titleNum).contains("666")) {
                n++;
            }
        }

        System.out.println(titleNum);
    }
}
