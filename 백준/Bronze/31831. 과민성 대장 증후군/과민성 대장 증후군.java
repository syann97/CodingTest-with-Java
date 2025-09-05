import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int stress = 0;
        int answer = 0;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            stress += Integer.parseInt(st.nextToken());
            stress = Math.max(stress, 0);
            if (stress >= M) answer++;
        }
        System.out.println(answer);
    }
}