import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


class Node {
    int y;
    int x;

    public Node (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static final int N = 12;
    static final int M = 6;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] field = new char[N][M];

        for (int i = 0; i < N; i++) {
            field[i] = br.readLine().toCharArray();
        }

        int count = 0;
        while (chain(field)) {
            count++;
        }

        System.out.println(count);
    }

    private static boolean chain(char[][] field) {
        boolean[][] visited = new boolean[N][M];

        boolean flag = false;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (field[i][j] != '.' && !visited[i][j] && bfs(field, visited, i, j, field[i][j])) {
                    flag = true;
                }
            }
        }

        if (flag) {
            down(field);
            return true;
        }

        return false;
    }

    static boolean bfs (char[][] field, boolean[][] visited, int sy, int sx, char target) {
        ArrayDeque<Node> q = new ArrayDeque<>();
        ArrayDeque<Node> fill = new ArrayDeque<>();
        q.offer(new Node(sy, sx));
        fill.offer(new Node(sy, sx));
        visited[sy][sx] = true;

        Node node;
        while (!q.isEmpty()) {
            node = q.poll();
            int y = node.y;
            int x = node.x;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (0 <= ny && ny < N && 0 <= nx && nx < M && !visited[ny][nx] && field[ny][nx] == target) {
                    visited[ny][nx] = true;
                    q.offer(new Node(ny, nx));
                    fill.offer(new Node(ny, nx));
                }
            }
        }

        if (fill.size() < 4) return false;

        while (!fill.isEmpty()) {
            node = fill.poll();
            field[node.y][node.x] = '.';
        }

        return true;
    }

    static void down(char[][] field) {
        for (int col = 0; col < M; col++) {
            int bottom = 11;
            while (bottom >= 0 && field[bottom][col] != '.') {
                bottom--;
            }
            for (int i = bottom-1; i >= 0; i--) {
                if (field[i][col] != '.') {
                    field[bottom][col] = field[i][col];
                    field[i][col] = '.';
                    bottom--;
                }
            }
        }
    }
}
