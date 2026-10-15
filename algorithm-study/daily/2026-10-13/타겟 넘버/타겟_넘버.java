// 프로그래머스 Lv.2
public class 타겟_넘버 {

    private final String[] operators = {"+", "-"};
    private int n, answer;

    public int solution(int[] numbers, int target) {
        n = numbers.length;
        answer = 0;

        dfs(numbers, 0, 0, target);
        return answer;
    }

    private void dfs(int[] numbers, int idx, int sum, int target) {
        if (idx == n) {
            if (sum == target) {
                answer++;
            }
            return;
        }
        int number = numbers[idx];
        for (int i = 0; i < operators.length; i++) {
            if (operators[i].equals("+")) {
                dfs(numbers, idx + 1, sum + number, target);
            } else {
                dfs(numbers, idx + 1, sum - number, target);
            }
        }
    }

    public static void main(String[] args) {
        타겟_넘버 solution = new 타겟_넘버();

        System.out.println(solution.solution(new int[]{1, 1, 1, 1, 1}, 3));
        System.out.println(solution.solution(new int[]{4, 1, 2, 1}, 4));
    }
}
