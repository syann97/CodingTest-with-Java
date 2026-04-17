import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        System.out.println(greedy());
    }

    private static String greedy() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int L = Integer.parseInt(br.readLine());

        st = new StringTokenizer(br.readLine());
        int ml = Integer.parseInt(st.nextToken());
        int mk = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(br.readLine());


        ArrayDeque<Integer> q = new ArrayDeque<>();
        for (int i = 1; i <= L; i++) {
            while (!q.isEmpty() && q.peekFirst() < i) q.poll();

            int z = Integer.parseInt(br.readLine());
            int damage = Math.max(Math.min(ml, i) - q.size(), 0) * mk;

            if (z > damage) {
                if (--C < 0) return "NO";
                q.offer(i+ml-1);
            }
        }

        return "YES";
    }
}