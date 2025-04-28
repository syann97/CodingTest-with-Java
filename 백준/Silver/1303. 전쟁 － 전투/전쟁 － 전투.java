import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 가로
        M = Integer.parseInt(st.nextToken()); // 세로
        char[][] area = new char[M][N]; // 주의: M(세로) x N(가로)
        boolean[][] visited = new boolean[M][N];
        int white = 0;
        int black = 0;

        for (int i = 0; i < M; i++) { // M줄
            String s = br.readLine();
            for (int j = 0; j < N; j++) { // 각 줄에 N글자
                area[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    if (area[i][j] == 'W') white += (int) Math.pow(dfs(1, visited, area, i, j, 'W'), 2);
                    else black += (int) Math.pow(dfs(1, visited, area, i, j, 'B'), 2);
                }
            }
        }
        System.out.println(white + " " + black);
    }

    static int dfs(int count, boolean[][] visited, char[][] area, int y, int x, char target) {
        visited[y][x] = true;

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (0 <= ny && ny < M && 0 <= nx && nx < N && !visited[ny][nx] && area[ny][nx] == target) {
                count = dfs(count + 1, visited, area, ny, nx, target);
            }
        }
        return count;
    }
}
