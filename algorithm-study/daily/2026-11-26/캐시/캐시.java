import java.util.ArrayDeque;
import java.util.Queue;

// 프로그래머스 Lv.2
public class 캐시 {

    public int solution(int cacheSize, String[] cities) {
        Queue<String> queue = new ArrayDeque<>();
        int answer = 0;
        for (String city : cities) {
            city = city.toLowerCase();
            if (!queue.isEmpty()) {
                if (queue.remove(city)) {
                    answer += 1;
                    queue.offer(city);
                    continue;
                }
            }
            answer += 5;
            queue.offer(city);

            if (queue.size() > cacheSize) {
                queue.poll();
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        캐시 solution = new 캐시();
        System.out.println(solution.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); // 50
        System.out.println(solution.solution(3, new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"})); // 21
        System.out.println(solution.solution(2, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); // 60
        System.out.println(solution.solution(5, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"})); // 52
        System.out.println(solution.solution(2, new String[]{"Jeju", "Pangyo", "NewYork", "newyork"})); // 16
        System.out.println(solution.solution(0, new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"})); // 25
    }
}
