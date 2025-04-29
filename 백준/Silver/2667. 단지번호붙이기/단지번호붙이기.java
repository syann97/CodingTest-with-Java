import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.*;

public class Main {
    static int[] dy = {-1, 1, 0, 0};
    static int[] dx = {0, 0, -1, 1};
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());   // 도시 개수
        char[][] map = new char[N][N];
        boolean[][] visited = new boolean[N][N];
        ArrayList<Integer> answer = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (map[i][j] == '1' && !visited[i][j]) {
                    answer.add(dfs(map, visited, i, j, 1));
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append(answer.size()).append("\n");
        Collections.sort(answer);
        for (int i : answer) {
            sb.append(i).append("\n");
        }
        System.out.print(sb);
    }

    static int dfs(char[][] map, boolean[][] visited, int y, int x, int count) {
        visited[y][x] = true;
        for (int d = 0; d < 4; d++) {
            int ny = y + dy[d];
            int nx = x + dx[d];

            if (0 <= ny && ny < N && 0 <= nx && nx < N && map[ny][nx] == '1' && !visited[ny][nx]) {
                count = dfs(map, visited, ny, nx, count + 1);
            }
        }
        return count;
    }
}