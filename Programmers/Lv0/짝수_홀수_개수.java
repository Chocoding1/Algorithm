import java.util.Arrays;

public class 짝수_홀수_개수 {
    public int[] solution(int[] num_list) {
        int[] answer = new int[2];
        for (int num : num_list) {
            if (num % 2 == 0) {
                answer[0]++;
            } else {
                answer[1]++;
            }

            // 이렇게도 가능
//            answer[num % 2]++;
        }
        return answer;
    }
}
