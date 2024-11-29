public class 배열_원소의_길이 {
    public int[] solution(String[] strList) {
        int[] answer = new int[strList.length];
        for (int i = 0; i < strList.length; i++) {
            answer[i] = strList[i].length();
        }

        return answer;

        // stream을 사용
//        return Arrays.stream(strList).mapToInt(String::length).toArray();
    }
}
