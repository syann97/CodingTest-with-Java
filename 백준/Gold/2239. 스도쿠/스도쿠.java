import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    static boolean[][] row = new boolean[9][10];
    static boolean[][] col = new boolean[9][10];
    static boolean[][] subBoard = new boolean[9][10];
    static StringBuilder sb = new StringBuilder();
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] board = new int[9][9];

        for (int i = 0; i < 9; i++) {
            String numbers = br.readLine();
            for (int j = 0; j < 9; j++) {
                board[i][j] = Integer.parseInt(String.valueOf(numbers.charAt(j)));
                if (board[i][j] != 0) {
                    row[i][board[i][j]] = true;
                    col[j][board[i][j]] = true;
                    subBoard[((i/3)*3+(j/3))][board[i][j]] = true;
                }
            }
        }
        bt(0, 0, board);
        System.out.println(sb);
    }


    static boolean bt(int y, int x, int[][] board) {
        if (y == 9) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    sb.append(board[i][j]);
                }
                sb.append("\n");
            }
            return true;
        }

        int ny = x + 1 == 9 ? y + 1 : y;
        int nx = x + 1 == 9 ? 0 : x + 1;

        if (board[y][x] == 0) {
            for (int k = 1; k <= 9; k++) {
                if (!row[y][k] && !col[x][k] && !subBoard[((y/3)*3+(x/3))][k]) {
                    row[y][k] = true;
                    col[x][k] = true;
                    subBoard[((y/3)*3+(x/3))][k] = true;
                    board[y][x] = k;

                    if (bt(ny, nx, board)) return true;

                    row[y][k] = false;
                    col[x][k] = false;
                    subBoard[((y/3)*3+(x/3))][k] = false;
                    board[y][x] = 0;

                }
            }
        }
        else {
            if (bt(ny, nx, board)) return true;
        }
        return false;
    }
}
