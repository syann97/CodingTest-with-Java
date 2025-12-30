import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] dy = {-1, -1, -1, 0, 0, 1, 1, 1};
    static int[] dx = {-1, 0, 1, -1, 1, -1, 0, 1};
    static int N;
    static int M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        char[][] area = new char[N][M];

        for (int i = 0; i < N; i++) {
            area[i] = br.readLine().toCharArray();
        }

        int answer = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (area[i][j] == 'F') {
                    answer += findFox(i, j, area);
                }
            }
        }

        System.out.println(answer);
    }

    public static int findFox (int y, int x, char[][] area) {
        int count = 0;

        for (int d = 0; d < 8; d++) {
            int ny1 = y + dy[d];
            int nx1 = x + dx[d];

            if (0 <= ny1 && ny1 < N && 0 <= nx1 && nx1 < M && area[ny1][nx1] == 'O') {
                int ny2 = ny1 + dy[d];
                int nx2 = nx1 + dx[d];

                if (0 <= ny2 && ny2 < N && 0 <= nx2 && nx2 < M && area[ny2][nx2] == 'X') {
                    count++;
                }
            }
        }

        return count;
    }
}
