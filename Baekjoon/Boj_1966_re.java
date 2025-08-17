import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Boj_1966_re {

    private static int[] docs;
    private static Queue<Node> queue;
    private static int order, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int TC = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < TC; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());

            docs = new int[10];
            st = new StringTokenizer(br.readLine());
            int idx = 0;
            queue = new LinkedList<>();
            while (st.hasMoreTokens()) {
                int value = Integer.parseInt(st.nextToken());
                docs[value]++;
                queue.offer(new Node(value, idx++));
            }

            order = 1;
            while (!queue.isEmpty()) {
                if (searchDoc()) {
                    System.out.println(order);
                    break;
                }
            }
        }
    }

    private static boolean searchDoc() {
        int maxImport = maxImport();
        while (true) {
            Node cur = queue.poll();
            if (cur.value == maxImport) {
                docs[maxImport]--;
                if (cur.idx == M) {
                    return true;
                } else {
                    order++;
                    return false;
                }
            } else {
                queue.offer(cur);
                return false;
            }
        }
    }

    private static int maxImport() {
        for (int i = 9; i > 0 ; i--) {
            if (docs[i] > 0) {
                return i;
            }
        }
        return -1; // 의미없는 코드
    }

    private static class Node {
        private int value;
        private int idx;

        public Node(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }
    }
}
