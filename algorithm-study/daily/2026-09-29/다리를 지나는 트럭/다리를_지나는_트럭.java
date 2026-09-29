// 프로그래머스 Lv.2
public class 다리를_지나는_트럭 {

    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
        return answer;
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
