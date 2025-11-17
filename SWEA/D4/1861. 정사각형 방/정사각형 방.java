import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

class Room {
    int y;
    int x;
    int dist;

    public Room (int y, int x, int dist) {
        this.y = y;
        this.x = x;
        this.dist = dist;
    }
}

class Solution {
    static StringTokenizer st;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            int[][] rooms = new int[N][N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < N; j++) {
                    rooms[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int num = rooms[0][0];
            int move = 1;

            int[][] visited = new int[N][N];

            for(int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j] == 0) {
                        int tmp = getMoveCount(N, i, j, rooms, visited);

                        if (move == tmp) {
                            num = Math.min(num, rooms[i][j]);
                        }
                        else if (move < tmp) {
                            num = rooms[i][j];
                            move = tmp;
                        }
                    }
                }
            }

            sb.append("#").append(t).append(" ").append(num).append(" ").append(move).append("\n");
        }

        System.out.print(sb);
    }

    static int getMoveCount(int n, int sy, int sx, int[][] rooms, int[][] visited) {
        Queue<Room> q = new ArrayDeque<>();

        q.offer(new Room(sy, sx, 1));
        visited[sy][sx] = 1;

        int max = 1;
        int num = rooms[sy][sx];
        while (!q.isEmpty()) {
            Room room = q.poll();
            int y = room.y;
            int x = room.x;
            int dist = room.dist;

            max = Math.max(max, dist);

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (0 <= ny && ny < n && 0 <= nx && nx < n) {
                    if (rooms[y][x] + 1 != rooms[ny][nx]) continue;
                    if (visited[ny][nx] < dist + 1) {
                        q.offer(new Room(ny, nx, dist + 1));
                        visited[ny][nx] = dist + 1;
                    }
                }
            }
        }

        return max;
    }
}