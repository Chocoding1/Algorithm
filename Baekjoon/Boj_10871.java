import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_10871 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        // String 객체는 변경 불가능하기 때문에 StringBuilder를 사용해 문자열 덧셈 연산 진행
        // StringBuilder를 사용하지 않고 문자열 덧셈 연산을 진행하면 두 문자열을 더한 새로운 문자열을 새로운 메모리에 할당하게 되고,
        // 이전 두 문자열은 가비지 컬렉터로 들어가게 된다. (이렇게 되면 메모리 낭비가 심해진다.)
        // StringBuilder는 변경 가능한 문자열을 생성하기 때문에 문자열 연산을 진행해도 새로운 메모리에 할당하지 않는다.
        StringBuilder sb = new StringBuilder();

        while (st.hasMoreTokens()) {
            int num = Integer.parseInt(st.nextToken());
            if (num < X) {
                sb.append(num).append(" ");
            }
        }

        System.out.println(sb);
    }
}
