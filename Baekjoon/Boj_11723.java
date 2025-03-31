import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Boj_11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 1; i <= 20; i++) {
            map.put(i, 0);
        }

        String cmd;
        int num;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            if (cmd.equals("add")) {
                num = Integer.parseInt(st.nextToken());
                if (map.get(num) == 0) {
                    map.replace(num, 1);
                }
            } else if (cmd.equals("remove")) {
                num = Integer.parseInt(st.nextToken());
                if (map.get(num) == 1) {
                    map.replace(num, 0);
                }
            } else if (cmd.equals("check")) {
                num = Integer.parseInt(st.nextToken());
                System.out.println(map.get(num));
            } else if (cmd.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
                if (map.get(num) == 1) {
                    map.replace(num, 0);
                } else {
                    map.replace(num, 1);
                }
            } else if (cmd.equals("all")) {
                for (int j = 1; j <= 20; j++) {
                    map.replace(j, 1);
                }
            } else {
                for (int j = 1; j <= 20; j++) {
                    map.replace(j, 0);
                }
            }
        }
    }
}
