import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;

public class Boj_1744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> plus = new ArrayList<>();
        ArrayList<Integer> minus = new ArrayList<>();

        int result = 0;
        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(br.readLine());

            if (num > 1) {
                plus.add(num);
            } else if (num < 1) {
                minus.add(num);
            } else {
                result += 1;
            }
        }
        plus.sort(Comparator.reverseOrder());
        minus.sort(Comparator.naturalOrder());

        for (int i = 0; i < plus.size(); i += 2) {

        }

        while (plus.size() > 1) {
            int num1 = plus.remove(0);
            int num2 = plus.remove(0);

            result += num1 * num2;
        }
        if (plus.size() == 1) {
            result += plus.remove(0);
        }

        while (minus.size() > 1) {
            int num1 = minus.remove(0);
            int num2 = minus.remove(0);

            result += num1 * num2;
        }
        if (minus.size() == 1) {
            result += minus.remove(0);
        }

        System.out.println(result);
    }
}
