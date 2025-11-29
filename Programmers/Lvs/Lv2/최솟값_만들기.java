package Lv2;

import java.util.Arrays;

public class 최솟값_만들기 {

    public int solution(int []A, int []B)
    {
        int answer = 0;

        Arrays.sort(A);
        Arrays.sort(B);

        int length = A.length;

        for (int i = 0; i < length; i++) {
            answer += A[i] * B[length - 1 - i];
        }

        return answer;
    }
}
