import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import static java.lang.Math.abs;

public class Main {
    static final int MAX = 1000000000;
    static StringTokenizer st;
    static int[] low;
    static int[] high;
    static int N;
    static int M;



    public static void main(String[] args) throws IOException {
        init();
        System.out.println(greedy());
    }



    static int greedy() {
        int[][] dp = new int[N+1][M+1];

        for (int i = 0; i <= N; i++) {
            Arrays.fill(dp[i], MAX);
        }

        for (int j = 0; j <= M; j++) {
            dp[0][j] = 0;
        }

        dp[0][0] = 0;
        for (int i = 1; i <= N; i++) {
            // M이 큰 경우임
            for (int j = 1; j <= M; j++) {
                // N이 큰 경우 문제 발생
                if (i > j) continue;
                int cost = dp[i-1][j-1] + abs(low[i] - high[j]);

                if (i == j) {
                    dp[i][j] = cost;
                }
                else {
                    dp[i][j] = Math.min(cost, dp[i][j-1]);
                }
            }
        }

        return dp[N][M];
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        low = new int[N+1];
        high = new int[M+1];

        st = new StringTokenizer(br.readLine());
        initDp(low, N);
        st = new StringTokenizer(br.readLine());
        initDp(high, M);

        Arrays.sort(low);
        Arrays.sort(high);

        if (N > M) {
            swap();
        }
    }

    private static void swap() {
        int[] arrTmp = low;
        low = high;
        high = arrTmp;

        int tmp = N;
        N = M;
        M = tmp;
    }

    static void initDp(int[] dp, int n) {
        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.parseInt(st.nextToken());
        }
    }
}
