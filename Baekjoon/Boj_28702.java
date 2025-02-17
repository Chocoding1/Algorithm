import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 숫자들을 쭉 나열해본 뒤, Fizz, Buzz, FizzBuzz를 표시해보니 3개의 문자열이 연속으로 나오는 경우는 절대 없다는 것을 발견
 * 즉, 3개의 문자열이 주어졌을 때, 반드시 1개의 숫자를 포함한다는 얘기
 * 따라서 숫자의 위치를 알아낸 뒤, 위치에 맞게 숫자를 더해서 구하고자 하는 숫자를 구하면 된다.
 * 구한 뒤에는 FizzBuzz 판별만 하면 끝
 */
public class Boj_28702 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 3; i++) {
            String str = br.readLine();
            if (isLong(str)) {
                long num = Long.parseLong(str) + 3 - i;

                if (num % 15 == 0) {
                    System.out.println("FizzBuzz");
                } else if (num % 5 == 0) {
                    System.out.println("Buzz");
                } else if (num % 3 == 0) {
                    System.out.println("Fizz");
                } else {
                    System.out.println(num);
                }
                break;
            }
        }
    }

    private static boolean isLong(String str) {
        try {
            Long.parseLong(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
