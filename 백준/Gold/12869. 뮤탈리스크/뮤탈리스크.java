import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[][] attacks = {{9, 3, 1}, {9, 1, 3}, {3, 9, 1}, {3, 1, 9}, {1, 9, 3}, {1, 3, 9}};
    static int answer;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[] SCV = new int[3];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            SCV[i] = Integer.parseInt(st.nextToken());
        }

        if (N == 1) answer = SCV[0] % 9 != 0 ? (SCV[0] / 9) + 1 : (SCV[0] / 9);
        else {
            answer = Integer.MAX_VALUE;
            int SCV1 = SCV[0];
            int SCV2 = SCV[1];
            int SCV3 = SCV[2];

            int[][][] dp = new int[SCV1+1][SCV2+1][SCV3+1];
            for (int i = 0; i <= SCV1; i++) {
                for (int j = 0; j <= SCV2; j++) {
                    for (int k = 0; k <= SCV3; k++) {
                        dp[i][j][k] = Integer.MAX_VALUE;
                    }
                }
            }
            dfs(SCV1, SCV2, SCV3, dp, 0);
        }
        System.out.println(answer);
    }
    static void dfs(int SCV1, int SCV2, int SCV3, int[][][] dp, int count) {
        if (dp[SCV1][SCV2][SCV3] <= count) return;
        dp[SCV1][SCV2][SCV3] = count;
        
        if (SCV1 == 0 && SCV2 == 0 && SCV3 == 0) {
            answer = count;
            return;
        }

        if (count >= answer) return;

        for (int[] attack : attacks) {
            int next1 = Math.max(SCV1 - attack[0], 0);
            int next2 = Math.max(SCV2 - attack[1], 0);
            int next3 = Math.max(SCV3 - attack[2], 0);
            dfs(next1, next2, next3, dp, dp[SCV1][SCV2][SCV3] + 1);
        }
    }
}
