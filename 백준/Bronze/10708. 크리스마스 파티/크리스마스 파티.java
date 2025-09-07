import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


class Main {
    static StringTokenizer st;
    static int[] parent;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        int[] answer = new int[M];
        int[] points = new int[N+1];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            answer[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 1; j <= N; j++) {
                int guess = Integer.parseInt(st.nextToken());
                if (guess == answer[i]) points[j]++;
                else points[answer[i]]++;
            }
        }

        for (int i = 1; i <= N; i++) {
            System.out.println(points[i]);
        }
    }
}