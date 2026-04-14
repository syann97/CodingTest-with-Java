import java.util.*;

class Solution {
    int MOD = 20170805;
    public int solution(int m, int n, int[][] cityMap) {
        int[][][] dp =  new int[m][n][2];
        dp[0][0][0] = 1;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (cityMap[i][j] == 1) continue;                
                int right = j+1;
                int down = i+1;
                
                if (cityMap[i][j] == 0) {
                    if (right < n) dp[i][right][0] = (dp[i][right][0] + dp[i][j][1]) % MOD;
                    if (down < m) dp[down][j][1] = (dp[down][j][1] + dp[i][j][0]) % MOD;    
                }
                if (right < n) dp[i][right][0] = (dp[i][right][0] + dp[i][j][0]) % MOD;
                if (down < m) dp[down][j][1] = (dp[down][j][1] + dp[i][j][1]) % MOD;
            }
        }
        return (dp[m-1][n-1][0] + dp[m-1][n-1][1]) % MOD;
    }
}