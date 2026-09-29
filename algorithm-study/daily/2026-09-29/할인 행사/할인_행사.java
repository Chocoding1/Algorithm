import java.util.HashMap;
import java.util.Map;

// 프로그래머스 Lv.2
public class 할인_행사 {

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        Map<String, Integer> wantMap = new HashMap<>();
        Map<String, Integer> discountMap = new HashMap<>();

        for (int i = 0; i < want.length; i++) {
            wantMap.put(want[i], number[i]);
        }
        for (int i = 0; i < 10; i++) {
            discountMap.put(discount[i], discountMap.getOrDefault(discount[i], 0) + 1);
        }

        int left = 0;
        int right = 9;
        while (right < discount.length) {
            if (wantMap.equals(discountMap)) {
                answer++;
            }
            discountMap.put(discount[left], discountMap.get(discount[left]) - 1);
            if (discountMap.get(discount[left]) == 0) {
                discountMap.remove(discount[left]);
            }
            left++;
            right++;
            if (right >= discount.length) {
                break;
            }
            discountMap.put(discount[right], discountMap.getOrDefault(discount[right], 0) + 1);
        }

        return answer;
    }

    public static void main(String[] args) {
        할인_행사 solution = new 할인_행사();

        System.out.println(solution.solution(
                new String[]{"banana", "apple", "rice", "pork", "pot"},
                new int[]{3, 2, 2, 2, 1},
                new String[]{
                        "chicken", "apple", "apple", "banana", "rice", "apple", "pork",
                        "banana", "pork", "rice", "pot", "banana", "apple", "banana"
                }
        ));
        System.out.println(solution.solution(
                new String[]{"apple"},
                new int[]{10},
                new String[]{
                        "banana", "banana", "banana", "banana", "banana",
                        "banana", "banana", "banana", "banana", "banana"
                }
        ));
    }
}
