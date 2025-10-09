import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] years = new int[N];

        for (int i = 0; i < N; i++) {
            years[i] = Integer.parseInt(st.nextToken());
        }

        int gap = years[1] - years[0];
        int last_year = years[N-1];

        System.out.println(last_year + gap);
    }
}