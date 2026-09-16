import java.util.HashMap;

// 프로그래머스 Lv.2
public class 의상 {

    public int solution(String[][] clothes) {
        HashMap<String, Integer> mappedClothes = new HashMap<>();
        for (String[] clothe : clothes) {
            mappedClothes.put(clothe[1], mappedClothes.getOrDefault(clothe[1], 0) + 1);
        }

        int answer = 1;
        for (Integer clotheCount : mappedClothes.values()) {
            answer *= (clotheCount + 1);
        }
        return answer - 1;
    }

    public static void main(String[] args) {
        의상 solution = new 의상();

        System.out.println(solution.solution(new String[][]{
                {"yellow_hat", "headgear"},
                {"blue_sunglasses", "eyewear"},
                {"green_turban", "headgear"}
        }));
        System.out.println(solution.solution(new String[][]{
                {"crow_mask", "face"},
                {"blue_sunglasses", "face"},
                {"smoky_makeup", "face"}
        }));
    }
}
