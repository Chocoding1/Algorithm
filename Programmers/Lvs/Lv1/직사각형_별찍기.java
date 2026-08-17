package Lv1;

import java.util.Scanner;

public class 직사각형_별찍기 {

    static void solution(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();

        String oneLine = "*".repeat(n);

        for (int i = 0; i < m; i++) {
            System.out.println(oneLine);
        }
    }

    public static void main(String[] args) {
        solution(new String[]{"5", "3"});
    }
}
