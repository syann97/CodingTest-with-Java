import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int max = 0;
        int count = 0;
        int current = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());

            if (current < next) {
                max = Math.max(max, count);
                current = next;
                count = 0;
            }
            else {
                count++;
            }
        }
        System.out.print(Math.max(max, count));
    }
}
