import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = 0;

        for (int i = 0; i < 8; i++) {
            char[] board = br.readLine().toCharArray();
            for (int j = 0; j < 8; j++) {
                if (board[j] == 'P') answer += 1;
                else if (board[j] == 'p') answer -= 1;
                else if (board[j] == 'N') answer += 3;
                else if (board[j] == 'n') answer -= 3;
                else if (board[j] == 'B') answer += 3;
                else if (board[j] == 'b') answer -= 3;
                else if (board[j] == 'R') answer += 5;
                else if (board[j] == 'r') answer -= 5;
                else if (board[j] == 'Q') answer += 9;
                else if (board[j] == 'q') answer -= 9;
            }
        }
        System.out.println(answer);
    }
}