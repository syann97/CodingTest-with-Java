import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


class Apart implements Comparable<Apart> {
    int pos;
    int count;

    public Apart (int pos, int count) {
        this.pos = pos;
        this.count = count;
    }

    @Override
    public int compareTo(Apart o) {
        return o.pos - this.pos;
    }
}


public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());

        PriorityQueue<Apart> left = new PriorityQueue<>();
        PriorityQueue<Apart> right = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int pos = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            int absPos = Math.abs(pos - S);

            if (pos < S) left.offer(new Apart(absPos, count));
            else right.offer(new Apart(absPos, count));
        }

        int answer = 0;
        answer += greedy(left, K);
        answer += greedy(right, K);

        System.out.println(answer);
    }

    private static int greedy(PriorityQueue<Apart> pq, int K) {
        int move = 0;
        Apart current = null;
        while (!pq.isEmpty()) {
            current = pq.poll();
            int times = ((current.count + K - 1) / K);
            move += current.pos * times * 2;

            int canTake = K * times;
            canTake -= current.count;

            while (!pq.isEmpty() && pq.peek().count <= canTake) {
                canTake -= pq.poll().count;
            }

            if (canTake > 0 && !pq.isEmpty()) {
                current = pq.peek();
                current.count -= canTake;
            }
        }
        return move;
    }
}