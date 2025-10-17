import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int col = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int len = s.length();
        int row = len / col;
        char[][] board = new char[row][col];

        for (int i = 0; i < len; i++) {
            int r = i / col;
            int c = i % col;

            if (r % 2 == 1) c = col - c - 1;

            board[r][c] = s.charAt(i);
        }

        for (int j = 0; j < col; j++) {
            for (int i = 0; i < row; i++) {
                sb.append(board[i][j]);
            }
        }
        System.out.println(sb);
    }
}