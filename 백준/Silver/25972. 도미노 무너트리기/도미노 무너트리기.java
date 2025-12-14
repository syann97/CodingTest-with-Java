import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Domino implements Comparable<Domino> {
    int a;
    int l;

    public Domino (int a, int l) {
        this.a = a;
        this.l = l;
    }

    @Override
    public int compareTo(Domino o) {
        if (this.a == o.a) return Integer.compare(this.l, o.l);
        return Integer.compare(this.a, o.a);
    }
}

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Domino> dominos = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dominos.add(new Domino(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        int count = 0;
        long end = 0;

        for (int i = 0; i < N; i++) {
            Domino domino = dominos.poll();

            if (end < domino.a) count++;

            end = (long) domino.a + domino.l;
        }

        System.out.println(count);
    }
}
