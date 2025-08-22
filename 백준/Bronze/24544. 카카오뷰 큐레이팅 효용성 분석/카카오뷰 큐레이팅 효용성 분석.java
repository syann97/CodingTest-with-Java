import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] interests = new int[N];

        int myView = 0;
        int notMyView = 0;

        st = new StringTokenizer(br.readLine());
        for (int i = 0 ; i < N; i++) {
            interests[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int B = Integer.parseInt(st.nextToken());
            if (B == 0) notMyView += interests[i];
            myView += interests[i];
        }

        System.out.println(myView);
        System.out.println(notMyView);
    }
}