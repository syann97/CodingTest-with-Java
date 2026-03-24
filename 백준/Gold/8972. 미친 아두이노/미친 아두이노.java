import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Arduino {
    int y;
    int x;

    public Arduino (int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class Main {
    static StringTokenizer st;
    static int R;
    static int C;
    static int cy;
    static int cx;
    static int[] dy = {0, 1, 1, 1, 0, 0, 0, -1, -1, -1};
    static int[] dx = {0, -1, 0, 1, -1, 0, 1, -1, 0, 1};
    static char[][] board;
    static ArrayDeque<Arduino> q;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        q = new ArrayDeque<>();

        board = new char[R][C];

        for (int i = 0; i < R; i++) {
            String s = br.readLine();
            for (int j = 0; j < C; j++) {
                board[i][j] = s.charAt(j);

                if (board[i][j] == 'I') {
                    cy = i;
                    cx = j;
                }

                else if (board[i][j] == 'R') {
                    q.offer(new Arduino(i, j));
                }
            }
        }

        System.out.println(getAnswer(br.readLine().toCharArray()));
    }

    static String getAnswer(char[] orders) {
        for (int i = 0; i < orders.length; i++) {
            int order = (int)orders[i] - '0';
            if (!moveArduino(order) || !moveCrazyArduino()) {
                return "kraj " + (i+1);
            }
        }

        return print(board);
    }

    static String print(char[][] board) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                sb.append(board[i][j]);
            }
            sb.append("\n");
        }

        return sb.toString();
    }

    static boolean moveCrazyArduino() {
        int[][] visited = new int[R][C];

        int size = q.size();
        while (size-- > 0) {
            Arduino arduino = q.poll();
            int y = arduino.y;
            int x = arduino.x;
            board[y][x] = '.';

            int d = calMoveDir(y, x);

            int ny = y + dy[d];
            int nx = x + dx[d];

            // 중복 방문 체크
            if (visited[ny][nx] == 0) {
                // 이동 후 큐 저장
                q.offer(new Arduino(ny, nx));
                visited[ny][nx] = 1;
            }
            else {
                visited[ny][nx] = -1;
            }
        }

        // 필터링
        size = q.size();
        while(size-- > 0) {
            Arduino arduino = q.poll();
            int y = arduino.y;
            int x = arduino.x;

            if (board[y][x] == 'I') {
                return false;
            }

            if (visited[y][x] == 1) {
                q.offer(new Arduino(y, x));
                board[y][x] = 'R';
            }
        }

        return true;
    }

    static int calMoveDir(int y, int x) {
        int vertical = 0;
        int horizontal = 0;

        // 목표보다 위에 있는 경우
        if (y < cy) {
            vertical = 1;
        }
        else if (y > cy) {
            vertical = -1;
        }

        if (x < cx) {
            horizontal = 1;
        }
        else if (x > cx) {
            horizontal = -1;
        }

        for (int d = 1; d <= 9; d++) {
            if (vertical == dy[d] && horizontal == dx[d]) {
                return d;
            }
        }

        return 5;
    }

    static boolean moveArduino(int d) {
        if (d == 5) return true;

        int ny = cy + dy[d];
        int nx = cx + dx[d];

        // 보드 내 입력 주어짐 (inbound 제거)
        if (board[ny][nx] == 'R') {
            return false;
        }

        board[ny][nx] = 'I';
        board[cy][cx] = '.';
        cy = ny;
        cx = nx;

        return true;
    }
}
