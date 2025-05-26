import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());


        if (N <= 2) System.out.println(N);
        else {
            int[] dp = new int[N+1];
            dp[1] = 1;
            dp[2] = 2;

            for (int i = 3; i <= N; i++) {
                dp[i] = dp[i-1] + dp[i-2];
            }

            System.out.println(dp[N]);
        }
    }
}
