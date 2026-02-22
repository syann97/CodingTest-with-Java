import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N*M+1][1<<M];
        dp[0][0] = 1;

        for (int index = 0; index < N*M; index++) {
            for (int state = 0; state < Math.pow(2, M); state++) {
                if (dp[index][state] == 0) continue;

                if ((state & 1) == 1) {
                    dp[index+1][state>>1] = (dp[index][state] + dp[index+1][state>>1]) % 9901;
                }
                else {
                    if ((index % M != M-1) && (state & 2) == 0) {
                        dp[index+1][(state>>1)|1] = (dp[index][state] + dp[index+1][(state>>1)|1]) % 9901;
                    }

                    if (index + M < N * M) {
                        dp[index+1][(state>>1)|(1<<(M-1))] = (dp[index][state] + dp[index+1][(state>>1)|(1<<(M-1))]) % 9901;
                    }
                }
            }
        }

        System.out.println(dp[N*M][0] % 9901);
    }
}