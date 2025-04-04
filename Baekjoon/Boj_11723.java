import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

public class Boj_11723 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int M = Integer.parseInt(br.readLine());
//        HashSet<Integer> set = new HashSet<>();
        int set = 0;
        StringBuilder sb = new StringBuilder();

        String cmd;
        int num;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            cmd = st.nextToken();

            if (cmd.equals("add")) {
                num = Integer.parseInt(st.nextToken());
//                set.add(num);
                set |= (1 << num);
            } else if (cmd.equals("remove")) {
                num = Integer.parseInt(st.nextToken());
//                set.remove(num);
                set &= ~(1 << num);
            } else if (cmd.equals("check")) {
                num = Integer.parseInt(st.nextToken());
//                if (set.contains(num)) {
//                    sb.append(1);
//                } else {
//                    sb.append(0);
//                }
                sb.append((set & (1 << num)) > 0 ? 1 : 0);
                sb.append("\n");
            } else if (cmd.equals("toggle")) {
                num = Integer.parseInt(st.nextToken());
//                if (set.contains(num)) {
//                    set.remove(num);
//                } else {
//                    set.add(num);
//                }
                set ^= (1 << num);
            } else if (cmd.equals("all")) {
//                for (int j = 1; j <= 20; j++) {
//                    set.add(j);
//                }
                set = (1 << 21) - 1;
            } else {
//                set.clear();
                set = 0;
            }
        }

        System.out.println(sb);
    }
}
