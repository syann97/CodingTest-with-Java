import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int result = 0;

        int[] cardA = new int[10];
        int[] cardB = new int[10];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) cardA[i] = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 10; i++) cardB[i] = Integer.parseInt(st.nextToken());

        for (int i = 0; i < 10; i++) {
            if (cardA[i] > cardB[i]) result++;
            else if (cardA[i] < cardB[i]) result--;
        }

        System.out.println(result > 0 ? "A" : result == 0 ? "D" : "B");
    }
}
