import java.util.*;

class Solution {
    static final int MOD = 1000000007;
    public int solution(int n) {
        int[][] dp = new int[n*3+1][1<<4];
        dp[0][0] = 1;
        
        for (int index = 0; index < n * 3; index++) {
            for (int state = 0; state < (1<<4); state++) {
                if (dp[index][state] == 0) continue;
                
                if ((state & 1) != 0) {
                    int nextState = state >> 1;
                    dp[index + 1][nextState] = (dp[index + 1][nextState] + dp[index][state]) % MOD;
                }
                else {
                    if (index % 3 < 2 && (state & (1 << 1)) == 0) {
                        int nextState = (state >> 1) | (1 << 0);
                        dp[index+1][nextState] = (dp[index+1][nextState] + dp[index][state]) % MOD;
                    }

                    if (index < n * 3 - 3) {
                        int nextState = (state >> 1) | (1 << 2);
                        dp[index+1][nextState] = (dp[index+1][nextState] + dp[index][state]) % MOD;
                    }
                }
            }
        }
        return dp[n*3][0];
    }
}