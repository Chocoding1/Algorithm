import java.util.Arrays;

// 프로그래머스 Lv.2
public class 주차_요금_계산 {

    public int[] solution(int[] fees, String[] records) {
        return new int[]{};
    }

    public static void main(String[] args) {
        주차_요금_계산 solution = new 주차_요금_계산();

        System.out.println(Arrays.toString(solution.solution(
                new int[]{180, 5000, 10, 600},
                new String[]{
                        "05:34 5961 IN",
                        "06:00 0000 IN",
                        "06:34 0000 OUT",
                        "07:59 5961 OUT",
                        "07:59 0148 IN",
                        "18:59 0000 IN",
                        "19:09 0148 OUT",
                        "22:59 5961 IN",
                        "23:00 5961 OUT"
                }
        ))); // [14600, 34400, 5000]
    }
}
