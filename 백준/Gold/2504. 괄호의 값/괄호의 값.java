import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        ArrayDeque<Character> stack = new ArrayDeque<>();
        int[] depth = new int[16];

        boolean errorFlag = false;
        int n;
        char comp;
        for (char c : br.readLine().toCharArray()) {
            if (c == '(' || c == '[') {
                stack.push(c);
            }
            else {
                n = stack.size();
                if (n == 0) {
                    errorFlag = true;
                    break;
                }
                else {
                    comp = stack.pop();
                    if ((comp == '(' && c != ')') || (comp == '[' && c != ']')) {
                        errorFlag = true;
                        break;
                    }
                }

                if (depth[n] == 0) {
                    if (c == ')') depth[n-1] += 2;
                    else depth[n-1] += 3;
                }
                else {
                    if (c == ')') depth[n-1] += depth[n] * 2;
                    else depth[n-1] += depth[n] * 3;
                    depth[n] = 0;
                }

            }
        }

        System.out.println(errorFlag ? 0 : depth[0]);
    }
}
