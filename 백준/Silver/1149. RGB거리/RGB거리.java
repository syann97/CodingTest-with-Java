import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        int N = Integer.parseInt(br.readLine());
        int[][] RGB = new int[N][3];
        int[][] dp = new int[N][3];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                RGB[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < 3; i++) dp[0][i] = RGB[0][i];

        for (int i = 1; i < N; i++) {
            for (int j = 0; j < 3; j++) {
                int min = Integer.MAX_VALUE;
                for (int k = 0; k < 3; k++) {
                    if (j != k) min = Math.min(min, dp[i-1][k] + RGB[i][j]);
                }
                dp[i][j] = min;
            }
        }
        int answer = Integer.MAX_VALUE;
        for (int tmp : dp[N-1]) {
            answer = Math.min(answer, tmp);
        }
        System.out.println(answer);
    }
}
