import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

class Node {
    int x;
    int y;

    public Node (int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class Main {
    // static 변수 정의
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int[][] area;
    static boolean[][] isMelt;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        area = new int[N][M];
        isMelt = new boolean[N][M];


        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
                if (area[i][j] == 0) {
                    isMelt[i][j] = true;
                }
            }
        }

        int days = 0;
        while (counting() <= 1) {
            melt();
            days++;
            if (isAllMelted()) {
                days = 0;
                break;
            }
        }
        System.out.println(days);
    }

    static int counting() {
        int count = 0;
        boolean[][] visited = new boolean[N][M];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] > 0 && !visited[i][j]) {
                    bfs(i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }

    static void bfs(int sy, int sx, boolean[][] visited) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        q.offer(new Node(sx, sy));
        visited[sy][sx] = true;

        while (!q.isEmpty()) {
            Node node = q.poll();
            int x = node.x;
            int y = node.y;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && area[ny][nx] > 0) {
                    visited[ny][nx] = true;
                    q.offer(new Node(nx, ny));
                }
            }
        }
    }

    static void melt () {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                int cnt = calMelt(i, j);
                if (cnt > area[i][j]) area[i][j] = 0;
                else area[i][j] -= cnt;
            }
        }
        // update
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == 0) isMelt[i][j] = true;
            }
        }
    }

    static int calMelt(int y, int x) {
        int count = 0;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];
            if (0 <= ny && ny < N &&  0 <= nx && nx < M && isMelt[ny][nx]) {
                count++;
            }
        }
        return count;
    }

    static boolean isAllMelted() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] != 0) return false;
            }
        }
        return true;
    }

}
