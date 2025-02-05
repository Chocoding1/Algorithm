import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Boj_4153 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        while (true) {
            int[] edges = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).sorted().toArray();
            if (edges[0] == 0) {
                break;
            }

            if ((edges[0] * edges[0] + edges[1] * edges[1]) == (edges[2] * edges[2])) {
                System.out.println("right");
            } else {
                System.out.println("wrong");
            }
        }
    }
}
