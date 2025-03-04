import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Boj_4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str;
        Stack stack;
        String result = "yes";
        while (true) {
            str = br.readLine();
            // break point
            if (str.equals(".")) {
                break;
            }

            stack = new Stack();
            result = "yes";
            for (int i = 0; i < str.length(); i++) {
                if (str.charAt(i) == '(' || str.charAt(i) == '[') { // 여는 괄호는 스택에 저장
                    stack.push(str.charAt(i));
                } else if (str.charAt(i) == ')' || str.charAt(i) == ']') { // 닫는 괄호는 stack check
                    if (stack.empty()) { // stack 비어있으면, no
                        result = "no";
                        break;
                    }
                    if (str.charAt(i) == ')') { // 소괄호의 경우
                        if ((char) stack.pop() != '(') { // 스택에서 뺀 문자가 소괄호가 아니면, no
                            result = "no";
                            break;
                        }
                    } else { // 대괄호의 경우
                        if ((char) stack.pop() != '[') { // 스택에서 뺀 문자가 대괄호가 아니면, no
                            result = "no";
                            break;
                        }
                    }
                } else { // 관련 없는 문자는 pass
                    continue;
                }
            }
            /**
             *  반례 : ()(a.
             *  정답 : no
             */
            if (!stack.empty()) { // 문자열이 끝났는데 아직 스택에 괄호가 남아있으면, no
                result = "no";
            }
            System.out.println(result);

        }
    }
}
