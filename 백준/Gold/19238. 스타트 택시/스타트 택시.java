import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.StringTokenizer;

class Passenger {
    int sy;
    int sx;
    int ey;
    int ex;
    int dist;

    public Passenger(int sy, int sx, int ey, int ex, int dist) {
        this.sy = sy;
        this.sx = sx;
        this.ey = ey;
        this.ex = ex;
        this.dist = dist;
    }
}

public class Main {
    static StringTokenizer st;
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static int N;
    static int M;
    static int F;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, -1, 0, 1};

    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        F = Integer.parseInt(st.nextToken());
        int[][] area = new int[N][N];
        boolean isPossible = true;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        int y = Integer.parseInt(st.nextToken()) - 1;
        int x = Integer.parseInt(st.nextToken()) - 1;

        ArrayList<Passenger> passengers = new ArrayList<>();
        // dummy input
        passengers.add(new Passenger(0, 0, 0, 0, 0));
        passengers.add(new Passenger(0, 0, 0, 0, 0));

        for (int i = 2;  i < M + 2; i++) {
            st = new StringTokenizer(br.readLine());
            int sy = Integer.parseInt(st.nextToken()) - 1;
            int sx = Integer.parseInt(st.nextToken()) - 1;
            int ey = Integer.parseInt(st.nextToken()) - 1;
            int ex = Integer.parseInt(st.nextToken()) - 1;
            int dist = setDist(sy, sx, ey, ex, area);
            if (dist == -1) {
                isPossible = false;
                break;
            }
            passengers.add(new Passenger(sy, sx, ey, ex, dist));
            area[sy][sx] = i;
        }
        if (isPossible) System.out.println(canPickUpAllPassengers(y, x, passengers, area));
        else System.out.println(-1);
    }

    static int setDist(int sy, int sx, int ey, int ex, int[][] area) {
        boolean[][] visited = new boolean[N][N];
        visited[sy][sx] =true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sy, sx, 0});

        while (!q.isEmpty()) {
            int[] node = q.poll();
            int y = node[0];
            int x = node[1];
            int dist = node[2];

            if (y == ey && x == ex) return dist;

            for (int d = 0; d < 4; d++) {
                int ny = y + dy[d];
                int nx = x + dx[d];

                if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx] && area[ny][nx] != 1) {
                    visited[ny][nx] = true;
                    q.offer(new int[]{ny, nx, dist + 1});
                }
            }
        }
        return -1;
    }

    static int canPickUpAllPassengers(int y, int x, ArrayList<Passenger> passengers, int[][] area) {
        int restPassenger = M;
        while (restPassenger --> 0) {
            // 승객 정보를 가져오기
            int[] passengerInfo = findPassenger(y, x, area);

            // null일 경우 반환
            if (passengerInfo == null) return -1;

            // 승객 정보 가져오기
            Passenger passenger = passengers.get(passengerInfo[1]);

            // 이동 거리만큼 감소
            F -= passengerInfo[0];

            // 승객한테 이동하는 도중 연료가 고갈될 경우
            if (F < 0) return -1;

            // 승객부터 목적지까지 도달하지 못하는 경우
            if (F - passenger.dist < 0) return -1;

            // 연료 증가
            F += passenger.dist;

            // 좌표 변경
            y = passenger.ey;
            x = passenger.ex;

            // 이미 처리된 승객을 제거
            area[passenger.sy][passenger.sx] = 0;
        }

        return F;
    }

    static int[] findPassenger(int sy, int sx, int[][] area) {
        boolean[][] visited = new boolean[N][N];
        visited[sy][sx] =true;
        ArrayDeque<int[]> q = new ArrayDeque<>();
        q.offer(new int[]{sy, sx, 0});
        while (!q.isEmpty()) {
            int size = q.size();

            while (size --> 0) {
                int[] node = q.poll();
                int y = node[0];
                int x = node[1];
                int dist = node[2];

                if (area[y][x] >= 2) {
                    while (!q.isEmpty()) {
                        node = q.poll();
                        int ny = node[0];
                        int nx = node[1];
                        int newDist = node[2];

                        if (area[ny][nx] >= 2 && dist == newDist) {
                            if ((y > ny) || (y == ny && x > nx)) {
                                y = ny;
                                x = nx;
                            }
                        }
                    }
                    return new int[]{dist, area[y][x]};
                }

                for (int d = 0; d < 4; d++) {
                    int ny = y + dy[d];
                    int nx = x + dx[d];

                    if (0 <= ny && ny < N && 0 <= nx && nx < N && !visited[ny][nx] && area[ny][nx] != 1) {
                        visited[ny][nx] = true;
                        q.offer(new int[]{ny, nx, dist + 1});
                    }
                }
            }
        }
        return null;
    }
}
