import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    static int[] dx = {-1, 1};
    static int[] check = {64, 4};
    static int[] cogwheels = new int[4];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for (int i = 0; i < 4; i++) {
            cogwheels[i] = convertToDecimal(br.readLine().toCharArray());
        }

        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());

            rotate(n, d);
        }
        System.out.println(getPoint());
    }

    private static int getPoint() {
        int point = 0;
        if ((cogwheels[0] & 1) == 1) point += 1;
        if ((cogwheels[1] & 1) == 1) point += 2;
        if ((cogwheels[2] & 1) == 1) point += 4;
        if ((cogwheels[3] & 1) == 1) point += 8;

        return point;
    }

    private static void rotate(int n, int dir) {
        boolean[] visited = new boolean[4];
        visited[n-1] = true;

        ArrayDeque<int[]> q = new ArrayDeque<>();
        ArrayDeque<int[]> rotate = new ArrayDeque<>();

        q.offer(new int[]{n-1, dir});
        rotate.offer(new int[]{n-1, dir});

        while (!q.isEmpty()) {
            int[] cogwheel = q.poll();
            int x = cogwheel[0];
            int d = cogwheel[1];

            for (int i = 0; i < 2; i++) {
                int nx = x + dx[i];

                if (0 <= nx && nx < 4 && !visited[nx]) {
                    if ((((cogwheels[x] & check[i]) != 0) ^ ((cogwheels[nx] & check[(i + 1) % 2])) != 0)) {
                        q.offer(new int[] {nx, d == 1 ? -1 : 1});
                        rotate.offer(new int[] {nx, d == 1 ? -1 : 1});
                    }
                    visited[nx] = true;
                }
            }
        }


        while (!rotate.isEmpty()) {
            int[] tmp = rotate.poll();
            int x = tmp[0];
            int d = tmp[1];

            if (d == 1) {
                if ((cogwheels[x] & 128) != 0) {
                    cogwheels[x] <<= 1;
                    cogwheels[x] -= 255;
                }
                else {
                    cogwheels[x] <<= 1;
                }
            }
            else {
                if ((cogwheels[x] & 1) != 0) {
                    cogwheels[x] >>= 1;
                    cogwheels[x] += 128;
                }
                else {
                    cogwheels[x] >>= 1;
                }
            }
        }
    }

    private static int convertToDecimal(char[] arr) {
        int tmp = 0;

        for (int i = arr.length - 1; i >= 0; i--) {
            tmp <<= 1;
            if (arr[i] == '1') tmp += 1;
        }

        return tmp;
    }
}
