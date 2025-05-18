import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    static int[] weights = {3, 5};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N+1];
        Arrays.fill(dp, N);
        dp[0] = 0;

        for (int i = 3; i <= N; i++) {
            for (int weight : weights) {
                if (i - weight >= 0 && dp[i-weight] != N) dp[i] = Math.min(dp[i], dp[i-weight] + 1);
            }
        }
        System.out.println(dp[N] == N ? -1 : dp[N]);
    }
}
