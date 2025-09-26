import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int max = 0;
        String answer = "";

        for (int i = 0; i < 7; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            String seminar = st.nextToken();
            int N = Integer.parseInt(st.nextToken());

            if (N > max) {
                max = N;
                answer = seminar;
            }
        }

        System.out.println(answer);
    }
}