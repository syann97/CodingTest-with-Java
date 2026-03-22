import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Shark {
    int s;
    int d;
    int z;

    public Shark (int s, int d, int z) {
        this.s = s;
        this.d = d;
        this.z = z;
    }
}

public class Main {
    static StringTokenizer st;
    static int totalSize = 0;
    static int R, C, M;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, 1, -1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        Shark[][] grid = new Shark[R][C];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            grid[r-1][c-1] = new Shark(s, d, z);
        }

        for (int t = 0; t < C; t++) {
            fishing(t, grid);
            grid = move(grid);
        }

        System.out.println(totalSize);
    }

    static Shark[][] move(Shark[][] grid) {
        Shark[][] nextGrid = new Shark[R][C];

        for (int r = 0; r < R; r++) {
            for (int c = 0; c < C; c++) {
                if (grid[r][c] == null) continue;

                Shark cur = grid[r][c];
                
                int mod = (cur.d < 2) ? (R - 1) * 2 : (C - 1) * 2;
                int moveDist = cur.s;
                if (mod > 0) moveDist %= mod;

                int nr = r;
                int nc = c;

                for (int i = 0; i < moveDist; i++) {
                    int tr = nr + dy[cur.d];
                    int tc = nc + dx[cur.d];

                    if (tr < 0 || tr >= R || tc < 0 || tc >= C) {
                        cur.d = (cur.d % 2 == 0) ? cur.d + 1 : cur.d - 1;
                        nr += dy[cur.d];
                        nc += dx[cur.d];
                    } else {
                        nr = tr;
                        nc = tc;
                    }
                }
                
                if (nextGrid[nr][nc] == null || nextGrid[nr][nc].z < cur.z) {
                    nextGrid[nr][nc] = cur;
                }
            }
        }
        return nextGrid;
    }

    static void fishing(int col, Shark[][] grid) {
        for (int row = 0; row < R; row++) {
            if (grid[row][col] != null) {
                totalSize += grid[row][col].z;
                grid[row][col] = null;
                return;
            }
        }
    }
}
