import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15686 {

    private static class Pos {
        private final int i;
        private final int j;

        public Pos(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    private static int N, M;
    private static final List<Pos> home = new ArrayList<>(); // 집 리스트
    private static final List<Pos> chicken = new ArrayList<>(); // 치킨집 리스트
    private static boolean[] open; // 치킨집 오픈 여부
    private static int res = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                int curNum = Integer.parseInt(st.nextToken());
                if (curNum == 1) {
                    home.add(new Pos(i, j));
                } else if (curNum == 2) {
                    chicken.add(new Pos(i, j));
                }
            }
        }

        open = new boolean[chicken.size()];

        selectChick(0, 0); // openCnt : 오픈한 치킨집 수, idx : 오픈할 치킨집 인덱스
        System.out.println(res);
    }

    /**
     * 우선 치킨집을 M개 선택해야 한다.
     * 재귀 호출로 치킨집을 M개 선택한 후에, 거리를 계산한다.
     * 어떤 치킨집이 선택되었는지 구분하기 위해 boolean 배열을 사용했다.
     */
    private static void selectChick(int openCnt, int idx) {
        if (openCnt == M) { // 선택된 치킨집이 M개가 되었으면 거리 계산
            int totalDist = 0; // 선택된 치킨집으로 구하는 도시의 치킨 거리
            for (int i = 0; i < home.size(); i++) {
                Pos curHome = home.get(i);
                int minDist = Integer.MAX_VALUE; // 현재 집의 치킨 거리(오픈된 치킨집 중 가장 가까운 거리 찾는 것)
                for (int j = 0; j < chicken.size(); j++) {
                    if (open[j]) { // 현재 치킨집이 오픈 상태라면 치킨 거리 계산
                        Pos curChick = chicken.get(j);
                        int dist = Math.abs(curHome.i - curChick.i) + Math.abs(curHome.j - curChick.j);

                        minDist = Math.min(minDist, dist); // 오픈된 치킨집 중 가장 가까운 치킨 거리 계산
                    }
                }
                totalDist += minDist; // 도시의 치킨 거리에 현재 집의 치킨 거리 더하기
            }
            res = Math.min(res, totalDist); // 이전에 구한 도시의 치킨 거리보다 짧으면 결과값 갱신
            return;
        }

        /**
         * 오픈할 치킨집을 선택하는 로직
         */
        for (int i = idx; i < chicken.size(); i++) {
            open[i] = true;
            selectChick(openCnt + 1, i + 1);
            open[i] = false;
        }
    }
}
