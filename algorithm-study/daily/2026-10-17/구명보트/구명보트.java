import java.util.Arrays;

// 프로그래머스 Lv.2
public class 구명보트 {

    public int solution(int[] people, int limit) {
        int answer = 0;
        Arrays.sort(people);
        int left = 0, right = people.length - 1;

        while (left < right) {
            if (people[right--] + people[left] <= limit) {
                left++;
            }
            answer++;
        }
        if (right == left) {
            answer++;
        }
        return answer;
    }

    public static void main(String[] args) {
        구명보트 solution = new 구명보트();

        System.out.println(solution.solution(new int[]{70, 50, 80, 50}, 100));
        System.out.println(solution.solution(new int[]{70, 80, 50}, 100));
    }
}
