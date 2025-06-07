import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int L = N - K;

        String number = br.readLine();
        ArrayDeque<Character> stack = new ArrayDeque<>();

        for (char c : number.toCharArray()) {
            while (!stack.isEmpty()) {
                if (stack.peekLast() >= c || K == 0) break;
                stack.pollLast();
                K--;
            }
            stack.offer(c);
        }

        while (L --> 0) sb.append(stack.pollFirst());
        System.out.println(sb);
    }
}

