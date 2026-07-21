package Lv1;

import java.util.Arrays;

public class 부족한_금액_계산하기 {

    static long solution(int price, int money, int count) {
        long totalPrice = 0;
        for (int i = 1; i <= count; i++) {
            totalPrice += price * i;
        }
        if (totalPrice <= money) {
            return 0;
        }

        return totalPrice - money;
    }

    public static void main(String[] args) {
        System.out.println(solution(3, 20, 4));
    }
}
