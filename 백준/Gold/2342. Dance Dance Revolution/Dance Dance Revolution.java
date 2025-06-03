import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static final int INF = 1000000;
    static int[][] cost = {
            {INF, 2, 2, 2, 2},
            {INF, 1, 3, 4, 3},
            {INF, 3, 1, 3, 4},
            {INF, 4, 3, 1, 3},
            {INF, 3, 4, 3, 1}
    };

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        List<Integer> numbers = new ArrayList<>();

        while (true) {
            int n = Integer.parseInt(st.nextToken());
            if (n == 0) break;
            numbers.add(n);
        }

        int N = numbers.size();
        int[][][] dp = new int[N][5][5];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < 5; j++) {
                Arrays.fill(dp[i][j], INF);
            }
        }

        int first = numbers.get(0);
        dp[0][first][0] = 2;
        dp[0][0][first] = 2;


        for (int turn = 1; turn < N; turn++) {
            int now = numbers.get(turn);

            for (int left = 0; left < 5; left++) {
                for (int right = 0; right < 5; right++) {
                    if (left == right || dp[turn-1][left][right] == INF) continue;
                    dp[turn][now][right] = Math.min(dp[turn][now][right], dp[turn-1][left][right] + cost[left][now]);
                    dp[turn][left][now] = Math.min(dp[turn][left][now], dp[turn-1][left][right] + cost[right][now]);
                }
            }
        }

        int min = INF;
        for (int i = 0; i < 5; i++) {
            for (int j = 0; j < 5; j++) {
                if (i == j) continue;
                min = Math.min(min, dp[N-1][i][j]);
            }
        }
        System.out.println(min);
    }
}

