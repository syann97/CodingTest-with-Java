import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str1 = " " + br.readLine();
        String str2 = " " + br.readLine();
        String answer = "";
        int N = str1.length() - 1;
        int M = str2.length() - 1;

        int[][] dp = new int[N+1][M+1];

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (str1.charAt(i) == str2.charAt(j)) dp[i][j] = dp[i - 1][j - 1] + 1;
                else dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        traceLCS(N, M, dp, str1);
    }


    static void traceLCS(int y, int x, int[][] dp, String str) {
        StringBuilder sb = new StringBuilder();
        while (y > 0 && x > 0) {
            if (dp[y][x] == dp[y][x-1]) {
                x--;
            }
            else if (dp[y][x] == dp[y-1][x]) {
                y--;
            }
            else {
                sb.append(str.charAt(y));
                x--;
                y--;
            }
        }
        System.out.println(sb.length());
        System.out.println(sb.reverse());
    }
}
