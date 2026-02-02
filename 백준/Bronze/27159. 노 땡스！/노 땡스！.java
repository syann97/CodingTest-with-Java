import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        int past = Integer.parseInt(st.nextToken());
        int low = past;
        int answer = 0;

        for (int i = 1; i < N; i++) {
            int tmp = Integer.parseInt(st.nextToken());

            if (tmp == past + 1) past++;
            else {
                answer += low;
                low = tmp;
                past = tmp;
            }
        }
        answer += low;

        System.out.println(answer);
    }
}
