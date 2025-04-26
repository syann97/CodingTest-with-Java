import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Beads {
    int ry;
    int rx;
    int by;
    int bx;
    int count;

    public Beads() {}
    public Beads(int ry, int rx, int by, int bx, int count) {
        this.ry = ry;
        this.rx = rx;
        this.by = by;
        this.bx = bx;
        this.count = count;
    }
}

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];
        boolean[][][][] visited = new boolean[N][M][N][M];
        Beads beads = new Beads();
        beads.count = 0;
        int ex = 0;
        int ey = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < M; j++) {
                char c = s.charAt(j);
                if (c == 'B') {
                    beads.by = i;
                    beads.bx = j;
                }
                else if (c == 'R') {
                    beads.ry = i;
                    beads.rx = j;
                }
                else if (c == 'O') {
                    ey = i;
                    ex = j;
                }
                board[i][j] = c;
            }
        }
        System.out.println(bfs(board, visited, ey, ex, beads));
    }
    static int bfs(char[][] board, boolean[][][][] visited, int ey, int ex, Beads init) {
        ArrayDeque<Beads> q = new ArrayDeque<>();
        q.offer(init);
        visited[init.ry][init.rx][init.by][init.bx] = true;


        while(!q.isEmpty()) {
            Beads beads = q.poll();

            if (beads.count == 10) return 0;

            for (int d = 0; d < 4; d++) {
                int nry = beads.ry;
                int nrx = beads.rx;
                int nby = beads.by;
                int nbx = beads.bx;

                boolean redFlag = false;
                boolean blueFlag = false;

                while(board[nry + dy[d]][nrx + dx[d]] != '#') {
                    nry += dy[d];
                    nrx += dx[d];

                    if (nry == ey && nrx == ex) {
                        redFlag = true;
                        break;
                    }
                }

                while(board[nby + dy[d]][nbx + dx[d]] != '#') {
                    nby += dy[d];
                    nbx += dx[d];

                    if (nby == ey && nbx == ex) {
                        blueFlag = true;
                        break;
                    }
                }

                if (blueFlag) continue;
                if (redFlag) return 1;

                if (nry == nby && nrx == nbx) {
                    // 위로 기울일 때
                    if (d == 0) {
                        // 빨간 구슬이 위에 있을 경우
                        if (beads.ry < beads.by) nby -= dy[d];
                        else nry -= dy[d];
                    }
                    // 아래로 기울일 때
                    else if (d == 1) {
                        // 빨간 구슬이 아래 있는 경우
                        if (beads.ry > beads.by) nby -= dy[d];
                        else nry -= dy[d];
                    }
                    // 왼쪽으로 기울일 때
                    else if(d == 2) {
                        // 빨간 구슬이 왼쪽에 있는 경우
                        if (beads.rx < beads.bx) nbx -= dx[d];
                        else nrx -= dx[d];
                    }
                    else {
                        if (beads.rx > beads.bx) nbx -= dx[d];
                        else nrx -= dx[d];
                    }
                }
                if (!visited[nry][nrx][nby][nbx]) {
                    visited[nry][nrx][nby][nbx] = true;
                    q.offer(new Beads(nry, nrx, nby, nbx, beads.count + 1));
                }
            }
        }
        return 0;
    }
}