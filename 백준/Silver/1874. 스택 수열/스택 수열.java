import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuffer bf = new StringBuffer();
        int n = Integer.parseInt(br.readLine());
        Stack<Integer> stack = new Stack<>();
        int current = 1; // 오름차순 숫자
        boolean isPrintNo = false;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(br.readLine());
            if (current <= num) {
                while (current <= num) {
                    stack.push(current);
                    current++;
                    bf.append("+\n");
                }
                stack.pop();
                bf.append("-\n");
            }
            else {
                if (stack.peek() == num) {
                    stack.pop();
                    bf.append("-\n");
                }
                else {
                    isPrintNo = true;
                }
            }
            if (isPrintNo) {
                break;
            }


        }
        if (isPrintNo) {
            System.out.println("NO");
        }
        else System.out.println(bf.toString());
    }
}