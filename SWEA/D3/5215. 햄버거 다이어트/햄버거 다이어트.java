import java.util.*;
import java.io.*;

class Solution {
	static StringTokenizer st;
	static int[] parent;
	static int N;
	static int K;
	public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        
        int test = Integer.parseInt(br.readLine());

        for (int t = 1; t <= test; t++) {
        	st = new StringTokenizer(br.readLine());
        	int N = Integer.parseInt(st.nextToken());
        	int L = Integer.parseInt(st.nextToken());
        	int[] dp = new int[L+1];
        	
        	for (int i = 0; i < N; i++) {
        		st = new StringTokenizer(br.readLine());
        		int T = Integer.parseInt(st.nextToken());
        		int K = Integer.parseInt(st.nextToken());
        		
        		for (int j = L; j >= K; j--) {
        			dp[j] = Math.max(dp[j], dp[j-K] + T);
        		}
        	}
        	
        	sb.append("#").append(t).append(" ").append(dp[L]).append("\n");
        }
        System.out.print(sb);
    }
}