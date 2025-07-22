import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


/**
 * 단순 BFS로는 풀 수 없는 이유
 *
 * 간선의 길이가 모두 같지 않기 때문에 단순한 bfs 로는 최단경로 순서로 방문을 하지 않을 수 있습니다.
 * 예를 들어 거리제한이 15이라고 하면,
 * 1번도시 -> 2번도시 거리가 10 이고
 * 1번도시 -> 3번도시 거리가 3 이고
 * 3번도시 -> 2번도시 거리가 3 이고
 * 2번도시 -> 4번도시 거리가 6 이라고 합시다.
 * 그러면 1번 -> 3번 -> 2번 -> 4번 순서로 방문하면 1번도시 -> 4번도시 사이의 거리는 12이므로 아이템을 얻을 수 있어야 하지만 위와 같이 bfs 를 하게되면
 * 1번도시를 방문 한 뒤에 2번 도시와 3번 도시가 queue에 push 가 되고 방문하게 될텐데
 * 2번 도시를 방문했을 때 4번도시가 거리가 안된다고 생각하여 방문을 하지 않게 됩니다.
 * 그리고 3번 도시를 방문하고 탐색이 종료 되겠죠.
 * 3번 도시를 방문했을 때, 2번 도시와의 거리가 변할 수 있기 때문에 4번 도시를 방문할 수 있는데 이 가능성이 무시된겁니다.
 *
 * 그래서 간선의 길이가 모두 같지 않을 때 최단 거리 순서로 방문하는 "다익스트라" 알고리즘이 있으니 참고하면 좋을 것 같습니다.
 *
 * 참고 블로그 : https://dy-coding.tistory.com/entry/%EB%B0%B1%EC%A4%80-14938%EB%B2%88-%EC%84%9C%EA%B0%95%EA%B7%B8%EB%9D%BC%EC%9A%B4%EB%93%9C-java
 */
public class Boj_14938 {

    private static int n, m, r;
    private static int[] items;
    private static List<List<int[]>> roadmap = new ArrayList<>();
    private static boolean[] visited;
    private static int[] dist;
    private static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        r = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        dist = new int[n];
        items = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            roadmap.add(new ArrayList<>());
        }
        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            roadmap.get(a - 1).add(new int[]{b - 1, l});
            roadmap.get(b - 1).add(new int[]{a - 1, l});
        }

        for (int i = 0; i < n; i++) {
            getItems(i);
        }

        System.out.println(result);
    }

    private static void getItems(int region) {
        Arrays.fill(visited, false);
        Arrays.fill(dist, Integer.MAX_VALUE);
        PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1] - o2[1];
            }
        });
        queue.offer(new int[]{region, 0});
        dist[region] = 0;

        int totalItems = 0;
        while (!queue.isEmpty()) {
            int[] curNode = queue.poll();
            int curRegion = curNode[0];
            int curWeight = curNode[1];

            /**
             * 이 방문 확인 로직이 중요한 이유
             * 예를 들어 노드 (2, 10)을 큐에 먼저 저장했는데, 그 뒤에 노드 (2, 5)가 저장이 되었다고 해보자.
             * 그러면 우선순위 큐에 의해 노드 (2, 5)가 먼저 나올테고 여기서 방문처리가 될 것이다.
             * 그러나 큐가 전부 비워질 때까지 해당 반복문은 돌아갈 것이고, 큐에는 노드 (2, 10)도 저장되어 있기 때문에
             * 시간이 지나 노드 (2, 10)도 나올 것이다. 그런데 이 때, 해당 로직이 없다면 그대로 또 방문을 하게 되기 때문이다.
             */
            if (visited[curRegion]) {
                continue;
            }

            visited[curRegion] = true;
            totalItems += items[curRegion];
            for (int[] nxtNode : roadmap.get(curRegion)) {
                int nxtRegion = nxtNode[0];
                int nxtWeight = nxtNode[1];

                // 얘는 사실 없어도 되는 로직이다. 방문 체크 안 하고 큐에 넣어도 큐에서 뺄 때, 다 확인하고 방문한 노드는 더 이상 진행하지 않기 때문
                if (visited[nxtRegion]) {
                    continue;
                }

                if (curWeight + nxtWeight > m) {
                    continue;
                }

                // 동일한 이유로 얘도 없어도 되는 로직이다. 방문한 노드에 또 방문을 했다는 것은 당연히 해당 노드가 가지고 있던 거리보다 클 수밖에 없기 때문에
                // 방문 체크를 안 해도 된다는 것은 해당 노드가 가지고 있는 거리보다 더 큰 거리가 들어와도 된다는 얘기이기 때문에
                // 방문 체크를 안 하기로 했으면 이 거리 비교도 안 해도 된다.
                // 사실 이전에는 방문 체크와 거리 비교 둘 중 하나는 무조건 있어야 한다고 생각했는데, 어짜피 우선 순위 큐이기 때문에 거리가 작은 노드부터 빠져오고, 큐에서 노드를 뺄 때 방문 체크를 진행하기 때문에 없어도 된다.
                if (dist[nxtRegion] < curWeight + nxtWeight) {
                    continue;
                }

                queue.offer(new int[]{nxtRegion, curWeight + nxtWeight});
                dist[nxtRegion] = curWeight + nxtWeight;
            }
        }

        result = Math.max(result, totalItems);
    }
}
