import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;


class Fire {
    int y;
    int x;
    public Fire(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Person {
    int y;
    int x;
    int dist;

    public Person(int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}

class Main {
    static StringTokenizer st;
    static int R;
    static int C;
    static char[][] area;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        area = new char[R][C];
        Queue<Fire> fireQueue = new ArrayDeque<>();

        int sx = 0;
        int sy = 0;

        for (int i = 0; i < R; i++) {
            area[i] = br.readLine().toCharArray();
            for (int j = 0; j < C; j++) {
                if (area[i][j] == 'F') fireQueue.offer(new Fire(i, j));
                else if (area[i][j] == 'J') {
                    sy = i;
                    sx = j;
                    area[i][j] = '.';
                }
            }
        }
        System.out.println(bfs(fireQueue, sy, sx));
    }

    public static String bfs (Queue<Fire> fireQueue, int sy, int sx) {
        boolean[][] visited = new boolean[R][C];
        Queue<Person> personQueue = new ArrayDeque<>();

        visited[sy][sx] = true;
        personQueue.offer(new Person(sy, sx, 1));

        while (!personQueue.isEmpty()) {
            int fSize = fireQueue.size();
            while (fSize-- > 0) {
                Fire fire = fireQueue.poll();
                int fy = fire.y;
                int fx = fire.x;

                for (int d = 0; d < 4; d++) {
                    int nfy = fy + dy[d];
                    int nfx = fx + dx[d];

                    if (0 <= nfy && nfy < R && 0 <= nfx && nfx < C && area[nfy][nfx] == '.') {
                        area[nfy][nfx] = 'F';
                        fireQueue.offer(new Fire(nfy, nfx));
                    }
                }
            }

            int pSize = personQueue.size();
            while (pSize-- > 0) {
                Person person = personQueue.poll();
                int y = person.y;
                int x = person.x;
                int dist = person.dist;

                if (y == 0 || y == R - 1 || x == 0 || x == C - 1) {
                    return Integer.toString(person.dist);
                }

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (0 <= ny && ny < R && 0 <= nx && nx < C && area[ny][nx] == '.' && !visited[ny][nx]) {
                        visited[ny][nx] = true;
                        personQueue.offer(new Person(ny, nx, dist + 1));
                    }
                }
            }
        }
        return "IMPOSSIBLE";
    }
}