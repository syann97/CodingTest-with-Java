import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] S = new int[N];
        int[] E = new int[N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken();
            S[i] = Integer.parseInt(st.nextToken());
            E[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(S);
        Arrays.sort(E);

        int max = 0;
        int stack = 0;
        int s = 0;
        int e = 0;
        while (s < N) {
            if (S[s] < E[e]) {
                stack++;
                max = Math.max(max, stack);
                s++;
            }
            else {
                stack--;
                e++;
            }
        }

        System.out.println(max);
    }
}