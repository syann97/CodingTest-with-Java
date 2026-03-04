import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine(), ":");
        int h1 = Integer.parseInt(st.nextToken());
        int m1 = Integer.parseInt(st.nextToken());
        int s1 = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), ":");
        int h2 = Integer.parseInt(st.nextToken());
        int m2 = Integer.parseInt(st.nextToken());
        int s2 = Integer.parseInt(st.nextToken());

        System.out.println(getWaitingTime(h1, m1, s1, h2, m2, s2));
    }

    static String getWaitingTime(int h1, int m1, int s1, int h2, int m2, int s2) {
        int h;
        int m;
        int s;

        if (h2 < h1 || (h2 == h1 && m2 < m1) || (h2 == h1 && m2 == m1 && h2 < m1)) {
            h2 += 24;
        }

        if (s1 > s2) {
            m2--;
            s2 += 60;
        }

        if (m1 > m2) {
            h2--;
            m2 += 60;
        }

        s = s2 - s1;
        m = m2 - m1;
        h = h2 - h1;

        return String.format("%02d:%02d:%02d", h, m, s);
    }
}
