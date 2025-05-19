import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int INF = 200001;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] cost = new int[N][N];
        int[][] dp = new int[N][1 << N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(dp[i], INF);
            for (int j = 0; j < N; j++) {
                cost[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < N; k++) {
            dp[0][1 << k] = cost[0][k];
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < (1 << N); j++) {
                if (dp[i-1][j] == INF) continue;
                for (int k = 0; k < N; k++) {
                    if ((j & (1 << k)) != 0) continue;
                    dp[i][j|(1<<k)] = Math.min(dp[i][j|(1<<k)], dp[i-1][j] + cost[i][k]);
                }
            }
        }
        System.out.println(dp[N-1][(1<<N)-1]);
    }
}
