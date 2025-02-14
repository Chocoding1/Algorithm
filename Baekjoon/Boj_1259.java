import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_1259 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String result;

        while (true) {
            char[] charArray = br.readLine().toCharArray();
            if (charArray[0] == '0') {
                break;
            }
            result = "yes";
            int length = charArray.length;

            for (int i = 0; i < length / 2; i++) {
                System.out.println(charArray[i]);
                System.out.println(charArray[length - 1 - i]);
                if (charArray[i] != charArray[length - 1 - i]) {
                    result = "no";
                    break;
                }
            }

            System.out.println(result);
        }
    }
}
