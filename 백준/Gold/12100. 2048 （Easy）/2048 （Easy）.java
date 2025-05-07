import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;


class BoardState {
    int[][] board;
    int max;

    public BoardState(int[][] board, int max) {
        this.board = board;
        this.max = max;
    }
}

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
                max = Math.max(max, board[i][j]);
            }
        }


        bt(0, new BoardState(board, max));
        System.out.println(max);
    }

    static void bt(int n, BoardState current) {
        if (n == 5) {
            max = Math.max(max, current.max);
            return;
        }

        int maxPossible = current.max * (1 << (5 - n));
        if (maxPossible <= max) return;

        BoardState[] nextBoard = new BoardState[4];
        nextBoard[0] = up(current);
        nextBoard[1] = down(current);
        nextBoard[2] = left(current);
        nextBoard[3] = right(current);

        for (BoardState board : nextBoard) {
            if (board != null) bt(n + 1, board);
        }
    }

    static BoardState copyBoard(BoardState current) {
        int[][] copyBoard = new int[N][N];
        for (int i = 0; i < N; i++){
            copyBoard[i] = Arrays.copyOf(current.board[i], N);
        }
        return new BoardState(copyBoard, current.max);
    }

    static BoardState up (BoardState current) {
        BoardState copy = copyBoard(current);
        boolean moved = false;

        for (int j = 0; j < N; j++) {
            int pointer = 0;
            for (int i = 1; i < N; i++) {
                if (copy.board[i][j] == 0) continue;

                int now = copy.board[i][j];
                copy.board[i][j] = 0;

                if (copy.board[pointer][j] == 0) {
                    copy.board[pointer][j] = now;
                    if (pointer != i) moved = true;
                }
                else {
                    if (copy.board[pointer][j] == now) {
                        copy.board[pointer][j] *= 2;
                        copy.max = Math.max(copy.max, now * 2);
                        moved = true;
                        pointer++;
                    }
                    else {
                        pointer++;
                        if (pointer != i) moved = true;
                        copy.board[pointer][j] = now;
                    }
                }
            }
        }
        return moved ? copy : null;
    }

    static BoardState down (BoardState current) {
        BoardState copy = copyBoard(current);
        boolean moved = false;

        for (int j = 0; j < N; j++) {
            int pointer = N-1;
            for (int i = N-2; i >= 0; i--) {
                if (copy.board[i][j] == 0) continue;

                int now = copy.board[i][j];
                copy.board[i][j] = 0;

                if (copy.board[pointer][j] == 0) {
                    copy.board[pointer][j] = now;
                    if (pointer != i) moved = true;
                }
                else {
                    if (copy.board[pointer][j] == now) {
                        copy.board[pointer][j] *= 2;
                        copy.max = Math.max(copy.max, now * 2);
                        moved = true;
                        pointer--;
                    }
                    else {
                        pointer--;
                        copy.board[pointer][j] = now;
                        if (pointer != i) moved = true;
                    }
                }
            }
        }
        return moved ? copy : null;
    }

    static BoardState left (BoardState current) {
        BoardState copy = copyBoard(current);
        boolean moved = false;

        for (int i = 0; i < N; i++) {
            int pointer = 0;
            for (int j = 1; j < N; j++) {
                if (copy.board[i][j] == 0) continue;

                int now = copy.board[i][j];
                copy.board[i][j] = 0;

                if (copy.board[i][pointer] == 0) {
                    copy.board[i][pointer] = now;
                    if (pointer != j) moved = true;
                }
                else {
                    if (copy.board[i][pointer] == now) {
                        copy.board[i][pointer] *= 2;
                        copy.max = Math.max(copy.max, now * 2);
                        moved = true;
                        pointer++;
                    }
                    else {
                        pointer++;
                        copy.board[i][pointer] = now;
                        if (pointer != j) moved = true;
                    }
                }
            }
        }
        return moved ? copy : null;
    }

    static BoardState right (BoardState current) {
        BoardState copy = copyBoard(current);
        boolean moved = false;

        for (int i = 0; i < N; i++) {
            int pointer = N-1;
            for (int j = N-2; j >= 0; j--) {
                if (copy.board[i][j] == 0) continue;

                int now = copy.board[i][j];
                copy.board[i][j] = 0;

                if (copy.board[i][pointer] == 0) {
                    copy.board[i][pointer] = now;
                    if (pointer != j) moved = true;
                }
                else {
                    if (copy.board[i][pointer] == now) {
                        copy.board[i][pointer] *= 2;
                        copy.max = Math.max(copy.max, now * 2);
                        moved = true;
                        pointer--;
                    }
                    else {
                        pointer--;
                        copy.board[i][pointer] = now;
                        if (pointer != j) moved = true;
                    }
                }
            }
        }
        return moved ? copy : null;
    }
}
