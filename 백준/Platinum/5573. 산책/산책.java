import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        boolean[][] isLeft = new boolean[H][W];

        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                if (Integer.parseInt(st.nextToken()) == 1) {
                    isLeft[i][j] = true;
                }
            }
        }

        int[][] dp = new int[H+1][W+1];
        dp[0][0] = N-1;

        int half;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < W; j++) {
                half = dp[i][j] / 2;

                dp[i][j+1] += half;
                dp[i+1][j] += half;

                if (dp[i][j] % 2 == 1) {
                    if (isLeft[i][j]) dp[i][j+1] += 1;
                    else dp[i+1][j] += 1;
                    isLeft[i][j] = !isLeft[i][j];
                }
            }
        }

        System.out.println(findRoute(isLeft, H, W));
    }

    static String findRoute(boolean[][] isLeft, int H, int W) {
        int y = 0;
        int x = 0;

        while (y < H && x < W) {
            if (isLeft[y][x]) x++;
            else y++;
        }

        return String.format("%d %d", (y + 1), (x + 1));
    }
}
