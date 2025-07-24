import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Boj_30805 {

    private static int N, M;
    private static List<Integer> A, B;
    private static final List<Integer> res = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        A = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());
        M = Integer.parseInt(br.readLine());
        B = Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList());

        solve(A, B);

        StringBuilder sb = new StringBuilder();
        sb.append(res.size()).append("\n");
        if (!res.isEmpty()) {
            for (Integer num : res) {
                sb.append(num).append(" ");
            }
        }
        System.out.println(sb);
    }

    private static void solve(List<Integer> a, List<Integer> b) {
        if (a.isEmpty() || b.isEmpty()) {
            return;
        }

        int aMax = Collections.max(a);
        int aMaxIdx = a.indexOf(aMax);
        int bMax = Collections.max(b);
        int bMaxIdx = b.indexOf(bMax);

        if (aMax > bMax) {
            a.remove(aMaxIdx);
            solve(a, b);
        } else if (aMax < bMax) {
            b.remove(bMaxIdx);
            solve(a, b);
        } else {
            res.add(aMax);
            solve(a.subList(aMaxIdx + 1, a.size()), b.subList(bMaxIdx + 1, b.size()));
        }
    }

}
