// 프로그래머스 Lv.3
public class 단어_변환 {

    private boolean[] visited;
    private int answer;

    public int solution(String begin, String target, String[] words) {
        visited = new boolean[words.length];

        answer = Integer.MAX_VALUE;
        dfs(begin, 0, target, words);

        if (answer == Integer.MAX_VALUE) {
            answer = 0;
        }
        return answer;
    }

    private void dfs(String curWord, int count, String target, String[] words) {
        if (curWord.equals(target)) {
            answer = Math.min(answer, count);
        }
        for (int i = 0; i < words.length; i++) {
            if (!visited[i]) {
                int differentCount = getDifferentCount(curWord, words[i]);
                if (differentCount == 1) {
                    visited[i] = true;
                    dfs(words[i], count + 1, target, words);
                    visited[i] = false;
                }
            }
        }
    }

    private int getDifferentCount(String curWord, String word) {
        int count = 0;
        for (int i = 0; i < curWord.length(); i++) {
            if (curWord.charAt(i) != word.charAt(i)) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        단어_변환 solution = new 단어_변환();

        System.out.println(solution.solution(
                "hit",
                "cog",
                new String[]{"hot", "dot", "dog", "lot", "log", "cog"}
        ));
        System.out.println(solution.solution(
                "hit",
                "cog",
                new String[]{"hot", "dot", "dog", "lot", "log"}
        ));
    }
}
