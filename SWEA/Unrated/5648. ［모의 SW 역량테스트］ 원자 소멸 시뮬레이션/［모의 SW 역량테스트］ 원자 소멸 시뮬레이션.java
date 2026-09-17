import java.io.*;
import java.util.*;

class Solution {
    static class Atomic {
        int d;
        int K;

        public Atomic(int d, int K) {
            this.d = d;
            this.K = K;
        }
    }

    static int[] dy = {1, -1, 0, 0};
    static int[] dx = {0, 0, -1, 1};

    static Map<Integer, Atomic> cur = new HashMap<>();
    static Map<Integer, Atomic> next = new HashMap<>();
    static Map<Integer, Integer> collision = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());

            cur.clear();
            next.clear();
            collision.clear();

            for (int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());

                int x = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int y = (Integer.parseInt(st.nextToken()) + 1000) * 2;
                int d = Integer.parseInt(st.nextToken());
                int K = Integer.parseInt(st.nextToken());

                int encode = (x << 12) | y;

                cur.put(encode, new Atomic(d, K));
            }

            int answer = 0;

            while (!cur.isEmpty()) {
                next.clear();
                collision.clear();

                for (Map.Entry<Integer, Atomic> entry : cur.entrySet()) {
                    int encode = entry.getKey();

                    int x = encode >> 12;
                    int y = encode & 4095;

                    Atomic atomic = entry.getValue();

                    int nx = x + dx[atomic.d];
                    int ny = y + dy[atomic.d];

                    if (nx < 0 || nx > 4000 || ny < 0 || ny > 4000) {
                        continue;
                    }

                    int newEncode = (nx << 12) | ny;

                    if (collision.containsKey(newEncode)) {
                        collision.put(newEncode, collision.get(newEncode) + atomic.K);
                        continue;
                    }

                    Atomic prev = next.putIfAbsent(newEncode, atomic);

                    if (prev != null) {
                        next.remove(newEncode);
                        collision.put(newEncode, prev.K + atomic.K);
                    }
                }

                for (int energy : collision.values()) {
                    answer += energy;
                }

                Map<Integer, Atomic> temp = cur;
                cur = next;
                next = temp;
            }

            sb.append("#").append(t).append(" ").append(answer).append("\n");
        }

        System.out.print(sb);
    }
}