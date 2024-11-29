import java.util.Arrays;

public class 배열_원소의_길이 {
    public int[] solution(String[] strList) {
        int[] answer = new int[strList.length];
        for (int i = 0; i < strList.length; i++) {
            answer[i] = strList[i].length();
        }

        return answer;

        // stream을 사용하여 간단하게 풀이 가능
//        return Arrays.stream(strList).mapToInt(String::length).toArray();
    }
}
