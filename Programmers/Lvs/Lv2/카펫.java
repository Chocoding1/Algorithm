package Lv2;

import java.util.Arrays;

public class 카펫 {

    static int[] solution(int brown, int yellow) {
        int row = 0, col = 0;
        int brownCnt = 0, yellowCnt = 0;

        for (row = 3; row <= brown + 2; row++) {
            for (col = 3; col <= row; col++) {
                brownCnt = row * 2 + (col - 2) * 2;
                yellowCnt = (row - 2) * (col - 2);

                if (brownCnt > brown || yellowCnt > yellow) {
                    break;
                }

                if (brownCnt == brown && yellowCnt == yellow) {
                    break;
                }
            }
            if (brownCnt == brown && yellowCnt == yellow) {
                break;
            }
        }
        return new int[]{row, col};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(10, 2)));
        System.out.println(Arrays.toString(solution(8, 1)));
        System.out.println(Arrays.toString(solution(24, 24)));
    }
}
