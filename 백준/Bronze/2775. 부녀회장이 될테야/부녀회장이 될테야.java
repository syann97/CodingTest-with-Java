import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());
        int[][] dp = new int[15][15];
        for (int col = 1; col <= 14; col++) dp[0][col] = col;

        for (int row = 1; row <= 14; row++) {
            for (int  col = 1; col <= 14; col++) {
                dp[row][col] += dp[row-1][col] + dp[row][col-1];
            }
        }

        while (K --> 0) {
            int k = Integer.parseInt(br.readLine());
            int n = Integer.parseInt(br.readLine());
            System.out.println(dp[k][n]);
        }
    }
}
