import java.util.HashMap;

// 프로그래머스 Lv.2
public class 롤케이크_자르기 {

    public int solution(int[] topping) {
        int answer = 0;
        HashMap<Integer, Integer> toppings1 = new HashMap<>();
        HashMap<Integer, Integer> toppings2 = new HashMap<>();
        for (int i = 0; i < topping.length; i++) {
            toppings2.put(topping[i], toppings2.getOrDefault(topping[i], 0) + 1);
        }

        for (int i = 0; i < topping.length - 1; i++) {
            toppings1.put(topping[i], toppings1.getOrDefault(topping[i], 0) + 1);
            toppings2.put(topping[i], toppings2.get(topping[i]) - 1);
            if (toppings2.get(topping[i]) == 0) {
                toppings2.remove(topping[i]);
            }
            if (toppings1.size() == toppings2.size()) {
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        롤케이크_자르기 solution = new 롤케이크_자르기();

        System.out.println(solution.solution(new int[]{1, 2, 1, 3, 1, 4, 1, 2})); // 2
        System.out.println(solution.solution(new int[]{1, 2, 3, 1, 4})); // 0
    }
}

