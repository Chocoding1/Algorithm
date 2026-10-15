import java.util.HashSet;
import java.util.Set;

// 프로그래머스 Lv.2
public class 소수_찾기 {

    private boolean[] visited;
    private Set<String> decimals;

    public int solution(String numbers) {
        decimals = new HashSet<>();
        visited = new boolean[numbers.length()];

        for (int i = 1; i <= numbers.length(); i++) {
            dfs(numbers, i, "");
        }

        return decimals.size();
    }

    private void dfs(String numbers, int targetLength, String number) {
        number = normalize(number);
        if (number.length() == targetLength) {
            if (isDecimal(number)) {
                decimals.add(number);
            }
            return;
        }

        for (int i = 0; i < numbers.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(numbers, targetLength, number + numbers.charAt(i));
                visited[i] = false;
            }
        }
    }

    private String normalize(String number) {
        if (!number.isEmpty() && number.charAt(0) == '0') {
            return number.substring(1);
        }
        return number;
    }

    private boolean isDecimal(String number) {
        int realNumber = Integer.parseInt(number);
        if (realNumber == 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(realNumber); i++) {
            if (realNumber % i == 0) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        소수_찾기 solution = new 소수_찾기();

        System.out.println(solution.solution("17"));
        System.out.println(solution.solution("011"));
    }
}
