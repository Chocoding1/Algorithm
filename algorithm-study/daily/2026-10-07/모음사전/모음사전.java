// 프로그래머스 Lv.2
public class 모음사전 {

    private final String[] vowel = {"A", "E", "I", "O", "U"};
    int count;
    int answer;

    public int solution(String word) {
        count = 0;
        answer = 0;
        search(word, "", 0);
        return answer;
    }

    private void search(String target, String word, int depth) {
        if (target.equals(word)) {
            answer = count;
            return;
        }

        if (depth == 5) {
            return;
        }

        for (int i = 0; i < vowel.length; i++) {
            count++;
            search(target, word + vowel[i], depth + 1);
            if (answer != 0) {
                return;
            }
        }
    }

    public static void main(String[] args) {
        모음사전 solution = new 모음사전();

        System.out.println(solution.solution("AAAAE"));
        System.out.println(solution.solution("AAAE"));
        System.out.println(solution.solution("I"));
        System.out.println(solution.solution("EIO"));
    }
}
