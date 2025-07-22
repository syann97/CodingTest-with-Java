import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        long x1 = Long.parseLong(st.nextToken());
        long y1 = Long.parseLong(st.nextToken());
        long r1 = Long.parseLong(st.nextToken());

        st = new StringTokenizer(br.readLine());
        long x2 = Long.parseLong(st.nextToken());
        long y2 = Long.parseLong(st.nextToken());
        long r2 = Long.parseLong(st.nextToken());

        long dist_sq = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);

        long radius_sum_sq = (r1 + r2) * (r1 + r2);

        System.out.println(dist_sq < radius_sum_sq ? "YES" : "NO");
    }
}