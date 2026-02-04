import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    static int[] points = {13, 7, 5, 3, 3, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        float cocjr0208 = 0;
        float ekwoo = 1.5f;

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            cocjr0208 += Integer.parseInt(st.nextToken()) * points[i];
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 6; i++) {
            ekwoo += Integer.parseInt(st.nextToken()) * points[i];
        }

        System.out.println(cocjr0208 > ekwoo ? "cocjr0208" : "ekwoo");
    }
}
