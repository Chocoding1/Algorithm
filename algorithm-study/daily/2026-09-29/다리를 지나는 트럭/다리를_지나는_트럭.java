import java.util.ArrayDeque;

// 프로그래머스 Lv.2
public class 다리를_지나는_트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        ArrayDeque<int[]> bridge = new ArrayDeque<>();
        int time = 0;
        int remainingWeight = weight;

        for (int truckWeight : truck_weights) {
            time++;

            while (!bridge.isEmpty()
                    && (bridge.peek()[1] <= time || truckWeight > remainingWeight)) {
                time = Math.max(time, bridge.peek()[1]);
                remainingWeight += bridge.poll()[0];
            }

            bridge.offer(new int[]{truckWeight, time + bridge_length});
            remainingWeight -= truckWeight;
        }

        return bridge.getLast()[1];
    }

    public static void main(String[] args) {
        다리를_지나는_트럭 solution = new 다리를_지나는_트럭();

        System.out.println(solution.solution(2, 10, new int[]{7, 4, 5, 6}));
        System.out.println(solution.solution(100, 100, new int[]{10}));
        System.out.println(solution.solution(
                100,
                100,
                new int[]{10, 10, 10, 10, 10, 10, 10, 10, 10, 10}
        ));
    }
}
