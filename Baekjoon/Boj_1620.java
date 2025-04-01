import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_1620 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] pocketList = new String[N];
        HashMap<String, Integer> pocketMap = new HashMap<>();
        String name;

        for (int i = 0; i < N; i++) {
            name = br.readLine();
            pocketList[i] = name;
            pocketMap.put(name, i + 1);
        }

        StringBuilder sb = new StringBuilder();
        String ques;
        for (int i = 0; i < M; i++) {
            ques = br.readLine();
            if (Character.isDigit(ques.charAt(0))) {
                sb.append(pocketList[Integer.parseInt(ques) - 1]).append("\n");
            } else {
                sb.append(pocketMap.get(ques)).append("\n");
            }
        }
        System.out.println(sb);
    }
}
