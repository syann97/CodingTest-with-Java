import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] V = new int[N];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            V[i] = Integer.parseInt(st.nextToken());
        }

        boolean[] dp = new boolean[M+1];
        boolean isPossible = false;
        dp[S] = true;

        for (int i = 0; i < N; i++) {
            boolean[] tmp = new boolean[M+1];
            isPossible = false;

            for (int j = 0; j <= M; j++) {
                if (dp[j]) {
                    if (0 <= j - V[i] && j - V[i] <= M) {
                        tmp[j - V[i]] = true;
                        isPossible = true;
                    }
                    if (0 <= j + V[i] && j + V[i] <= M) {
                        tmp[j + V[i]] = true;
                        isPossible = true;
                    }
                }
            }

            System.arraycopy(tmp, 0, dp, 0, M+1);
            if (!isPossible) break;
        }

        if (!isPossible) System.out.println(-1);
        else {
            for (int i = M; i >= 0; i--) {
                if (dp[i]) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}