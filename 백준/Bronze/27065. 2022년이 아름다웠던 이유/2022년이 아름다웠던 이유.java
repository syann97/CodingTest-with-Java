import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        while (T-- > 0) {
            int n = Integer.parseInt(br.readLine());

            boolean flag = false;
            int sum = 0;

            for (int i = 1; i <= n / 2; i++) {
                if (n % i == 0) {
                    sum += i;
                    if (isOverNum(i)) flag = true;
                }
            }

            if (sum > n && !flag) {
                sb.append("Good Bye").append("\n");
            }
            else {
                sb.append("BOJ 2022").append("\n");
            }
        }

        System.out.print(sb);
    }

    static boolean isOverNum(int n) {
        int sum = 0;

        for (int i = 1; i <= n / 2; i++) {
            if (n % i == 0) {
                sum += i;
            }
        }

        return sum > n;
    }
}
