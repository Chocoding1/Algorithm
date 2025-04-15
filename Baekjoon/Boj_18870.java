import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_18870 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] sortedArray = Arrays.copyOf(array, N);
        Arrays.sort(sortedArray);

        HashMap<Integer, Integer> map = new HashMap<>();

        StringBuilder sb = new StringBuilder();

        int idx = 0;
        for (int x : sortedArray) {
            if (!map.containsKey(x)) {
                map.put(x, idx++);
            }
        }

        for (int x : array) {
            sb.append(map.get(x)).append(" ");
        }

        System.out.println(sb);
    }
}
