import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Boj_1202 {

    private static class Jewel implements Comparable<Jewel> {
        private int weight;
        private int value;

        public Jewel(int weight, int value) {
            this.weight = weight;
            this.value = value;
        }

        @Override
        public int compareTo(Jewel o) {
            if (weight != o.weight) {
                return weight - o.weight;
            } else {
                return o.value - value;
            }
        }
    }

    private static Jewel[] jewels;
    private static int[] bags;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        jewels = new Jewel[N];
        bags = new int[K];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewels[i] = new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(jewels);
        Arrays.sort(bags);

        long result = 0;
        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
        int j = 0;
        for (int i = 0; i < K; i++) {
            while (j < N) {
                if (bags[i] < jewels[j].weight) {
                    break;
                }
                queue.offer(jewels[j++].value);
            }
            if (!queue.isEmpty()) {
                result += queue.poll();
            }
        }

        System.out.println(result);
    }
}
