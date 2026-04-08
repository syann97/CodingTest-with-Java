import java.util.*;

class Solution {
    public int solution(int[][] triangle) {
        int N = triangle.length;
        // 기억해야할 값
        // 위 누적 값
        int[][] dp = new int[N][N+1];
        dp[0][0] = triangle[0][0];
        for (int i = 0; i < triangle.length-1; i++) {
            for (int j = 0; j < i+1; j++) {
                dp[i+1][j] = Math.max(dp[i+1][j], dp[i][j] + triangle[i+1][j]);
                dp[i+1][j+1] = Math.max(dp[i+1][j+1], dp[i][j] + triangle[i+1][j+1]);
            }
        }
        
        
        int max = 0;
        for (int j = 0; j < N; j++) {
            max = Math.max(max, dp[N-1][j]);
        }
        
        return max;
    }
}