import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_11729 {

    private static final StringBuilder stringBuilder = new StringBuilder();
    private static int moveCount = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(bufferedReader.readLine());

        hanoi(N, 1, 2, 3);

        System.out.println(moveCount);
        System.out.println(stringBuilder);
    }

    private static void hanoi(int n, int from, int temp, int to) {
        if (n == 1) {
            stringBuilder.append(from).append(" ").append(to).append("\n");
            moveCount++;
            return;
        }

        hanoi(n - 1, from, to, temp);
        stringBuilder.append(from).append(" ").append(to).append("\n");
        moveCount++;
        hanoi(n - 1, temp, from, to);
    }
}
