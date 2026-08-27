import java.util.*;
class Solution {
    public int solution(int[] money) {
        int n = money.length;
        int[][] dp = new int[2][n];
        
        // 0번째 집을 터는 경우
        dp[0][0] = money[0];
        dp[0][1] = money[0];
            
        // 1번째 집을 터는 경우
        // dp[1][0] = 0; // 0이므로 생략
        dp[1][1] = money[1];
        
        for (int i = 2; i < n; i++) {
            dp[0][i] = Math.max(dp[0][i-1], dp[0][i-2] + money[i]);
            dp[1][i] = Math.max(dp[1][i-1], dp[1][i-2] + money[i]);
        }
             
        
        return Math.max(dp[0][n-2], dp[1][n-1]);
    }
}