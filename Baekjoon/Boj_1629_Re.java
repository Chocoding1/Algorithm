import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1629_Re {

    private static int A, B, C;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        A = Integer.parseInt(stringTokenizer.nextToken());
        B = Integer.parseInt(stringTokenizer.nextToken());
        C = Integer.parseInt(stringTokenizer.nextToken());

        System.out.println(recursion(B));
    }

    private static long recursion(int b) {
        if (b == 0) {
            return 1;
        }
        if (b == 1) {
            return A % C;
        }

        long half = recursion(b / 2);

        if (b % 2 == 0) {
            return (half * half) % C;
        }

        return (((half * half) % C) * (A % C)) % C;
    }
}
