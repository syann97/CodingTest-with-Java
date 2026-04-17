import java.util.*;

class Solution {
    public int solution(int sticker[]) {
        int N = sticker.length;
        int answer = 0;
        
        if (N <= 3) {
            int max = 0;
            for (int i = 0; i < N; i++) {
                max = Math.max(max, sticker[i]);
            }
            
            return max;
        }
            
        int[][] dp = new int[2][N+1];
        dp[0][1] = sticker[0];
        dp[1][0] = sticker[N-1];
        
        for (int i = 0; i < N-1; i++) {
            if (i+2 < N) {
                dp[0][i+2] = Math.max(dp[0][i+2], dp[0][i] + sticker[i+1]);
                dp[1][i+2] = Math.max(dp[1][i+2], dp[1][i] + sticker[i+1]);
            }
            if (i+3 < N) {
                dp[0][i+3] = Math.max(dp[0][i+3], dp[0][i] + sticker[i+2]);
                dp[1][i+3] = Math.max(dp[1][i+3], dp[1][i] + sticker[i+2]);
            }
        }
        
        int max = max = Math.max(Math.max(dp[0][N-1], dp[0][N-2]), Math.max(dp[1][N-2], dp[1][N-3]));

        return max;
    }
}