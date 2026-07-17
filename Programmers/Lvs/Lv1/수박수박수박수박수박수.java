package Lv1;

public class 수박수박수박수박수박수 {

    static String solution(int n) {
        int repeat = n / 2;

        if (n % 2 == 0) {
            return "수박".repeat(repeat);
        }
        return "수박".repeat(repeat) + "수";
    }

    public static void main(String[] args) {
        System.out.println(solution(3));
        System.out.println(solution(4));
    }
}
