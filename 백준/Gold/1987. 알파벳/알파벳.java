import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int max = 0;
    static int N, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];
        for (int row = 0; row < N; row++) {
            char[] tmp = br.readLine().toCharArray();
            for (int col = 0; col < M; col++) {
                board[row][col] = tmp[col] - 65;
            }
        }

        dfs(1, 0, 0, board, 1 << board[0][0]);

        System.out.println(max);
    }

    static void dfs(int count, int y, int x, int[][] board, int alphabetMasking) {
        max = Math.max(max, count);

        if (max == 26) return;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

            int currentAlphabet = 1 << (board[ny][nx]);
            if ((alphabetMasking & currentAlphabet) == 0) {
                dfs(count + 1, ny, nx, board, alphabetMasking | currentAlphabet);
            }
        }
    }
}
