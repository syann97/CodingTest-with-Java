import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int clap = -1;
        int count = 0;

        for (int i = 0; i < N; i++) {
            int t = Integer.parseInt(st.nextToken());
            if (clap < t) {
                clap = t + K;
                count++;
            }
        }

        System.out.println(count);
    }
}
