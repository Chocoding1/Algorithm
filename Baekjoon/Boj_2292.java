import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 벌집을 살펴 보면
 * 2 ~ 7번 방은 1번 방으로부터 1칸
 * 8 ~ 19번 방은 1번 방으로부터 2칸
 * 20 ~ 37번 방은 1번 방으로부터 3칸 떨어져 있다.
 * 이 경계값만 놓고 보면, 1 -> 7 -> 19 -> 37 -> ...이다.
 * 저 경계값 사이의 규칙은 "6n만큼 커지는 것"이다.
 * 즉, 경계값을 1부터 시작해서 N과 비교를 하고,
 * N이 경계값보다 작거나 같다면, 해당 바운더리 안에 방이 존재한다는 뜻이므로 결과값 출력
 * N이 경계값보다 크다면, 해당 바운더리 밖에 방이 존재한다는 뜻이므로 6n을 더해서 더 큰 바운더리와 비교
 */
public class Boj_2292 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int boundary = 1; // 경계값
        int cnt = 1; // 거치는 방의 개수

        while (true) {
            if (N <= boundary) {
                break;
            }

            boundary += 6 * cnt++;
        }

        System.out.println(cnt);
    }
}