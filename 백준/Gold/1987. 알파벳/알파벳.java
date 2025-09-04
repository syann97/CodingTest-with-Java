import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int max = 0;
    static int N;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            char[] row = br.readLine().toCharArray();
            for (int j = 0; j < M; j++) {
                board[i][j] = row[j];
            }
        }

        boolean[][] visited = new boolean[N][M];
        Set<Character> alphabetSet = new HashSet<>();

        visited[0][0] = true;
        alphabetSet.add(board[0][0]);

        dfs(1, 0, 0, board, visited, alphabetSet);
        System.out.println(max);
    }

    static void dfs(int count, int y, int x, char[][] board, boolean[][] visited, Set<Character> alphabetSet) {
        max = Math.max(max, count);

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (ny < 0 || ny >= N || nx < 0 || nx >= M || visited[ny][nx]) continue;
            if (alphabetSet.add(board[ny][nx])) {
                visited[ny][nx] = true;
                dfs(count + 1, ny, nx, board, visited, alphabetSet);
                visited[ny][nx] = false;
                alphabetSet.remove(board[ny][nx]);
            }
        }
    }
}