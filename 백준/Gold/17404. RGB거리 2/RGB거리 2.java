import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int INF = 1000001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], -1);
            for (int j = 0; j < 3; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int answer = INF;
        for (int color = 0; color < 3; color++) {
            Arrays.fill(dp[0], INF);
            dp[0][color] = cost[0][color];
            for (int step = 1; step < N; step++) {
                dp[step][0] = Math.min(dp[step-1][1], dp[step-1][2]) + cost[step][0];
                dp[step][1] = Math.min(dp[step-1][0], dp[step-1][2]) + cost[step][1];
                dp[step][2] = Math.min(dp[step-1][0], dp[step-1][1]) + cost[step][2];
            }
            dp[N-1][color] = INF;
            for (int i = 0; i < 3; i++) answer = Math.min(answer, dp[N-1][i]);
        }
        System.out.println(answer);
    }
}
