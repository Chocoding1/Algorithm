import java.util.*;

// 프로그래머스 Lv.2
public class 두_큐_합_같게_만들기 {
    public int solution(int[] queue1, int[] queue2) {
        long sum1 = Arrays.stream(queue1).sum();
        long sum2 = Arrays.stream(queue2).sum();
        if ((sum1 + sum2) % 2 != 0) {
            return -1;
        }
        long target = (sum1 + sum2) / 2;

        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();
        initializeQ(queue1, q1);
        initializeQ(queue2, q2);

        int count = 0;
        while (count < 4 * queue1.length) {
            if (sum1 == target) {
                return count;
            }
            count++;
            if (sum1 < target) {
                Integer q2First = q2.poll();
                q1.offer(q2First);
                sum1 += q2First;
                continue;
            }
            Integer q1First = q1.poll();
            q2.offer(q1First);
            sum1 -= q1First;
        }
        
        return -1;
    }

    private static void initializeQ(int[] queue1, Queue<Integer> q1) {
        for (int value : queue1) {
            q1.offer(value);
        }
    }

    public static void main(String[] args) {
        두_큐_합_같게_만들기 solution = new 두_큐_합_같게_만들기();

        System.out.println(solution.solution(
                new int[]{3, 2, 7, 2},
                new int[]{4, 6, 5, 1}
        ));
        System.out.println(solution.solution(
                new int[]{1, 2, 1, 2},
                new int[]{1, 10, 1, 2}
        ));
        System.out.println(solution.solution(
                new int[]{1, 1},
                new int[]{1, 5}
        ));
    }
}
