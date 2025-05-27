import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static final int INF = 10000;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] space = new int[N][M];
        int[][][] dp = new int [3][N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                space[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int k = 0; k < 3; k++) {
            for (int i = 0; i < N; i++) {
                Arrays.fill(dp[k][i], INF);
            }
        }

        for (int i = 0; i < 3; i++) {
            dp[i][0] = Arrays.copyOf(space[0], M);
        }


        for (int i = 1; i < N; i++) {
            for (int j = 0; j < M; j++) {
                // 각 방향에 대한 for
                // 0 : 좌, 1 : 중 2 : 우
                for (int k = 0; k < 3; k++) {
                    // 왼쪽에서 온 k만 가져오기
                    if (k == 0) {
                        if (j > 0) {
                            dp[0][i][j] = Math.min(dp[0][i][j], dp[1][i-1][j-1] + space[i][j]);
                            dp[0][i][j] = Math.min(dp[0][i][j], dp[2][i-1][j-1] + space[i][j]);
                        }
                    }
                    // 중앙에서 온 k만 가져오기
                    else if (k == 1) {
                        dp[1][i][j] = Math.min(dp[1][i][j], dp[0][i-1][j] + space[i][j]);
                        dp[1][i][j] = Math.min(dp[1][i][j], dp[2][i-1][j] + space[i][j]);
                    }
                    // 오른쪽에서 온 k만 가져오기
                    else {
                        if (j < M-1) {
                            dp[2][i][j] = Math.min(dp[2][i][j], dp[0][i-1][j+1] + space[i][j]);
                            dp[2][i][j] = Math.min(dp[2][i][j], dp[1][i-1][j+1] + space[i][j]);
                        }
                    }
                }
            }
        }

        int min = INF;
        for (int d = 0; d < 3; d++) {
            for (int num : dp[d][N-1]) {
                min = Math.min(min, num);
            }
        }

        System.out.println(min);
    }
}
