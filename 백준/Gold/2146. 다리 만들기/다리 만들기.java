import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.StringTokenizer;

class Bridge {
    int y;
    int x;

    public Bridge(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int N;
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] country = new int[N][N];
        int[][] visited = new int[N][N];
        ArrayDeque<Bridge> q = new ArrayDeque<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            Arrays.fill(visited[i], -1);
            for (int j = 0; j < N; j++) {
                country[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int landNum = 2;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (country[i][j] == 1 && visited[i][j] == -1) {
                    dfs(country, visited, q, i, j, landNum);
                    landNum++;
                }
            }
        }
        System.out.println(bfs(country, visited, q));
    }

    static void dfs(int[][] country, int[][] visited, ArrayDeque<Bridge> q, int y, int x, int landNum) {
        visited[y][x] = 0;
        country[y][x] = landNum;
        q.offer(new Bridge(y, x));

        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (0 <= ny && ny < N && 0<= nx && nx < N && country[ny][nx] == 1 && visited[ny][nx] == -1) {
                visited[ny][nx] = 0;
                dfs(country, visited, q, ny, nx, landNum);
            }
        }
    }

    static int bfs(int[][] country, int[][] visited, ArrayDeque<Bridge> q) {
        int min = Integer.MAX_VALUE;
        while (!q.isEmpty()) {
            int size = q.size();

            while (size --> 0) {
                Bridge bridge = q.poll();
                int y = bridge.y;
                int x = bridge.x;

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (0 <= ny && ny < N && 0 <= nx && nx < N && country[y][x] != country[ny][nx]) {
                        if (country[ny][nx] != 0) {
                            min = Math.min(min, visited[y][x] + visited[ny][nx]);
                        }
                        else {
                            country[ny][nx] = country[y][x];
                            visited[ny][nx] = visited[y][x] + 1;
                            q.offer(new Bridge(ny, nx));
                        }
                    }
                }
            }
            if (min != Integer.MAX_VALUE) return min;
        }
        return -1;
    }
}