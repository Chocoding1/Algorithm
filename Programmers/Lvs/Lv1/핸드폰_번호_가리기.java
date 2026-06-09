package Lv1;

public class 핸드폰_번호_가리기 {

    static String solution(String phone_number) {
        if (phone_number.length() <= 4) {
            return phone_number;
        }

        String stars = "*".repeat(phone_number.length() - 4);
        String lastFour = phone_number.substring(phone_number.length() - 4);
        return stars + lastFour;
    }

    public static void main(String[] args) {
        System.out.println(solution("01033334444"));
        System.out.println(solution("027778888"));
    }
}
