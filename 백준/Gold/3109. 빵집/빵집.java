import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int R;
    static int C;
    static boolean[][] visited;

    static int[] dy = {-1, 0, 1};
    static int[] dx = {1, 1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        visited = new boolean[R][C];

        char[] input;
        for (int i = 0; i < R; i++) {
            input = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (input[j] == 'x') visited[i][j] = true;
            }
        }

        int answer = 0;
        int row = 0;

        while (row < R) {
            visited[row][0] = true;
            if (dfs(row, 0)) answer++;
            row++;
        }

        System.out.println(answer);
    }


    private static boolean dfs(int y, int x) {
        if (x == C - 1) return true;

        for (int d = 0; d < 3; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (0 <= ny && ny < R && 0 <= nx && nx < C && !visited[ny][nx]) {
                visited[ny][nx] = true;
                if (dfs(ny, nx)) return true;
            }
        }
        return false;
    }
}
