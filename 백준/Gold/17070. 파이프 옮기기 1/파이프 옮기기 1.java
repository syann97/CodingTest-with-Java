import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    static int[][] directions = {{0, 1, 2}, {0, 1}, {0, 2}};
    static int[] dy = {1, 0, 1};
    static int[] dx = {1, 1, 0};
    static int[][] checks = {{0, 1, 2}, {1}, {2}};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] area = new int[N][N];
        int[][][] dp = new int[3][N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dp[1][0][1] = 1;

        for(int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                // diagonal : 0, horizontal : 1, vertical : 2;
                for (int d = 0; d < 3; d++) {
                    if(dp[d][y][x] == 0) continue;
                    for (int nd : directions[d]) {
                        boolean isPossible = true;

                        for (int cd : checks[nd]) {
                            int checkY = y + dy[cd];
                            int checkX = x + dx[cd];
                            if (checkY < 0 || checkY >= N || checkX < 0 || checkX >= N || area[checkY][checkX] == 1) {
                                isPossible = false;
                                break;
                            }
                        }
                        if (isPossible) dp[nd][y+dy[nd]][x+dx[nd]] += dp[d][y][x];
                    }
                }
            }
        }
        System.out.println(dp[0][N-1][N-1] + dp[1][N-1][N-1] + dp[2][N-1][N-1]);
    }
}
