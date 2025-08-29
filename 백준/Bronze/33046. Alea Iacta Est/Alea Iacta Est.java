import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    static int[] turn = {1, 2, 3, 4};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int answer = -2;

        st = new StringTokenizer(br.readLine());
        answer += Integer.parseInt(st.nextToken());
        answer += Integer.parseInt(st.nextToken());


        st = new StringTokenizer(br.readLine());
        answer += Integer.parseInt(st.nextToken());
        answer += Integer.parseInt(st.nextToken());

        System.out.println(turn[answer % 4]);
    }
}
