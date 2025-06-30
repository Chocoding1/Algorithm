import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_5639 {

    private static class Node {
        int value;
        Node left, right;

        public Node(int value) {
            this.value = value;
        }

        public void insert(int value) {
            if (value < this.value) {
                if (this.left == null) {
                    this.left = new Node(value);
                } else {
                    this.left.insert(value);
                }
            } else {
                if (this.right == null) {
                    this.right = new Node(value);
                } else {
                    this.right.insert(value);
                }
            }
        }
    }

    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Node root = new Node(Integer.parseInt(br.readLine()));

        while (true) {
            String value = br.readLine();
            if (value == null || value.equals("")) {
                break;
            }
            root.insert(Integer.parseInt(value));
        }

        sb = new StringBuilder();
        postOrder(root);
        System.out.println(sb);
    }

    private static void postOrder(Node node) {
        if (node == null) return;

        postOrder(node.left);
        postOrder(node.right);
        sb.append(node.value).append("\n");
    }
}
