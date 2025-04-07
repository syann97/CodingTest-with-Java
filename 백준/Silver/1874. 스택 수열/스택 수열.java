import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int idx = 1;
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        boolean flag = true;


        for (int i = 0; i < N; i++) {
            int target = Integer.parseInt(br.readLine());
            if (idx <= target) {
                for (int j = idx; j <= target; j++) {
                    stack.push(j);
                    sb.append('+').append('\n');
                }
                idx = target + 1;
                sb.append('-').append('\n');
                stack.pop();
            }
            else {
                if (stack.isEmpty() || target > stack.peek()) {
                    flag = false;
                    break;
                }
                while (!stack.isEmpty()) {
                    int num = stack.pop();
                    sb.append('-').append('\n');

                    if (target == num) {
                        break;
                    }
                }
            }
        }
        if (flag) System.out.print(sb);
        else System.out.println("NO");
    }
}
