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
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            int cnt = countingDiv();
            if (cnt == 1) days++;
            else {
                if (cnt == 0) days = 0;
                break;
            }
        }
        System.out.println(days);
    }

    static int countingDiv() {
        int count = 0;
        visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] > 0 && !visited[i][j]) {
                    dfs(i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int y, int x) {
        visited[y][x] = true;

        for(int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx]) {
                if(area[ny][nx] == 0) {
                    if(area[y][x] > 0) {
                        area[y][x]--;
                    }
                }

                if(area[ny][nx] > 0) {
                    dfs(ny, nx);
                }
            }
        }
    }
}
