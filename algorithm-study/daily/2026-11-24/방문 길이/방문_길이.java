import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// 프로그래머스 Lv.2
public class 방문_길이 {

    public int solution(String dirs) {
        HashMap<Character, int[]> directions = new HashMap<>();
        directions.put('U', new int[]{1, 0});
        directions.put('D', new int[]{-1, 0});
        directions.put('L', new int[]{0, -1});
        directions.put('R', new int[]{0, 1});

        int startI = 0;
        int startJ = 0;
        int answer = 0;
        List<String> history = new ArrayList<>();
        for (char c : dirs.toCharArray()) {
            int[] direction = directions.get(c);
            if (startI + direction[0] < -5 || startI + direction[0] > 5 || startJ + direction[1] < -5 || startJ + direction[1] > 5) {
                continue;
            }
            String curRoute = "" + startI + startJ + (startI + direction[0]) + (startJ + direction[1]);
            String reverseRoute = "" + (startI + direction[0]) + (startJ + direction[1]) + startI + startJ;
            if (!history.contains(curRoute) && !history.contains(reverseRoute)) {
                history.add(curRoute);
                history.add(reverseRoute);
                answer++;
            }
            startI += direction[0];
            startJ += direction[1];
        }

        return answer;
    }

    public static void main(String[] args) {
        방문_길이 solution = new 방문_길이();

        System.out.println(solution.solution("ULURRDLLU")); // 7
        System.out.println(solution.solution("LULLLLLLU")); // 7
        System.out.println(solution.solution("UD")); // 1
    }
}
