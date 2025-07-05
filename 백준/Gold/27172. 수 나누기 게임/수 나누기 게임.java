import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.StringTokenizer;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        boolean[] exists = new boolean[1000001];
        int[] scores = new int[1000001];
        int[] cards = new int[N];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
            exists[cards[i]] = true;
        }


        for (int card : cards) {
            for (int n = card * 2; n <= 1000000; n += card) {
                if (exists[n]) {
                    scores[card]++;
                    scores[n]--;
                }
            }
        }

        for (int i = 0; i < N; i++) {
            sb.append(scores[cards[i]]).append(" ");
        }

        System.out.println(sb);
    }
}