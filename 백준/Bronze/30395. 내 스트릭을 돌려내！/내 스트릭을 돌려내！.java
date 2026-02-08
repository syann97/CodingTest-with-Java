import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        boolean stack = false;
        int max = 0;
        int day = 0;

        for (int i = 0; i < N; i++) {
            if (st.nextToken().equals("0")) {
                if (day == 0) continue;

                if (!stack) stack = true;
                else {
                    max = Math.max(max, day);
                    stack = false;
                    day = 0;
                }
            }
            else {
                stack = false;
                day++;
            }
        }

        System.out.println(Math.max(max, day));
    }
}
