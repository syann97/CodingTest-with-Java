import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int N;
    static int M;
    static int r;
    static int c;
    static int d;
    static int[][] area;
    static int[] dr = {-1, 0, 1, 0};
    static int[] dc = {0, 1, 0, -1};
    static int count = 0;

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        d = Integer.parseInt(st.nextToken());

        area = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            clean();
            if(isMoving()) continue;
            if(!isBackMoving()) break;
        }
        System.out.println(count);
    }

    static void clean() {
        if (area[r][c] == 0) {
            area[r][c] = 2;
            count++;
        }
    }

    static boolean isMoving() {
        for (int i = 3; i >= 0; i--) {
            int nd = (i + d) % 4;
            int nr = r + dr[nd];
            int nc = c + dc[nd];
            if (0 <= nr && nr < N && 0 <= nc && nc < M && area[nr][nc] == 0) {
                r = nr;
                c = nc;
                d = nd;
                return true;
            }
        }
        return false;
    }

    static boolean isBackMoving() {
        int nd = (d + 2) % 4;
        int nr = r + dr[nd];
        int nc = c + dc[nd];
        if (0 <= nr && nr < N && 0 <= nc && nc < M && area[nr][nc] != 1) {
            r = nr;
            c = nc;
            return true;
        }
        return false;
    }
}
