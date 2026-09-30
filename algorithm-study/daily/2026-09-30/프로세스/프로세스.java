import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;

// 프로그래머스 Lv.2
public class 프로세스 {

    public int solution(int[] priorities, int location) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int priority : priorities) {
            priorityQueue.add(priority);
        }

        ArrayDeque<int[]> queue = new ArrayDeque<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new int[]{priorities[i], i});
        }

        int answer = 0;
        while (true) {
            int[] priority = queue.pollFirst();
            if (priority[0] < priorityQueue.peek()) {
                queue.offer(priority);
                continue;
            }

            answer++;
            priorityQueue.poll();
            if (priority[1] == location) {
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        프로세스 solution = new 프로세스();

        System.out.println(solution.solution(new int[]{2, 1, 3, 2}, 2));
        System.out.println(solution.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}
