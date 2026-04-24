import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Cow implements Comparable<Cow> {
    int s;
    int e;

    public Cow (int s, int e) {
        this.s = s;
        this.e = e;
    }

    public int compareTo(Cow o) {
        return this.s - o.s;
    }
}

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] T = new int[C];
        for (int i = 0; i < C; i++) {
            T[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(T);

        Cow[] cows = new Cow[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            cows[i] = new Cow(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
        }

        Arrays.sort(cows);

        int index = 0;
        int count = 0;
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int chicken : T) {
            while (index < N && cows[index].s <= chicken) {
                pq.offer(cows[index].e);
                index++;
            }

            while (!pq.isEmpty() && pq.peek() < chicken) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                pq.poll();
                count++;
            }
        }

        System.out.println(count);
    }
}
