import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Boj_1018 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String[] chess = new String[N];

        for (int i = 0; i < N; i++) {
            chess[i] = br.readLine();
        }
        int count;
        int result = 64; // 8 x 8 체스판의 모든 칸을 다시 칠하는 경우를 최댓값으로 지정
        String[] pattern = {"BWBWBWBW", "WBWBWBWB"};
        String target, subChess;

        for (int i = 0; i < M - 8 + 1; i++) { // col 반복
            for (int j = 0; j < N - 8 + 1; j++) { // row 반복
                // 카운트 초기화
                count = 0;
                for (int k = j; k < j + 8; k++) { // 8번 행 반복 (8x8이니까)
                    target = pattern[k % 2]; // 비교할 패턴
                    subChess = chess[k].substring(i); // 계산할 체스판 한 줄
                    // 문자열 서브스트링으로 비교하기
                    for (int l = 0; l < 8; l++) { // 8번 열 반복(한 칸씩 비교)
                        // 서로 비교하면서 다르면 count++
                        if (subChess.charAt(l) != target.charAt(l)) {
                            count++;
                        }
                    }
                }
                // 맨 왼쪽 위 칸을 흑으로 둘 때와, 백으로 둘 때의 칠하는 횟수를 비교하여 작은 값을 지정
                count = Math.min(count, 64 - count);
                // count가 result보다 작으면 result 갱신
                result = Math.min(result, count);
            }
        }

        System.out.println(result);
    }
}
