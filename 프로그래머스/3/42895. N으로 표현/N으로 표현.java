import java.util.*;

class Solution {
    static final int MAX = 1000000;
    public int solution(int N, int number) {
        return bfs(N, number);
    }
    
    static int bfs(int N, int number) {
        Set<Integer>[] dp = new HashSet[9];
        for (int i = 1; i <= 8; i++) {
            dp[i] = new HashSet<>();
        }
        
        int tmp = N;
        int count = 1;
        while (count <= 8) {
            dp[count++].add(tmp);
            tmp = (tmp * 10) + N;
        }
        
        for (int i = 1; i <= 8; i++) {
            for (int j = 1; j < i; j++) {
                for (int num1 : dp[j]) {
                    for (int num2 : dp[i-j]) {
                        if (num1 != 0 && num2 != 0) dp[i].add(num1/num2);
                        dp[i].add(num1*num2);
                        dp[i].add(num1+num2);
                        dp[i].add(num1-num2);
                    }
                }
            }
        }
        
        for (int i = 1; i <= 8; i++) {
            if (dp[i].contains(number)) return i;
        }
        
        return -1;
    }
}