import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Solution {
    static StringTokenizer st;
    static int answer;
    static int N;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            N = Integer.parseInt(br.readLine());
            int[] X = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                X[i] = Integer.parseInt(st.nextToken());
            }

            answer = Integer.MAX_VALUE;
            bf(0, 0, X , false);
            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }

    static void bf(int pos, int dist, int[] X, boolean removeFlag) {
        if (pos + 1 == N) {
            if (removeFlag) {
                answer = Math.min(answer, dist);
            }
            return;
        }

        if (dist >= answer) return;

        bf(pos+1, dist+Math.abs(X[pos] - X[pos+1]), X, removeFlag);
        if (!removeFlag && pos + 2 < N) {
            bf(pos+2, dist+Math.abs(X[pos] - X[pos+2]), X, true);
        }
    }
}