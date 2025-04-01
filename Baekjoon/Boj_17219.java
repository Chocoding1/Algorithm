import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_17219 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashMap<String, String> memo = new HashMap<>();

        String site;
        String pwd;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            site = st.nextToken();
            pwd = st.nextToken();

            memo.put(site, pwd);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            sb.append(memo.get(br.readLine())).append("\n");
        }

        System.out.println(sb);
    }
}
