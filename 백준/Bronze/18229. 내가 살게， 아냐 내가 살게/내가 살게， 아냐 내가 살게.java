import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] stretchOffset = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                stretchOffset[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(solution(stretchOffset, N, M, K));
    }

    private static String solution(int[][] stretchOffset, int n, int m, int k) {
        int[] total = new int[n];

        for (int turn = 0; turn < m; turn++) {
            for (int num = 0; num < n; num++) {
                total[num] += stretchOffset[num][turn];
                if (total[num] >= k) {
                    return ((num + 1) + " " + (turn + 1));
                }
            }
        }
        return " ";
    }
}
