import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


class Pos {
    int y;
    int x;

    public Pos (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int[][] board = new int[R][C];

        int count = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());

                if (board[i][j] == 1) count++;
            }
        }

        System.out.println(bfs(board, R, C, count));
    }

    static String bfs(int[][] board, int r, int c, int count) {
        ArrayDeque<Pos> q = new ArrayDeque<>();
        q.offer(new Pos(0, 0));
        board[0][0] = 3;

        int hour = 0;
        ArrayDeque<Pos> tmp = new ArrayDeque<>();

        while (!q.isEmpty()) {
            hour += 1;
            tmp.clear();

            while (!q.isEmpty()) {
                Pos pos = q.poll();

                int y = pos.y;
                int x = pos.x;

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (0 <= ny && ny < r && 0 <= nx && nx < c && board[ny][nx] != 3) {
                        if (board[ny][nx] == 0) {
                            board[ny][nx] = 3;
                            q.offer(new Pos(ny, nx));
                        }
                        else if (board[ny][nx] == 1) {
                            board[ny][nx] = 2;
                            tmp.offer(new Pos(ny, nx));
                        }
                    }
                }
            }
            if (count - tmp.size() == 0) return hour + "\n" + count;

            count -= tmp.size();
            q = tmp.clone();
        }

        return hour + "\n" + count;
    }
}
