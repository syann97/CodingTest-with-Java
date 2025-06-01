import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        if (N == 0) {
            System.out.println(0);
            System.out.println(0);
        }

        else {
            int absN = Math.abs(N);
            long[] dp = new long[absN+1];
            dp[1] = 1;

            if (N < 0) {
                for (int i = 2; i <= absN; i++) {
                    dp[i] = (dp[i-2] - dp[i-1]) % 1000000000;
                }
            }

            else {
                for (int i = 2; i <= absN; i++) {
                    dp[i] = (dp[i-1] + dp[i-2]) % 1000000000;
                }
            }
            System.out.println(dp[absN] < 0 ? -1 : 1);
            System.out.println(Math.abs(dp[absN]));
        }
    }
}
