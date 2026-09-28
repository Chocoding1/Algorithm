import java.util.Arrays;

// 프로그래머스 Lv.2
public class 전화번호_목록 {

    public boolean solution(String[] phone_book) {
        Arrays.sort(phone_book);
        for (int i = 0; i < phone_book.length - 1; i++) {
            String target = phone_book[i];
            String compare = phone_book[i + 1];

            if (compare.startsWith(target)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        전화번호_목록 solution = new 전화번호_목록();

        System.out.println(solution.solution(new String[]{"119", "97674223", "1195524421"}));
        System.out.println(solution.solution(new String[]{"123", "456", "789"}));
        System.out.println(solution.solution(new String[]{"12", "123", "1235", "567", "88"}));
    }
}
