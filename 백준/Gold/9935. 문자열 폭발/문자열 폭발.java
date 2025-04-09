import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();         // 전체 문자열
        String bomb = br.readLine();      // 폭발 문자열
        int bombLen = bomb.length();

        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++) {
            stack.addLast(s.charAt(i)); // push 역할

            // 현재 문자가 폭발 문자열 마지막 문자와 같을 때만 비교
            if (s.charAt(i) == bomb.charAt(bombLen - 1)) {
                if (stack.size() >= bombLen) {
                    // 폭발 문자열 비교용 임시 저장
                    boolean isMatch = true;
                    Character[] temp = new Character[bombLen];
                    for (int j = bombLen - 1; j >= 0; j--) {
                        temp[j] = stack.removeLast(); // pop 역할
                    }

                    for (int j = 0; j < bombLen; j++) {
                        if (temp[j] != bomb.charAt(j)) {
                            isMatch = false;
                            break;
                        }
                    }

                    // 폭발 문자열이 아니면 다시 되돌려 넣기
                    if (!isMatch) {
                        for (int j = 0; j < bombLen; j++) {
                            stack.addLast(temp[j]);
                        }
                    }
                }
            }
        }

        if (stack.isEmpty()) {
            System.out.println("FRULA");
        } else {
            StringBuilder sb = new StringBuilder();
            for (char c : stack) {
                sb.append(c);
            }
            System.out.println(sb);
        }
    }
}
