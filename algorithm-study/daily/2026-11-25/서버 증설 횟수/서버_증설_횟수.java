import java.util.PriorityQueue;

// 프로그래머스 Lv.2
public class 서버_증설_횟수 {

    public int solution(int[] players, int m, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        int answer = 0;
        int serverCount = 0;

        for (int i = 0; i < 24; i++) {
            if (!pq.isEmpty()) {
                int[] nextExpiredServer = pq.peek();

                if (nextExpiredServer[0] == i) {
                    pq.poll();
                    serverCount -= nextExpiredServer[1];
                }
            }

            if (players[i] == 0) {
                continue;
            }

            int requiredServerCount = Math.max(players[i] / m - serverCount, 0);
            pq.offer(new int[]{i + k, requiredServerCount});
            answer += requiredServerCount;
            serverCount += requiredServerCount;
        }

        return answer;
    }

    public static void main(String[] args) {
        서버_증설_횟수 solution = new 서버_증설_횟수();

        System.out.println(solution.solution(
                new int[]{0, 2, 3, 3, 1, 2, 0, 0, 0, 0, 4, 2, 0, 6, 0, 4, 2, 13, 3, 5, 10, 0, 1, 5},
                3,
                5
        )); // 7
    }
}
