import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int[] kinds = new int[d+1];
        int[] sequence = new int[N];
        int answer = 1;
        kinds[c]++;

        for (int i = 0; i < N; i++) sequence[i] = Integer.parseInt(br.readLine());

        for (int i = 0; i < k; i++) {
            if (kinds[sequence[i]] == 0) answer++;
            kinds[sequence[i]]++;
        }

        int count = answer;
        for (int i = 1; i < N; i++) {
            int poll = sequence[i-1];
            if (--kinds[poll] == 0) count--;

            int add = sequence[(i+k-1)%N];
            if (kinds[add]++ == 0) count++;

            answer = Math.max(answer, count);
        }

        System.out.println(answer);
    }
}
