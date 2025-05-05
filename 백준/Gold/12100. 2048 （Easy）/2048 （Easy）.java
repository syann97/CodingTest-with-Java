import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int max = 0;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        int[][] board = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        bf(0, board);
        System.out.println(max);
    }

    static void bf(int n, int[][] board) {
        if (n == 5) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    max = Math.max(max, board[i][j]);
                }
            }
            return;
        }

        bf(n + 1, up(copyBoard(board)));
        bf(n + 1, down(copyBoard(board)));
        bf(n + 1, left(copyBoard(board)));
        bf(n + 1, right(copyBoard(board)));
    }

    static int[][] copyBoard(int[][] board) {
        int[][] copyBoard = new int[N][N];
        for (int i = 0; i < N; i++){
            copyBoard[i] = Arrays.copyOf(board[i], N);
        }
        return copyBoard;
    }

    static int[][] up (int[][] board) {
        for (int j = 0; j < N; j++) {
            int pointer = 0;
            for (int i = 1; i < N; i++) {
                if (board[i][j] == 0) continue;

                int now = board[i][j];
                board[i][j] = 0;

                if (board[pointer][j] == 0) {
                    board[pointer][j] = now;
                }
                else {
                    if (board[pointer][j] == now) {
                        board[pointer][j] *= 2;
                        pointer++;
                    }
                    else {
                        pointer++;
                        board[pointer][j] = now;
                    }
                }
            }
        }
        return board;
    }

    static int[][] down (int[][] board) {
        for (int j = 0; j < N; j++) {
            int pointer = N-1;
            for (int i = N-2; i >= 0; i--) {
                if (board[i][j] == 0) continue;

                int now = board[i][j];
                board[i][j] = 0;

                if (board[pointer][j] == 0) {
                    board[pointer][j] = now;
                }
                else {
                    if (board[pointer][j] == now) {
                        board[pointer][j] *= 2;
                        pointer--;
                    }
                    else {
                        pointer--;
                        board[pointer][j] = now;
                    }
                }
            }
        }
        return board;
    }

    static int[][] left (int[][] board) {
        for (int i = 0; i < N; i++) {
            int pointer = 0;
            for (int j = 1; j < N; j++) {
                if (board[i][j] == 0) continue;

                int now = board[i][j];
                board[i][j] = 0;

                if (board[i][pointer] == 0) {
                    board[i][pointer] = now;
                }
                else {
                    if (board[i][pointer] == now) {
                        board[i][pointer] *= 2;
                        pointer++;
                    }
                    else {
                        pointer++;
                        board[i][pointer] = now;
                    }
                }
            }
        }
        return board;
    }

    static int[][] right (int[][] board) {
        for (int i = 0; i < N; i++) {
            int pointer = N-1;
            for (int j = N-2; j >= 0; j--) {
                if (board[i][j] == 0) continue;

                int now = board[i][j];
                board[i][j] = 0;

                if (board[i][pointer] == 0) {
                    board[i][pointer] = now;
                }
                else {
                    if (board[i][pointer] == now) {
                        board[i][pointer] *= 2;
                        pointer--;
                    }
                    else {
                        pointer--;
                        board[i][pointer] = now;
                    }
                }
            }
        }
        return board;
    }
}
