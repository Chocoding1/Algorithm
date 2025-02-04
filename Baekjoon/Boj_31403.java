import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_31403 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int A = Integer.parseInt(br.readLine());
        int B = Integer.parseInt(br.readLine());
        int C = Integer.parseInt(br.readLine());

        System.out.println(A + B - C);

        StringBuilder sb = new StringBuilder();
        int AB = Integer.parseInt(sb.append(A).append(B).toString());

        System.out.println(AB - C);
    }
}
