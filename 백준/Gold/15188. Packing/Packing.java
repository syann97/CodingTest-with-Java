import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;


public class Main {
	static StringTokenizer st;
	static int N;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int P = Integer.parseInt(br.readLine());

		for (int T = 1; T <= P; T++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			int W1 = Integer.parseInt(st.nextToken());
			int W2 = Integer.parseInt(st.nextToken());
			int[] w = new int[N+1];
			int[] v = new int[N+1];

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				w[i] = Integer.parseInt(st.nextToken());
			}

			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				v[i] = Integer.parseInt(st.nextToken());
			}

			if (W1 > W2) {
				int tmp = W1;
				W1 = W2;
				W2 = tmp;
			}

			int value = 0;
			
			value += knapsack(N, W1, w, v);
			value += knapsack(N, W2, w, v);

			sb.append("Problem ").append(T).append(": ").append(value).append("\n");
		}

		System.out.println(sb);
	}

	static int knapsack(int N, int W, int[] w, int[] v) {
		int[][] dp = new int[N+1][W+1];

		for (int i = 1; i <= N; i++) {
			if (v[i] <= 0 || w[i] > W) {
				System.arraycopy(dp[i - 1], 0, dp[i], 0, W+1);
				continue;
			}

			for (int j = W; j >= w[i]; j--) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-w[i]] + v[i]);
			}

            if (w[i] >= 0) System.arraycopy(dp[i - 1], 0, dp[i], 0, w[i]);
		}

		tracing(dp, W, w, v);

		return dp[N][W];
	}

	private static void tracing(int[][] dp, int W, int[] w, int[] v) {
		int index = N;

		while (index > 0 && W > 0) {
			if (dp[index][W] != dp[index-1][W]) {
				W -= w[index];
				v[index] = 0;
			}
			index--;
		}
	}
}
