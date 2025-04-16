import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static boolean isReversed = false;
    static boolean isError = false;
    static Deque<String> dq = new ArrayDeque<>();
    public static void main(String[] args) throws IOException {
        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            // 변수 선언
            String operations = br.readLine();
            int N = Integer.parseInt(br.readLine());

            // 변수 초기화
            dq.clear();
            isReversed = false;
            isError = false;
            sb.setLength(0);

            // 파싱된 숫자를 덱에 추가
            StringTokenizer st = new StringTokenizer(br.readLine(), "[,]");
            while(st.hasMoreTokens()) dq.add(st.nextToken());

            // 명령어에 따른 연산 수행
            for (int i = 0; i < operations.length(); i++) {
                char operation = operations.charAt(i);

                if (operation == 'R') isReversed = !isReversed;
                else { if (delete()) break; }
            }

            if (isError) {
                System.out.println("error");
                continue;
            }

            // 출력 로직
            printStringBuilder();
        }
    }

    static boolean delete() {
        if (dq.isEmpty()) {
            isError = true;
            return true;
        }
        if (isReversed) dq.pollLast();
        else dq.poll();
        return false;
    }

    static void pollFirst() {
        while (!dq.isEmpty()) {
            sb.append(dq.pollFirst());
            if (!dq.isEmpty()) {
                sb.append(",");
            }
        }
    }

    static void pollLast() {
        while (!dq.isEmpty()) {
            sb.append(dq.pollLast());
            if (!dq.isEmpty()) {
                sb.append(',');
            }
        }
    }

    static void printStringBuilder() {
        sb.append("[");
        if (isReversed) pollLast();
        else pollFirst();
        sb.append("]");
        System.out.println(sb);
    }
}
