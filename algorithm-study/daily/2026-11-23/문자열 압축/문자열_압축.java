// 프로그래머스 Lv.2
public class 문자열_압축 {

    public int solution(String s) {
        int answer = Integer.MAX_VALUE;
        for (int size = 1; size <= s.length(); size++) {
            int tempSize = compression(s, size);
            answer = Math.min(answer, tempSize);
        }
        return answer;
    }

    private int compression(String s, int size) {
        if (s.length() == 1) {
            return 1;
        }
        int curStartIdx = 0;
        while (curStartIdx <= s.length() - size) {
            String stdS = s.substring(curStartIdx, curStartIdx + size);
            int count = 0;
            int nxtStartIdx = 0;
            int endIdx;
            for (int i = 0; i < s.length(); i++) {
                nxtStartIdx = curStartIdx + size * i;
                endIdx = curStartIdx + size * (i + 1);
                if (nxtStartIdx >= s.length() || endIdx > s.length()) {
                    break;
                }
                String compS = s.substring(nxtStartIdx, endIdx);
                if (!stdS.equals(compS)) {
                    break;
                }
                count++;
            }
            if (count > 1) {
                String countText = String.valueOf(count);
                s = s.substring(0, curStartIdx) + countText + stdS + s.substring(curStartIdx + count * size, s.length());
                curStartIdx += size + countText.length();
                continue;
            }
            curStartIdx = nxtStartIdx;
        }
        return s.length();
    }

    public static void main(String[] args) {
        문자열_압축 solution = new 문자열_압축();

        System.out.println(solution.solution("aabbaccc"));
        System.out.println(solution.solution("ababcdcdababcdcd"));
        System.out.println(solution.solution("abcabcdede"));
        System.out.println(solution.solution("abcabcabcabcdededededede"));
        System.out.println(solution.solution("xababcdcdababcdcd"));
        System.out.println(solution.solution("ababa"));
        System.out.println(solution.solution("abcabcab"));
        System.out.println(solution.solution("a"));
        System.out.println(solution.solution("aaa"));
    }
}
