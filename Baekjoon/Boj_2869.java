import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_2869 {

    /**
     * 꼭 밤까지 안 가더라도 낮에 정상에 도달하면 끝이다.
     * 때문에 하루 단위로 생각해서 A - B를 계산하면 안 된다.
     * 낮에 도달할 수 있는지 여부를 판단하기 위해 V에서 A를 뺀다.
     * 그럼 그 높이에 도달하게 되면 그 다음 날 정상에 올라갈 수 있다고 판단할 수 있다.
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        int result = (V - A) / (A - B);

        if ((V - A) % (A - B) != 0) { // 만약 V - A 높이에도 도달하지 못 하면,
            // 2일을 더 가야한다는 뜻이므로 나눈 몫에 1을 더해준다.
            result++;
        }

        System.out.println(result + 1);
    }
}
