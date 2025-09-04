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

        char[][] board = new char[N][M];
        for (int i = 0; i < N; i++) {
            board[i] = br.readLine().toCharArray();
        }

        dfs(1, 0, 0, board, 1 << (board[0][0] - 65));

        System.out.println(max);
    }

    static void dfs(int count, int y, int x, char[][] board, int alphabetMasking) {
        max = Math.max(max, count);

        if (max == 26) return;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M) continue;

            int currentAlphabet = 1 << (board[ny][nx] - 'A');
            if ((alphabetMasking & currentAlphabet) == 0) {
                dfs(count + 1, ny, nx, board, alphabetMasking | currentAlphabet);
            }
        }
    }
}
