import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_7662 {

    private static TreeMap<Integer, Integer> map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int t = 0; t < T; t++) {
            int k = Integer.parseInt(br.readLine());

            map = new TreeMap<>();

            for (int i = 0; i < k; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                String cmd = st.nextToken();
                int num = Integer.parseInt(st.nextToken());

                if (cmd.equals("I")) {
                    map.put(num, map.getOrDefault(num, 0) + 1);
                } else {
                    if (map.isEmpty()) {
                        continue;
                    }
                    int pollNum = num == 1 ? map.lastKey() : map.firstKey();
                    if (map.put(pollNum, map.get(pollNum) - 1) == 1) { // treeMap.pu()은 이전 value를 반환
                        map.remove(pollNum);
                    }
                }
            }

            StringBuilder sb = new StringBuilder();
            if (map.isEmpty()) {
                sb.append("EMPTY");
            } else {
                sb.append(map.lastKey()).append(" ").append(map.firstKey());
            }
            System.out.println(sb);
        }
    }
}
