import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static long[][] dp;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());

		init();

		while (T-- > 0) {
			st = new StringTokenizer(br.readLine());
			int n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());

			sb.append(dp[n-1][m]).append("\n");
		}
		System.out.print(sb);
	}

	static void init() {
		dp = new long[10][2001];

		for (int i = 1; i <= 2000; i++) {
			dp[0][i] = i;
		}

		for (int i = 1; i < 10; i++) {
			for (int j = 1 << i; j <= 2000; j++) {
				dp[i][j] = dp[i - 1][j / 2] + dp[i][j - 1];
			}
		}
	}
}
