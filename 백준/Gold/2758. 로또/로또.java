import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        while (T --> 0) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            if (Math.pow(2, n-1) > m) System.out.println(0);
            else {
                long[][] dp = new long[n][m+1];
                Arrays.fill(dp[0], 1);


                for (int i = 1; i < n; i++) {
                    for (int j = 1; j <= m; j++) {
                        if (dp[i-1][j] != 0) {
                            for (int k = j * 2; k <= m; k++) {
                                dp[i][k] += dp[i-1][j];
                            }
                        }
                    }
                }

                long answer = 0;
                for (int j = (int)Math.pow(2, n-1); j <=m; j++) {
                    answer += dp[n-1][j];
                }
                System.out.println(answer);
            }
        }
    }
}
