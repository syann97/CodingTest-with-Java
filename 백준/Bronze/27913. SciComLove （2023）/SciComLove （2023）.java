import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static final String word = "SciComLove";
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());
        int Q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N / 10; i++) sb.append(word);

        sb.append(word, 0, N % 10);
        String s = sb.toString();
        boolean[] isUpper = new boolean[N];

        for (int i = 0; i < N; i++) {
            char c = s.charAt(i);
            if (Character.isUpperCase(c)) isUpper[i] = true;
        }

        sb = new StringBuilder();
        for (int i = 0; i < Q; i++) {
            int level = Integer.parseInt(br.readLine());
            int answer = 0;

            for (int j = 0; j < N; j++) {
                if (j + 1 <= level && !isUpper[j]) answer++;
                if (j + 1 > level && isUpper[j]) answer++;
            }
            sb.append(answer).append("\n");
        }
        System.out.print(sb);
    }
}