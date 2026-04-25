import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    static int N;
    static int C;
    static int M;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> sendPq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int send = Integer.parseInt(st.nextToken());
            int receive = Integer.parseInt(st.nextToken());
            int quantity = Integer.parseInt(st.nextToken());

            sendPq.offer(new int[]{send, receive, quantity});
        }

        int[] count = new int[N+1];
        int answer = 0;

        while (!sendPq.isEmpty()) {
            int[] current = sendPq.poll();
            answer += loadMax(current, count);
        }

        System.out.println(answer);
    }

    static int loadMax(int[] current, int[] count) {
        int quantity = Integer.MAX_VALUE;

        for (int i = current[0]; i < current[1]; i++) {
            if (count[i] == C) {
                return 0;
            }
            quantity = Math.min(quantity, Math.min(C - count[i], current[2]));
        }

        for (int i = current[0]; i < current[1]; i++) {
            count[i] += quantity;
        }

        return quantity;
    }
}
