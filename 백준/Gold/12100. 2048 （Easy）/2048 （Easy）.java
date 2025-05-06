import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.StringTokenizer;


class CurrentBoard {
    int[][] board;
    int max;

    public CurrentBoard(int[][] board, int max) {
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


        bf(0, new CurrentBoard(board, max));
        System.out.println(max);
    }

    static void bf(int n, CurrentBoard current) {
        if (n == 5) {
            max = Math.max(max, current.max);
            return;
        }

        bf(n + 1, up(copyBoard(current)));
        bf(n + 1, down(copyBoard(current)));
        bf(n + 1, left(copyBoard(current)));
        bf(n + 1, right(copyBoard(current)));
    }

    static CurrentBoard copyBoard(CurrentBoard current) {
        int[][] copyBoard = new int[N][N];
        for (int i = 0; i < N; i++){
            copyBoard[i] = Arrays.copyOf(current.board[i], N);
        }
        return new CurrentBoard(copyBoard, current.max);
    }

    static CurrentBoard up (CurrentBoard current) {
        for (int j = 0; j < N; j++) {
            int pointer = 0;
            for (int i = 1; i < N; i++) {
                if (current.board[i][j] == 0) continue;

                int now = current.board[i][j];
                current.board[i][j] = 0;

                if (current.board[pointer][j] == 0) {
                    current.board[pointer][j] = now;
                    current.max = Math.max(current.max, now);
                }
                else {
                    if (current.board[pointer][j] == now) {
                        current.board[pointer][j] *= 2;
                        current.max = Math.max(current.max, now * 2);
                        pointer++;
                    }
                    else {
                        pointer++;
                        current.board[pointer][j] = now;
                        current.max = Math.max(current.max, now);
                    }
                }
            }
        }
        return current;
    }

    static CurrentBoard down (CurrentBoard current) {
        for (int j = 0; j < N; j++) {
            int pointer = N-1;
            for (int i = N-2; i >= 0; i--) {
                if (current.board[i][j] == 0) continue;

                int now = current.board[i][j];
                current.board[i][j] = 0;

                if (current.board[pointer][j] == 0) {
                    current.board[pointer][j] = now;
                    current.max = Math.max(current.max, now);
                }
                else {
                    if (current.board[pointer][j] == now) {
                        current.board[pointer][j] *= 2;
                        current.max = Math.max(current.max, now * 2);
                        pointer--;
                    }
                    else {
                        pointer--;
                        current.board[pointer][j] = now;
                        current.max = Math.max(current.max, now);
                    }
                }
            }
        }
        return current;
    }

    static CurrentBoard left (CurrentBoard current) {
        for (int i = 0; i < N; i++) {
            int pointer = 0;
            for (int j = 1; j < N; j++) {
                if (current.board[i][j] == 0) continue;

                int now = current.board[i][j];
                current.board[i][j] = 0;

                if (current.board[i][pointer] == 0) {
                    current.board[i][pointer] = now;
                    current.max = Math.max(current.max, now);
                }
                else {
                    if (current.board[i][pointer] == now) {
                        current.board[i][pointer] *= 2;
                        current.max = Math.max(current.max, now * 2);
                        pointer++;
                    }
                    else {
                        pointer++;
                        current.board[i][pointer] = now;
                        current.max = Math.max(current.max, now);
                    }
                }
            }
        }
        return current;
    }

    static CurrentBoard right (CurrentBoard current) {
        for (int i = 0; i < N; i++) {
            int pointer = N-1;
            for (int j = N-2; j >= 0; j--) {
                if (current.board[i][j] == 0) continue;

                int now = current.board[i][j];
                current.board[i][j] = 0;

                if (current.board[i][pointer] == 0) {
                    current.board[i][pointer] = now;
                    current.max = Math.max(current.max, now);
                }
                else {
                    if (current.board[i][pointer] == now) {
                        current.board[i][pointer] *= 2;
                        current.max = Math.max(current.max, now * 2);
                        pointer--;
                    }
                    else {
                        pointer--;
                        current.board[i][pointer] = now;
                        current.max = Math.max(current.max, now);
                    }
                }
            }
        }
        return current;
    }
}
