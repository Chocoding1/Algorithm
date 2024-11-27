import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Boj_1167 {

    static class Node {
        int to;
        int dist;

        public Node(int to, int dist) {
            this.to = to;
            this.dist = dist;
        }
    }

    public static int V;
    public static ArrayList<ArrayList<Node>> tree = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        for (int i = 0; i < V + 1; i++) {
            tree.add(new ArrayList<>());
        }

        for (int i = 0; i < V; i++) {
            st = new StringTokenizer(br.readLine());
            int stdV = Integer.parseInt(st.nextToken());
            while (true) {
                int endV = Integer.parseInt(st.nextToken());
                if (endV == -1) {
                    break;
                }
                int dist = Integer.parseInt(st.nextToken());
                tree.get(stdV).add(new Node(endV, dist));
            }
        }

        int[] result = bfs(1);

        result = bfs(result[0]);

        System.out.println(result[1]);
    }

    private static int[] bfs(int v) {
        Queue<Node> queue = new LinkedList<>();
        boolean[] visited = new boolean[V + 1];
        int maxDist = 0;
        int maxV = 0;

        queue.add(new Node(v, 0));
        visited[v] = true;

        while (!queue.isEmpty()) {
            Node curNode = queue.poll();
            if (curNode.dist > maxDist) {
                maxDist = curNode.dist;
                maxV = curNode.to;
            }
            for (Node nxtNode : tree.get(curNode.to)) {
                if (!visited[nxtNode.to]) {
                    queue.add(new Node(nxtNode.to, curNode.dist + nxtNode.dist));
                    visited[nxtNode.to] = true;
                }
            }
        }

        int[] result = new int[2];
        result[0] = maxV;
        result[1] = maxDist;

        return result;
    }
}
