import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


class Dust {
    int y;
    int x;

    public Dust (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static StringTokenizer st;


    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int[][] room = new int[R][C];

        int y = 0;
        int x = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++) {
                room[i][j] = Integer.parseInt(st.nextToken());

                if (room[i][j] == -1) {
                    y = i;
                    x = j;
                }
            }
        }

        System.out.println(getAnswer(R, C, T, room, y, x));
    }

    static int getAnswer(int R, int C, int T, int[][] current, int clean_y, int clean_x) {
        ArrayDeque<Dust> q = new ArrayDeque<>();
        int[][] next = new int[R][C];
        arrayCopy(current, next, R, C);

        while (T > 0) {
            findSpreadableDust(current, R, C, q);

            spread(q, current, next, R, C);

            clean(next, R, C, clean_y, clean_x);

            arrayCopy(next, current, R, C);

            T--;
        }

        int answer = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (next[i][j] > 0) answer += next[i][j];
            }
        }

        return answer;
    }

    private static void findSpreadableDust(int[][] room, int r, int c, ArrayDeque<Dust> q) {
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                if (room[i][j] >= 5) q.offer(new Dust(i, j));
            }
        }
    }

    private static void clean(int[][] next, int r, int c, int clean_y, int clean_x) {
        cw(next, r, c, clean_y, clean_x);
        ccw(next, c, clean_y-1, clean_x);
    }

    private static void cw(int[][] room, int r, int c, int sy, int sx) {
        int pushValue = 0;
        int tmp;
        for (int j = sx+1; j < c; j++) {
            tmp = room[sy][j];
            room[sy][j] = pushValue;
            pushValue = tmp;
        }

        for (int i = sy+1; i < r; i++) {
            tmp = room[i][c-1];
            room[i][c-1] = pushValue;
            pushValue = tmp;
        }

        for (int j = c-2; j >= 0; j--) {
            tmp = room[r-1][j];
            room[r-1][j] = pushValue;
            pushValue = tmp;
        }

        for (int i = r-2; i > sy; i--) {
            tmp = room[i][0];
            room[i][0] = pushValue;
            pushValue = tmp;
        }
    }

    private static void ccw(int[][] room, int c, int sy, int sx) {
        int pushValue = 0;
        int tmp;
        for (int j = sx+1; j < c; j++) {
            tmp = room[sy][j];
            room[sy][j] = pushValue;
            pushValue = tmp;
        }

        for (int i = sy-1; i >= 0; i--) {
            tmp = room[i][c-1];
            room[i][c-1] = pushValue;
            pushValue = tmp;
        }

        for (int j = c-2; j >= 0; j--) {
            tmp = room[0][j];
            room[0][j] = pushValue;
            pushValue = tmp;
        }

        for (int i = 1; i < sy; i++) {
            tmp = room[i][0];
            room[i][0] = pushValue;
            pushValue = tmp;
        }
    }

    private static void arrayCopy(int[][] target, int[][] copy, int R, int C) {
        for (int i = 0; i < R; i++) {
            System.arraycopy(target[i], 0, copy[i], 0, C);
        }
    }


    private static void spread(ArrayDeque<Dust> q, int[][] current, int[][] next, int R, int C) {
        while (!q.isEmpty()) {
            Dust dust = q.poll();
            int y = dust.y;
            int x = dust.x;
            int spreadAmount = current[y][x] / 5;

            for (int d = 0; d <4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (0 <= ny && ny < R && 0 <= nx && nx < C && current[ny][nx] != -1) {
                    next[ny][nx] += spreadAmount;
                    next[y][x] -= spreadAmount;
                }
            }
        }
    }

}
