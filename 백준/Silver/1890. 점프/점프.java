import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    static int[] dy = {0, 1};
    static int[] dx = {1, 0};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        long[][] dp = new long[N][N];
        int[][] board = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[0][0] = 1;

        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (board[y][x] == 0) continue;
                if (dp[y][x] != 0) {
                    int step = board[y][x];
                    for (int d = 0; d < 2; d++) {
                        int ny = y + dy[d] * step;
                        int nx = x + dx[d] * step;
                        if (0 <= ny && ny < N && 0 <= nx && nx < N) {
                            dp[ny][nx] += dp[y][x];
                        }
                    }
                }
            }
        }
        System.out.println(dp[N-1][N-1]);
    }
}
