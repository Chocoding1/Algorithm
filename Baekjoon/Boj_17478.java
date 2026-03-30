import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Boj_17478 {

    private static final String prefix = "____";
    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(bufferedReader.readLine());

        System.out.println("어느 한 컴퓨터공학과 학생이 유명한 교수님을 찾아가 물었다.");
        question(0);
    }

    private static void question(int n) {
        printWithPrefix(n, "\"재귀함수가 뭔가요?\"");
        if (n == N) {
            printWithPrefix(n, "\"재귀함수는 자기 자신을 호출하는 함수라네\"");
            printWithPrefix(n, "라고 답변하였지.");
            return;
        }

        printWithPrefix(n, "\"잘 들어보게. 옛날옛날 한 산 꼭대기에 이세상 모든 지식을 통달한 선인이 있었어.");
        printWithPrefix(n, "마을 사람들은 모두 그 선인에게 수많은 질문을 했고, 모두 지혜롭게 대답해 주었지.");
        printWithPrefix(n, "그의 답은 대부분 옳았다고 하네. 그런데 어느 날, 그 선인에게 한 선비가 찾아와서 물었어.\"");
        question(n +1);
        printWithPrefix(n, "라고 답변하였지.");
    }

    private static void printWithPrefix(int n, String message) {
        System.out.println(prefix.repeat(n) + message);
    }
}
