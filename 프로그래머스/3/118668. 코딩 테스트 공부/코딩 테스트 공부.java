import java.util.*;

class Solution {
    static int N;
    static int M;
    static final int MAX = 100000000;
    public int solution(int alp, int cop, int[][] problems) {
        N = 0;
        M = 0;
        for (int[] problem : problems) {
            N = Math.max(N, problem[0]);
            M = Math.max(M, problem[1]);
        }
        
        if (alp >= N && cop >= M) return 0;
        
        int[][] dp = new int[N+2][M+2];
    
        for (int i = 0; i <= N+1; i++) {
            Arrays.fill(dp[i], MAX);
        }
        
        alp = Math.min(alp, N);
        cop = Math.min(cop, M);
        dp[alp][cop] = 0;

        for (int i = alp; i <= N; i++) {
            for (int j = cop; j <= M; j++) {
                dp[i][j+1] = Math.min(dp[i][j+1], dp[i][j]+1);
                dp[i+1][j] = Math.min(dp[i+1][j], dp[i][j]+1);
                
                for (int[] problem : problems) {
                    if (i < problem[0] || j < problem[1]) continue;
                    int ni = Math.min(N, i+problem[2]);
                    int nj = Math.min(M, j+problem[3]);
                    
                    dp[ni][nj] = Math.min(dp[ni][nj], dp[i][j] + problem[4]);
                }
            }
        }
        
        return dp[N][M];
    }
}