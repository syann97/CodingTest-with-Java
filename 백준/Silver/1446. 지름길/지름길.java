import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

class Shortcut implements Comparable<Shortcut> {
    int start;
    int end;
    int dist;

    public Shortcut (int start, int end, int dist) {
        this.start = start;
        this.end = end;
        this.dist = dist;
    }

    @Override
    public int compareTo(Shortcut o) {
        return Integer.compare(this.end, o.end);
    }
}

class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int D = Integer.parseInt(st.nextToken());

        int[] driveDist = new int[D+1];
        for (int i = 1; i <= D; i++) driveDist[i] = i;

        Shortcut[] shortcuts = new Shortcut[N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int dist = Integer.parseInt(st.nextToken());
            shortcuts[i] = new Shortcut(start, end, dist);
        }

        Arrays.sort(shortcuts);

        for (int i = 0; i < N; i++) {
            int start = shortcuts[i].start;
            int end = shortcuts[i].end;
            int dist = shortcuts[i].dist;

            if (start <= D && end <= D && dist < driveDist[end] - driveDist[start]) {
                int diff = (driveDist[end] - driveDist[start]) - dist;
                for (int j = end; j <= D; j++) {
                    driveDist[j] -= diff;
                }
            }
        }

        System.out.println(driveDist[D]);
    }
}