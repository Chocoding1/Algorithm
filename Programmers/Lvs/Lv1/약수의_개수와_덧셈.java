package Lv1;

public class 약수의_개수와_덧셈 {

    static int solution(int left, int right) {
        int result = 0;
        for (int target = left; target <= right; target++) {
            if (Math.sqrt(target) % 1 == 0.0) {
                result -= target;
            } else {
                result += target;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(solution(13, 17));
        System.out.println(solution(24, 27));
    }
}
