import java.util.ArrayDeque;

// 프로그래머스 Lv.2
public class 다리를_지나는_트럭_재도전 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        int remainWeight = weight;

        int index = 0;
        while (index < truck_weights.length) {
            answer++;
            while (!queue.isEmpty() && truck_weights[index] > remainWeight) {
                int[] currentTruck = queue.poll();
                remainWeight += currentTruck[0];
                answer = Math.max(answer, currentTruck[1]);
            }
            queue.offer(new int[]{truck_weights[index], answer + bridge_length});
            remainWeight -= truck_weights[index];
            index++;
        }
        return Math.max(answer, queue.peekLast()[1]);
    }

    public static void main(String[] args) {
        다리를_지나는_트럭_재도전 solution = new 다리를_지나는_트럭_재도전();

        System.out.println(solution.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution.solution(100, 100, new int[]{10}));
        System.out.println(solution.solution(
                100,
                100,
                new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
        ));
    }
}
