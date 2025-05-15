import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int N;
    static int M;
    static int sy;
    static int sx;
    static int min = 2500;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] board = new char[N][M];

        for (int i = 0; i < N; i++) {
            String tmp = br.readLine();
            for (int j = 0; j < M; j++) {
                board[i][j] = tmp.charAt(j);
            }
        }

        for (int i = 0; i <= N - 8; i++) {
            for (int j = 0; j <= M - 8; j++) {
                sy = i;
                sx = j;
                bf(i, j, board, 0, 0);
            }
        }

        System.out.println(min);
    }


    static void bf(int y, int x, char[][] board, int startBlack, int startWhite) {
        if (y == sy + 8) {
            min = Math.min(min, Math.min(startBlack, startWhite));
            return;
        }

        int ny = x + 1 == sx + 8 ? y + 1 : y;
        int nx = x + 1 == sx + 8 ? sx : x + 1;

        if ((y + x) % 2 == 0) {
            if (board[y][x] == 'B') startWhite++;
            else startBlack++;
        }
        else {
            if (board[y][x] == 'B') startBlack++;
            else startWhite++;
        }

        bf(ny, nx, board, startBlack, startWhite);
    }
}
