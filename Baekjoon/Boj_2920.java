import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Boj_2920 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[] intArray = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        boolean flag = true;

        for (int i = 1; i < intArray.length; i++) {
            if (Math.abs(intArray[i - 1] - intArray[i]) != 1) {
                flag = false;
                break;
            }
        }

        if (flag) {
            if (intArray[0] == 1) {
                System.out.println("ascending");
            } else {
                System.out.println("descending");
            }
        } else {
            System.out.println("mixed");
        }
    }
}
