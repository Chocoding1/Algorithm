import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class boj_9935_1 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();
        String bomb = br.readLine();

        for (int i = 0; i < input.length(); i++) {
            String subInput = input.substring(i, i + bomb.length());
            if (subInput.equals(bomb)) {

            }
        }
    }
}
