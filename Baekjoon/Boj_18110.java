import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;

public class Boj_18110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        ArrayList<Integer> difficulties = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            difficulties.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(difficulties);

        // (float)으로 해야 n * 15 / 100의 연산이 소숫점까지 계산이 된다.
        // (안 하면 애초에 계산 결과가 소숫점을 제외하고 나온다. 정수형 변수와 정수로만 계산했기 때문에 결과도 정수형으로 나오는 것)
        int cutCount = Math.round((float) n * 15 / 100);

        int sum = 0;
        for (int i = cutCount; i < difficulties.size() - cutCount; i++) {
            sum += difficulties.get(i);
        }

        int resultSize = difficulties.size() - cutCount * 2;

        System.out.println(Math.round((float) sum / resultSize));
    }
}
