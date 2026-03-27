import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1074_Re {
    static int r, c;
    static int result = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());

        // 한 변의 길이는 2^N
        int size = (int) Math.pow(2, N);
        find(size, r, c);

        System.out.println(result);
    }

    private static void find(int size, int r, int c) {
        if (size == 1) return;

        int half = size / 2;
        int area = half * half;

        if (r < half && c < half) {
            // 1사분면 (왼쪽 위)
            find(half, r, c);
        } else if (r < half && c >= half) {
            // 2사분면 (오른쪽 위)
            result += area;
            find(half, r, c - half);
        } else if (r >= half && c < half) {
            // 3사분면 (왼쪽 아래)
            result += area * 2;
            find(half, r - half, c);
        } else {
            // 4사분면 (오른쪽 아래)
            result += area * 3;
            find(half, r - half, c - half);
        }
    }
}