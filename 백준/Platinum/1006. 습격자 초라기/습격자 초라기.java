import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[][] enemy;
    static int N;
    static int W;
    static final int MAX = 10000 * 2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        while (T-- > 0) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());

            enemy = new int[2][N];

            for (int i = 0; i < 2; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    enemy[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            if (N == 1) {
                sb.append(canCoverCol(0) ? 1 : 2).append("\n");
            }
            else {
                sb.append(getAnswer()).append("\n");
            }
        }
        System.out.print(sb);
    }

    private static int getAnswer() {
        int answer = scenario(1);
        boolean f1 = false;
        boolean f2 = false;

        if (canCoverRow(0, 0, N-1)) {
            f1 = true;
            answer = Math.min(answer, scenario(2));
        }
        if (canCoverRow(1, 0, N-1)) {
            f2 = true;
            answer = Math.min(answer, scenario(3));
        }
        if (f1 && f2) {
            answer = Math.min(answer, scenario(4));
        }
        return answer;
    }


    static boolean canCoverCol(int col) {
        return enemy[0][col] + enemy[1][col] <= W;
    }

    static boolean canCoverRow(int row, int c1, int c2) {
        return enemy[row][c1] + enemy[row][c2] <= W;
    }

    static int scenario (int type) {
        int[][] dp = new int[N][3];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], MAX);
        }

        dp[0][0] = (type == 1 && canCoverCol(0)) ? 1 : 2;
        dp[0][1] = 1;
        dp[0][2] = 1;

        for (int i = 1; i < N; i++) {
            dp[i][1] = dp[i-1][0] + 1;
            dp[i][2] = dp[i-1][0] + 1;

            if (canCoverRow(0, i-1, i)) {
                if (!(i == 1 && (type == 2 || type == 4))) {
                    dp[i][1] = Math.min(dp[i][1], dp[i-1][2] + 1);
                }
            }

            if (canCoverRow(1, i-1, i)) {
                if (!(i == 1 && (type == 3 || type == 4))) {
                    dp[i][2] = Math.min(dp[i][2], dp[i-1][1] + 1);
                }
            }

            dp[i][0] = Math.min(dp[i][1] + 1, dp[i][2] + 1);
            dp[i][0] = Math.min(dp[i][0], dp[i-1][0] + (canCoverCol(i) ? 1 : 2));

            if (canCoverRow(0, i-1, i) && canCoverRow(1, i-1, i)) {
                if (!(i == 1 && type != 1)) {
                    int prev = i >= 2 ? dp[i-2][0] : 0;
                    dp[i][0] = Math.min(dp[i][0], prev + 2);
                }
            }
        }

        if (type == 1) return dp[N-1][0];
        else if (type == 2) return dp[N-1][2];
        else if (type == 3) return dp[N-1][1];
        else return dp[N-2][0];
    } 
}
