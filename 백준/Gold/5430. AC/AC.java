import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static String[] numbers;
    static boolean isReversed = false;
    static boolean isError = false;
    static Deque<Integer> deque = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            // 변수 선언
            String operations = br.readLine();
            int N = Integer.parseInt(br.readLine());
            String input = br.readLine();

            // 변수 초기화
            deque.clear();
            isReversed = false;
            isError = false;
            sb.setLength(0);

            // 파싱된 숫자를 덱에 추가
            input = input.replaceAll("\\[|\\]", ""); // "[" 또는 "]" 제거

            if (input.isEmpty()) numbers = new String[0];
            else {
                numbers = input.split(",");
                for (String numStr : numbers) {
                    deque.add(Integer.parseInt(numStr.trim())); // 공백 제거 후 정수로 변환
                }
            }

            // 명령어에 따른 연산 수행
            for (int i = 0; i < operations.length(); i++) {
                char operation = operations.charAt(i);

                if (operation == 'R') isReversed = !isReversed;
                else if (delete()) break;
            }

            if (isError) System.out.println("error");
            else {
                sb.append("[");
                if (isReversed) popDeque();
                else pollDeque();
                sb.append("]");
                System.out.println(sb);
            }
        }
    }

    static boolean delete() {
        if (deque.isEmpty()) {
            isError = true;
            return true;
        }
        if (isReversed) deque.pollLast();
        else deque.poll();
        return false;
    }

    static void pollDeque() {
        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst());
            if (!deque.isEmpty()) {
                sb.append(",");
            }
        }
    }

    static void popDeque() {
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
            if (!deque.isEmpty()) {
                sb.append(',');
            }
        }
    }
}
