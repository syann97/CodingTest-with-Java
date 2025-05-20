import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static final int INF = 100000000;
    static int FULL_MASK;
    static int N;
    static int[][] W;
    static int[][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        W = new int[N][N];
        FULL_MASK = 1 << N;
        dp = new int[FULL_MASK][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                W[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < FULL_MASK; i++) Arrays.fill(dp[i], -1);
        System.out.println(tsp(1, 0));
    }

    private static int tsp(int mask, int city) {
        if (mask == FULL_MASK - 1) {
            if (W[city][0] == 0) return INF;
            return W[city][0];
        }

        if (dp[mask][city] != -1) return dp[mask][city];
        dp[mask][city] = INF;

        for (int k = 0; k < N; k++) {
            if ((mask & (1 << k)) != 0 || W[city][k] == 0) continue;
            int next_mask = mask | (1 << k);
            dp[mask][city] = Math.min(dp[mask][city], tsp(next_mask, k) + W[city][k]);
        }

        return dp[mask][city];
    }
}
