import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] area;
    static boolean[][] visited;
    static int[] dy = {1, 0};
    static int[] dx = {0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        visited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0);
        String answer = visited[N-1][M-1] ? "Yes" : "No";
        System.out.println(answer);
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;
        for(int i = 0; i < 2; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && area[ny][nx] == 1) {
                dfs(ny, nx);
            }
        }
    }
}
