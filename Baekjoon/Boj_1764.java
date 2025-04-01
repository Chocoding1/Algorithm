import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.StringTokenizer;


/**
 * 자바에서 Set의 contains 함수는 시간복잡도가 O(1)이기 때문에 듣도 못한 놈을 찾기엔 최적의 방법이다.
 * why? 자바의 HashSet은 HashMap을 기반으로 만드는데, 둘 다 key, value 형태로 저장을 하기 떄문에
 * 단순히 key값을 조회하는 것은 O(1)의 시간복잡도가 필요하다.
 */
public class Boj_1764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        HashSet<String> notListen = new HashSet<>();
        int cnt = 0;
        ArrayList<String> notListenAndWatch = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            notListen.add(br.readLine());
        }

        String target;
        for (int i = 0; i < M; i++) {
            target = br.readLine();
            if (notListen.contains(target)) {
                cnt++;
                notListenAndWatch.add(target);
            }
        }

        Collections.sort(notListenAndWatch);

        StringBuilder sb = new StringBuilder();
        sb.append(cnt).append("\n");
        for (String name : notListenAndWatch) {
            sb.append(name).append("\n");
        }
        System.out.println(sb);
    }
}
