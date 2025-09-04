import java.io.*;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int max = 0;
    static int N, M;
    static int[][] board;
    static int[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        board = new int[N + 2][M + 2];
        visited = new int[N + 2][M + 2];

        for (int row = 1; row <= N; row++) {
            char[] tmp = br.readLine().toCharArray();
            for (int col = 1; col <= M; col++) {
                board[row][col] = tmp[col - 1] - 64;
            }
        }

        dfs(1, 1, 1, 1 << board[1][1]);
        System.out.println(max);
    }

    static void dfs(int count, int y, int x, int alphabetMasking) {
        max = Math.max(max, count);
        if (max == 26) return;
        
        visited[y][x] = alphabetMasking;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (board[ny][nx] == 0) continue;
            if ((alphabetMasking | (1 << board[ny][nx])) == visited[ny][nx]) continue;

            int currentAlphabet = 1 << board[ny][nx];
            if ((alphabetMasking & currentAlphabet) == 0) {
                dfs(count + 1, ny, nx, alphabetMasking | currentAlphabet);
            }
        }
    }
}