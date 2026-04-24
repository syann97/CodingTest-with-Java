import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Assignment implements Comparable<Assignment> {
    int d;
    int w;

    public Assignment (int d, int w) {
        this.d = d;
        this.w = w;
    }

    @Override
    public int compareTo(Assignment o) {
        return o.d - this.d;
    }
}


public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Assignment> pq = new PriorityQueue<>();

        int N = Integer.parseInt(br.readLine());
        int day = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int d = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            day = Math.max(day, d);
            pq.offer(new Assignment(d, w));
        }

        PriorityQueue<Integer> wPq = new PriorityQueue<>(((o1, o2) -> o2 - o1));

        int sum = 0;
        while(day > 0) {
            while (!pq.isEmpty() && day <= pq.peek().d) {
                wPq.offer(pq.poll().w);
            }

            sum += wPq.isEmpty() ? 0 : wPq.poll();
            day--;
        }

        System.out.println(sum);
    }
}
