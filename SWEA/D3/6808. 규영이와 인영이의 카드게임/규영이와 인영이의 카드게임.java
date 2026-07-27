import java.io.*;
import java.util.*;


public class Solution {
	static final int N = 9;
	static final int TOTAL_CASES = 362880;
	static StringTokenizer st;
	static int[] cases = {1, 1, 2, 6, 24, 120, 720};
	static int[][] dp = new int[121][1<<N];
	static int[] cards = new int[N];
	static int[] restCards = new int[N];
	static boolean[] isUsed = new boolean[19];
	
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			Arrays.fill(isUsed, false);
			for (int i = 0; i < N; i++) {
				cards[i] = Integer.parseInt(st.nextToken());
				isUsed[cards[i]] = true;
			}
			
			int index = 0;
			for (int i = 1; i <= 18; i++) {
				if (isUsed[i]) continue;
				restCards[index++] = i;
			}
			
			for (int i = 0; i < 121; i++) {
				Arrays.fill(dp[i], -1);
			}
			
			dfs(0, N, 0, 0);
			
			sb.append("#").append(t).append(" ").append(dp[0][0]).append(" ").append(TOTAL_CASES - dp[0][0]).append("\n");
		}
		System.out.println(sb);
	}
	
	static int dfs(int status, int rest, int scoreA, int scoreB) {
		if (dp[scoreA][status] != -1) return dp[scoreA][status];
		if (scoreA > 85) return dp[scoreA][status] = cases[rest];
		else if (scoreB > 85) return dp[scoreA][status] = 0;
		
		int count = 0;
		int currentCard = cards[rest-1];
		
		for (int i = 0; i < N; i++) {
	        if ((status & (1 << i)) != 0) {
	            continue;
	        }

	        int next = status | (1 << i);
	        int sum = currentCard + restCards[i];

	        if (currentCard > restCards[i]) {
	            count += dfs(next, rest - 1, scoreA + sum, scoreB);
	        } else {
	            count += dfs(next, rest - 1, scoreA, scoreB + sum);
	        }
	    }
		
		return dp[scoreA][status] = count;
	}
}
