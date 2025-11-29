import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static int N;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        char[][] space = new char[N][N];

        for (int i = 0; i < N; i++) {
            space[i] = br.readLine().toCharArray();
        }

        int x_count = 0;
        int y_count = 0;
        
        for (int i = 0; i < N; i++) {
            int count = 0;
            for (int j = 0; j < N; j++) {
                if (space[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) x_count++;
                    count = 0;
                }
            }
            if (count >= 2) {
                x_count++;
            }
        }

        for (int j = 0; j < N; j++) {
            int count = 0;
            for (int i = 0; i < N; i++) {
                if (space[i][j] == '.') {
                    count++;
                } else {
                    if (count >= 2) y_count++;
                    count = 0;
                }
            }
            if (count >= 2) {
                y_count++;
            }
        }

        System.out.println(x_count + " " + y_count);
    }
}