import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Boj_15681 {

    private static int N, R, Q;
    private static int[] nodeCnts;
    private static List<Integer>[] graph;
    private static List<Integer>[] childs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());

        graph = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            st = new StringTokenizer(br.readLine());
            int U = Integer.parseInt(st.nextToken());
            int V = Integer.parseInt(st.nextToken());

            graph[U].add(V);
            graph[V].add(U);
        }

        childs = new List[N + 1];
        for (int i = 0; i < N + 1; i++) {
            childs[i] = new ArrayList<>();
        }

        makeTree(R, -1);

        nodeCnts = new int[N + 1];
        countNodes(R);

        for (int i = 0; i < Q; i++) {
            System.out.println(nodeCnts[Integer.parseInt(br.readLine())]);
        }
    }

    private static void makeTree(int curNode, int parent) {
        for (Integer nxtNode : graph[curNode]) {
            if (nxtNode == parent) {
                continue;
            }
            childs[curNode].add(nxtNode);
            makeTree(nxtNode, curNode);
        }
    }

    private static void countNodes(int curNode) {
        nodeCnts[curNode] = 1;
        for (Integer child : childs[curNode]) {
            countNodes(child);
            nodeCnts[curNode] += nodeCnts[child];
        }
    }
}
