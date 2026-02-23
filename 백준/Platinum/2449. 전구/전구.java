import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static final int MAX = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        ArrayList<Integer> temp = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        int color;
        int lastColor = -1;
        for (int i = 0; i < N; i++) {
            color = Integer.parseInt(st.nextToken());
            if (color != lastColor) {
                lastColor = color;
                temp.add(color);
            }
        }

        int L = temp.size();
        int[] compact = new int[L];
        for (int i = 0; i < L; i++) {
            compact[i] = temp.get(i);
        }
        temp = null;

        int[][] dp = new int[L][L];

        for (int i = 0; i < L; i++) {
            Arrays.fill(dp[i], MAX);
        }

        int tmp;
        for (int end = 0; end < L; end++) {
            dp[end][end] = 0;
            for (int start = end - 1; start >= 0; start--) {
                for (int mid = start; mid < end; mid++) {
                    tmp = dp[start][mid] + dp[mid+1][end];
                    if (compact[start] != compact[mid+1]) tmp += 1;
                    dp[start][end] = Math.min(dp[start][end], tmp);
                }
            }
        }
        System.out.println(dp[0][L-1]);
    }
}
