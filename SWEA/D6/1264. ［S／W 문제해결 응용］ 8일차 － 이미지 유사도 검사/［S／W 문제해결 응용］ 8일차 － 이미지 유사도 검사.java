import java.util.*;
import java.io.*;

class Solution {
	public static void main(String args[]) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for(int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine().trim());
            String s1 = " " + br.readLine().trim();
			String s2 = " " + br.readLine().trim();
            
            char[] c1 = s1.toCharArray();
            char[] c2 = s2.toCharArray();

            int[][] dp = new int[2][N + 1];

            for (int i = 1; i <= N; i++) {
                int current = (i - 1) % 2;
                int next = i % 2;

                for (int j = 1; j <= N; j++) {
                    if (c1[i] == c2[j]) {
                        dp[next][j] = dp[current][j - 1] + 1;
                    } else {
                        dp[next][j] = Math.max(dp[next][j - 1], dp[current][j]);
                    }
                }
            }
            double score = (double) dp[N % 2][N] / N * 100;

            sb.append("#").append(t).append(" ");
            sb.append(String.format("%.2f", score)).append("\n");
		}
        
        System.out.print(sb);
	}
}