import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[][] dp = new long[N-1][21];

        st = new StringTokenizer(br.readLine());
        dp[0][Integer.parseInt(st.nextToken())] = 1;

        for (int i = 1; i < N-1; i++) {
            int k = Integer.parseInt(st.nextToken());

            for (int j = 0; j <= 20; j++) {
                if (j - k >= 0 && dp[i-1][j] > 0) {
                    dp[i][j-k] += dp[i-1][j];
                }
                if (j + k <= 20 && dp[i-1][j] > 0) {
                    dp[i][j+k] += dp[i-1][j];
                }
            }
        }

        int target = Integer.parseInt(st.nextToken());
        System.out.println(dp[N-2][target]);
    }
}