import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] board = new char[N][N];

        for (int i = 0; i < N; i++) {
            char[] line = br.readLine().toCharArray();
            for (int j = 0; j < N; j++) {
                board[i][j] = line[j];
            }
        }

        int max = 1;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                max = Math.max(max, check(y, x, board));
                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (0 <= ny && ny < N && 0 <= nx && nx < N && board[y][x] != board[ny][nx]) {
                        char tmp = board[y][x];
                        board[y][x] = board[ny][nx];
                        board[ny][nx] = tmp;

                        max = Math.max(max, check(y, x, board));
                        if (d == 0 || d == 2) max = Math.max(max, check(ny, x, board));
                        else max = Math.max(max, check(y, nx, board));

                        board[ny][nx] = board[y][x];
                        board[y][x] = tmp;
                    }
                }
            }
        }
        System.out.println(max);
    }

    static int check(int y, int x, char[][] board) {
        char currentX = board[y][0];
        char currentY = board[0][x];

        int max = 1;
        int countX = 1;
        int countY = 1;
        for (int i = 1; i < N; i++) {
            if (currentX == board[y][i]) {
                countX++;
            }
            else {
                currentX = board[y][i];
                max = Math.max(max, countX);
                countX = 1;
            }

            if (currentY == board[i][x]) {
                countY++;
            }
            else {
                currentY = board[i][x];
                max = Math.max(max, countY);
                countY = 1;
            }
        }
        return Math.max(max, Math.max(countX, countY));
    }
}