import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final int DIV = 1000000007;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		System.out.println(dynamicProgramming(N, K));
	}

	private static int dynamicProgramming(int N, int K) {
		int ck = Math.max(K, 1);
		int[][][] dp = new int[3][ck][2];
		
		if (K > 0) {
			dp[0][1 % K][0] = 1;
		}
		dp[1][0][0] = 1;
		dp[2][0][1] = 1;

		for (int i = 0; i < N - 1; i++) {
			int[][][] toggle = new int[3][ck][2];
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < ck; k++) {
					for (int l = 0; l < 2; l++) {
						if (dp[j][k][l] == 0) continue;
						
						if (K > 0) {
							int nk = (k + 1) % K;
							toggle[0][nk][l] = (toggle[0][nk][l] + dp[j][k][l]) % DIV;
						}
						
						if (j != 1) {
							toggle[1][k][l] = (toggle[1][k][l] + dp[j][k][l]) % DIV;
						}
						
						toggle[2][k][1] = (toggle[2][k][1] + dp[j][k][l]) % DIV;
					}
				}
			}
			dp = toggle;
		}

		int answer = 0;
		for (int j = 0; j < 3; j++) {
			answer = (answer + dp[j][0][1]) % DIV;
		}

		return answer;
	}
}
