import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

// 프로그래머스 Lv.1
public class 모의고사 {
    public int[] solution(int[] answers) {
        int[][] selections = {
                {1, 2, 3, 4, 5},
                {2, 1, 2, 3, 2, 4, 2, 5},
                {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
        };
        int[] counts = new int[selections.length];

        for (int i = 0; i < answers.length; i++) {
            for (int j = 0; j < selections.length; j++) {
                int index = i % selections[j].length;
                if (answers[i] == selections[j][index]) {
                    counts[j]++;
                }
            }
        }
        int max = Arrays.stream(counts).max().getAsInt();
        ArrayList<Integer> answer = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            if (counts[i] == max) {
                answer.add(i + 1);
            }
        }

        return answer.stream().
                mapToInt(Integer::intValue)
                .toArray();
    }

    public static void main(String[] args) {
        모의고사 solution = new 모의고사();

        System.out.println(Arrays.toString(
                solution.solution(new int[]{1, 2, 3, 4, 5})
        ));
        System.out.println(Arrays.toString(
                solution.solution(new int[]{1, 3, 2, 4, 2})
        ));
    }
}
