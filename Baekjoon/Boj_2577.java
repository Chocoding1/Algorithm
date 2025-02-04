import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Boj_2577 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        String production = String.valueOf(A * B * C);
        String[] num = production.split("");

        int[] result = new int[10];

        for (String s : num) {
            result[Integer.parseInt(s)]++;
        }

        for (int r : result) {
            System.out.println(r);
        }
    }
}
