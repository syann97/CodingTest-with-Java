import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[2][1<<M];
        dp[0][0] = 1;

        int before = 0;
        int current = 1;
        for (int index = 0; index < N*M-1; index++) {
            Arrays.fill(dp[current], 0);

            for (int state = (1<<M) - 1; state >= 0; state--) {
                if (dp[before][state] == 0) continue;

                if ((state & 1) == 1) {
                    dp[current][state>>1] = (dp[current][state>>1] + dp[before][state]) % 9901;
                }
                else {
                    if ((index % M != M-1) && (state & 2) == 0) {
                        dp[current][(state>>1)|1] = (dp[current][(state>>1)|1] + dp[before][state]) % 9901;
                    }

                    if (index+M < M*N) {
                        dp[current][(state>>1)|(1<<(M-1))] = (dp[current][(state>>1)|(1<<(M-1))] + dp[before][state]) % 9901;
                    }
                }
            }
            before ^= 1;
            current ^= 1;
        }

        System.out.println(dp[before][1]);
    }
}