import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_3052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[] remain = new boolean[42];
        int cnt = 0;

        for (int i = 0; i < 10; i++) {
            int idx = Integer.parseInt(br.readLine()) % 42;
            if (!remain[idx]) {
                cnt++;
                remain[idx] = true;
            }
        }
        System.out.println(cnt);

    }
}
