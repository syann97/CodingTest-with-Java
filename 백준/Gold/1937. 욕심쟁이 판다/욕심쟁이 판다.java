import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringTokenizer st;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] forest = new int[N][N];
        int[][] dp = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                forest[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int ans = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                ans = Math.max(ans, dfs(i, j, forest, dp, N));
            }
        }

        System.out.println(ans);
    }

    static int dfs(int y, int x, int[][] forest, int[][] dp, int n) {

        if (dp[y][x] != 0) return dp[y][x];

        dp[y][x] = 1;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || ny >= n || nx < 0 || nx >= n) continue;

            if (forest[y][x] < forest[ny][nx]) {
                dp[y][x] = Math.max(dp[y][x], dfs(ny, nx, forest, dp, n) + 1);
            }
        }

        return dp[y][x];
    }
}
