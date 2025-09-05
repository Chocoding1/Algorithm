import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Boj_2143 {
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        int[] A = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        int[] B = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            B[i] = Integer.parseInt(st.nextToken());
        }

        Map<Long, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            long subTot = 0;
            for (int j = i; j < n; j++) {
                subTot += A[j];
                map.put(subTot, map.getOrDefault(subTot, 0) + 1);
            }
        }

        long result = 0;
        for (int i = 0; i < m; i++) {
            long subTot = 0;
            for (int j = i; j < m; j++) {
                subTot += B[j];
                long need = T - subTot;
                if (map.containsKey(need)) {
                    result += map.get(need);
                }
            }
        }
        System.out.println(result);
    }
}
