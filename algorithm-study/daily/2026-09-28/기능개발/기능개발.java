import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 프로그래머스 Lv.2
public class 기능개발 {

    public int[] solution(int[] progresses, int[] speeds) {
        List<Integer> answer = new ArrayList<>();
        int index = 0;
        while (index < progresses.length) {
            int lastedTasks = 100 - progresses[index];
            int lastedDays = (int) Math.ceil((double) lastedTasks / speeds[index]);
            for (int i = 0; i < progresses.length; i++) {
                progresses[i] += speeds[i] * lastedDays;
            }

            int count = 0;
            while (index < progresses.length) {
                if (progresses[index] < 100) {
                    break;
                }
                count++;
                index++;
            }
            answer.add(count);
        }
        return answer.stream().
                mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        기능개발 solution = new 기능개발();

        System.out.println(Arrays.toString(solution.solution(
                new int[]{93, 30, 55},
                new int[]{1, 30, 5}
        )));
        System.out.println(Arrays.toString(solution.solution(
                new int[]{95, 90, 99, 99, 80, 99},
                new int[]{1, 1, 1, 1, 1, 1}
        )));
    }
}
