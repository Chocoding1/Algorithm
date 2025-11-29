package Lv2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 최댓값과_최솟값 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int maxNum = Integer.MIN_VALUE;
        int minNum = Integer.MAX_VALUE;
        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            maxNum = Math.max(maxNum, num);
            minNum = Math.min(minNum, num);
        }

        System.out.println(minNum + " " + maxNum);
    }
}
