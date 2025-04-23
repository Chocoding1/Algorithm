import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Arrays;

public class Boj_5430 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            String p = br.readLine();
            int n = Integer.parseInt(br.readLine());
            int[] x;

            if (n == 0) {
                br.readLine();
                x = new int[0];
            } else {
                x = Arrays.stream(br.readLine().replace("[", "").replace("]", "").split(",")).mapToInt(Integer::parseInt).toArray();
            }

            ArrayDeque<Integer> deque = new ArrayDeque<>();
            for (int num : x) {
                deque.offer(num);
            }

            int dCnt = 0;
            for (String s : p.split("")) {
                if (s.equals("D")) {
                    dCnt++;
                }
            }

            if (dCnt > deque.size()) {
                System.out.println("error");
                continue;
            }

            boolean isReverse = false;
            for (int i = 0; i < p.length(); i++) {
                if (p.charAt(i) == 'R') {
                    isReverse = !isReverse;
                } else { // 'D'
                    if (isReverse) {
                        deque.pollLast();
                    } else {
                        deque.poll();
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            sb.append("[");
            if (deque.isEmpty()) {
                sb.append("]");
            } else {
                while (!deque.isEmpty()) {
                    if (isReverse) {
                        sb.append(deque.pollLast()).append(",");
                    } else {
                        sb.append(deque.poll()).append(",");
                    }
                }
                sb.deleteCharAt(sb.length() - 1).append("]");
            }

            System.out.println(sb);
        }
    }
}
