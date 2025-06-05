import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            return o1[0] == o2[0] ? o1[1] - o2[1] : o1[0] - o2[0];
        });

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
        }

        PriorityQueue<Integer> rooms = new PriorityQueue<>();
        rooms.offer(0);

        while (!pq.isEmpty()) {
            int[] tmp = pq.poll();
            int start = tmp[0];
            int end = tmp[1];

            if (rooms.peek() <= start) rooms.poll();
            rooms.offer(end);
        }

        System.out.println(rooms.size());
    }
}
