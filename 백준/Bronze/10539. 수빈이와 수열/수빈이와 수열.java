import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        long sum = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            long total = Long.parseLong(st.nextToken()) * i;
            sb.append(total - sum).append(" ");
            sum = total;
        }
        
        System.out.println(sb);
    }
}
