import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static final int INF = Integer.MAX_VALUE;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		int M = 1 << N;
		int[][] cost = new int[N][N];
		int[][] dp = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			Arrays.fill(dp[i], INF);
			for (int j = 0; j < N; j++) {
				cost[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int k = 0; k < N; k++) {
			dp[0][1<<k] = cost[0][k];
		}


		for (int i = 0; i < N-1; i++) {
			for (int j = 0; j < M; j++) {
				if (dp[i][j] == INF) continue;

				for (int k = 0; k < N; k++) {
					if ((j & (1<<k)) == 0) {
						dp[i+1][j|(1<<k)] = Math.min(dp[i+1][j|(1<<k)], dp[i][j] + cost[i+1][k]);
					}
				}
			}
		}

		System.out.println(dp[N-1][(1<<N)-1]);
	}
}
