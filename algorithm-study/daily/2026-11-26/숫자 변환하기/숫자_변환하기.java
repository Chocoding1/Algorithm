// 프로그래머스 Lv.2
import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

public class 숫자_변환하기 {

    public int solution(int x, int y, int n) {
        Queue<int[]> queue = new ArrayDeque<>();
        Set<Integer> visited = new HashSet<>();
        queue.offer(new int[]{y, 0});
        visited.add(y);

        while (!queue.isEmpty()) {
            int[] state = queue.poll();
            int current = state[0];
            int steps = state[1];

            if (current == x) {
                return steps;
            }

            int minus = current - n;
            if (minus >= x && visited.add(minus)) {
                queue.offer(new int[]{minus, steps + 1});
            }

            int half = current / 2;
            if (current % 2 == 0 && half >= x && visited.add(half)) {
                queue.offer(new int[]{half, steps + 1});
            }

            int third = current / 3;
            if (current % 3 == 0 && third >= x && visited.add(third)) {
                queue.offer(new int[]{third, steps + 1});
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        숫자_변환하기 solution = new 숫자_변환하기();
        System.out.println(solution.solution(10, 40, 5)); // 2
        System.out.println(solution.solution(10, 40, 30)); // 1
        System.out.println(solution.solution(2, 5, 4)); // -1
    }
}
