package Lv2;

public class 이진_변환_반복하기 {

    public int[] solution(String s) {
        int toBinCnt = 0;
        int removeCnt = 0;
        while (!s.equals("1")) {
            int sLen = s.length();
            String onlyOneS = s.replace("0", "");
            int onlyOneSLen = onlyOneS.length();
            removeCnt += sLen - onlyOneSLen;

            s = Integer.toBinaryString(onlyOneSLen);
            toBinCnt++;
        }
        return new int[]{toBinCnt, removeCnt};
    }
}
