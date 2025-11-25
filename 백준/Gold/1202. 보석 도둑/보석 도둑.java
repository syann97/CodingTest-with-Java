import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Jewel implements Comparable<Jewel> {
    int m;
    int v;

    public Jewel (int m, int v) {
        this.m = m;
        this.v = v;
    }

    @Override
    public int compareTo(Jewel o) {
        if (this.m != o.m) return Integer.compare(this.m, o.m);
        return Integer.compare(o.v, this.v);
    }

    @Override
    public String toString() {
        return this.m + " " + this.v;
    }
}


class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> jewelPQ  = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelPQ.offer(new Jewel(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int[] bags = new int[K];

        for (int i = 0; i < K ; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        long answer = 0;

        for (int bag : bags) {
            while (!jewelPQ.isEmpty() && jewelPQ.peek().m <= bag) {
                pq.offer(jewelPQ.poll().v);
            }

            if (!pq.isEmpty()) {
                answer += pq.poll();
            }
        }

        System.out.println(answer);
    }
}
