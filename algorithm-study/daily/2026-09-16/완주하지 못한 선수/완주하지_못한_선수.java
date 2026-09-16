import java.util.Arrays;

// 프로그래머스 Lv.1
public class 완주하지_못한_선수 {

    public String solution(String[] participant, String[] completion) {
        Arrays.sort(participant);
        Arrays.sort(completion);

        for (int i = 0; i < completion.length; i++) {
            if (!completion[i].equals(participant[i])) {
                return participant[i];
            }
        }
        return participant[participant.length - 1];
    }

    public static void main(String[] args) {
        완주하지_못한_선수 solution = new 완주하지_못한_선수();

        System.out.println(solution.solution(
                new String[]{"leo", "kiki", "eden"},
                new String[]{"eden", "kiki"}
        ));
        System.out.println(solution.solution(
                new String[]{"marina", "josipa", "nikola", "vinko", "filipa"},
                new String[]{"josipa", "filipa", "marina", "nikola"}
        ));
        System.out.println(solution.solution(
                new String[]{"mislav", "stanko", "mislav", "ana"},
                new String[]{"stanko", "ana", "mislav"}
        ));
    }
}
