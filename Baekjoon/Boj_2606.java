import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_2606 {

    static ArrayList<ArrayList<Integer>> network;
    static boolean[] visited;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int V = Integer.parseInt(br.readLine());
        int E = Integer.parseInt(br.readLine());

        visited = new boolean[V + 1];
        network = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            network.add(new ArrayList<>());
        }

        StringTokenizer st;
        int v1, v2;
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            v1 = Integer.parseInt(st.nextToken());
            v2 = Integer.parseInt(st.nextToken());
            network.get(v1).add(v2);
            network.get(v2).add(v1);
        }

        result = 0;
        // BFS
/*
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(1);
        visited[1] = true;

        int curV;
        while (!queue.isEmpty()) {
            curV = queue.poll();
            for (Integer nxtV : network.get(curV)) {
                if (!visited[nxtV]) {
                    result++;
                    queue.offer(nxtV);
                    visited[nxtV] = true;
                }
            }
        }
*/
        // DFS
        Stack<Integer> stack = new Stack<>();
        dfs(1);

        System.out.println(result);
    }

    private static void dfs(int curV) {

        visited[curV] = true;

        for (Integer nxtV : network.get(curV)) {
            if (!visited[nxtV]) {
                result++;
                dfs(nxtV);
            }
        }
    }
}
