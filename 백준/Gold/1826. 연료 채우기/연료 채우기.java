import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<int[]> waitingQueue = new PriorityQueue<>((o1, o2) -> {
            return o1[0] - o2[0];
        });

        PriorityQueue<int[]> candidateQueue = new PriorityQueue<>((o1, o2) -> {
            return o2[1] - o1[1];
        });

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            waitingQueue.offer(new int[]{a, b});
        }

        st = new StringTokenizer(br.readLine());
        int L = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());

        int count = 0;
        while (true) {
            if (P >= L) break;

            while (!waitingQueue.isEmpty() && waitingQueue.peek()[0] <= P) {
                candidateQueue.offer(waitingQueue.poll());
            }

            if (candidateQueue.isEmpty()) {
                count = -1;
                break;
            }

            P += candidateQueue.poll()[1];
            count++;
        }

        System.out.println(count);
    }
}
