import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * 노드에 도착할 때마다, 이전에 거쳤던 노드들을 저장한 리스트들을 같이 저장한다.
 * 이렇게 하면 나중에 도착지에 도착했을 때, 추가 작업 없이 거쳐온 도시의 수와 도시 경로를 바로 구할 수 있다.
 */
public class Boj_11779 {

    private static int n, m;
    private static List<City>[] busMap; // 인접 리스트
    private static int start, end;
    private static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        m = Integer.parseInt(br.readLine());

        busMap = new ArrayList[n + 1];
        visited = new boolean[n + 1];

        for (int i = 0; i < n + 1; i++) {
            busMap[i] = new ArrayList<>();
        }

        StringTokenizer st;
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            busMap[s].add(new City(e, c));
        }

        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra();
    }

    private static void dijkstra() {
        PriorityQueue<City> queue = new PriorityQueue<>(new Comparator<City>() {
            @Override
            public int compare(City o1, City o2) {
                return o1.cost - o2.cost;
            }
        });
        ArrayList<Integer> hist = new ArrayList<>();
        hist.add(start); // 현재 노드에 들어갈 경로 리스트에 본인을 추가하여 City 객체 생성
        queue.offer(new City(start, 0, hist)); // new City(start, 0, {start})

        while (!queue.isEmpty()) {
            City cur = queue.poll();

            if (cur.idx == end) { // 도착지에 도달하면 그대로 출력
                StringBuilder sb = new StringBuilder();
                sb.append(cur.cost).append("\n"); // 최단 비용
                sb.append(cur.hist.size()).append("\n"); // 거쳐온 도시 수
                for (Integer idx : cur.hist) {
                    sb.append(idx).append(" "); // 거쳐온 경로
                }
                System.out.println(sb);
                return;
            }

            if (visited[cur.idx]) { // 이미 방문한 도시면 pass (다익스트라 알고리즘의 특성 상 나중에 도착한 것은 비용이 더 크다.)
                continue;
            }

            visited[cur.idx] = true; // 방문한 적 없는 도시면 방문처리하고 진행
            for (City nxt : busMap[cur.idx]) { // 현재 도시에서 갈 수 있는 도시 탐색
                hist = new ArrayList<>(cur.hist); // 현재 도시의 경로 리스트를 복사
                hist.add(nxt.idx); // 다음 도시를 추가
                queue.offer(new City(nxt.idx, cur.cost + nxt.cost, hist)); // 해당 경로로 새로운 City 객체 생성하여 queue에 저장
            }
        }
    }

    private static class City {

        private int idx;
        private int cost;
        private List<Integer> hist; // 거쳐온 도시 저장 리스트

        public City(int idx, int cost) { // 처음 입력 도시 생성용
            this.idx = idx;
            this.cost = cost;
        }

        public City(int idx, int cost, List<Integer> hist) { // 다익스트라 탐색 시 도시 생성용
            this.idx = idx;
            this.cost = cost;
            this.hist = hist;
        }

    }
}
