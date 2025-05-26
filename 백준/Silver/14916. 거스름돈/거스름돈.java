import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int[] coins  = {5, 2};
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());

        int[] dp = new int[N+1];
        Arrays.fill(dp, N);
        dp[0] = 0;
        for (int coin : coins) {
            for (int i = coin; i <= N; i++) {
                if (dp[i-coin] != N) {
                    dp[i] = Math.min(dp[i], dp[i-coin] + 1);
                }
            }
        }
        System.out.println(dp[N] == N ? -1 : dp[N]);
    }
}
