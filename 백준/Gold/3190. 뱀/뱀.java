import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

class Node {
    int y;
    int x;

    public Node(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

class Operation {
    int time;
    String operation;

    public Operation(int time, String operation) {
        this.time = time;
        this.operation = operation;
    }
}


public class Main {
    static StringTokenizer st;
    static int N;
    static int[] dy = {0, 1, 0, -1};    // 12시부터 시계방향
    static int[] dx = {1, 0, -1, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int K = Integer.parseInt(br.readLine());
        int[][] area = new int[N+2][N+2];
        ArrayDeque<Operation> operations = new ArrayDeque<>();

        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int y = Integer.parseInt(st.nextToken());
            int x = Integer.parseInt(st.nextToken());
            area[y][x] = 2;
        }

        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            int X = Integer.parseInt(st.nextToken());
            String C = st.nextToken();
            operations.offer(new Operation(X, C));
        }

        System.out.println(startGame(area, operations));
    }

    static int startGame(int[][] area, ArrayDeque<Operation> operations) {
        ArrayDeque<Node> dq = new ArrayDeque<>();
        dq.offer(new Node(1, 1));
        area[1][1] = 1;

        int y = 1;
        int x = 1;
        int d = 0;
        int time = 0;
        boolean isCompleted = false;
        Operation op = operations.poll();


        while (!dq.isEmpty()) {
            time++;
            // 이전 명령이 수행되고 다음 명령이 존재할 경우
            if (isCompleted && !operations.isEmpty()) {
                isCompleted = false;
                op = operations.poll();
            }

            // 다음 이동 좌표
            int ny = y + dy[d];
            int nx = x + dx[d];

            // 조건 제어 로직
            if (1 <= ny && ny <= N && 1 <= nx && nx <= N) {
                // front 제거했는데도 꼬리인 경우
                if (area[ny][nx] == 1) {
                    return time;
                }

                // 사과가 아닌 경우 우선 back 부터 제거
                if (area[ny][nx] != 2) {
                    if (!dq.isEmpty()) {
                        Node back = dq.pollFirst();
                        area[back.y][back.x] = 0;
                    }
                    else {
                        area[y][x] = 0;
                    }
                }

                // 아닌 경우 이동
                dq.offer(new Node(ny, nx));
                area[ny][nx] = 1;
                y = ny;
                x = nx;
            }
            else return time;

            // 방향 변경 로직
            if (op.time == time) {
                if (op.operation.equals("D")) d = (d+1) % 4;
                else d = d - 1 < 0 ? 3 : d - 1;
                isCompleted = true;
            }
        }
        return time;
    }
}