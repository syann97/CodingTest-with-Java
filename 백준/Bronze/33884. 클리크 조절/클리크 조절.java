import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long avgX = 0;
        long avgY = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            avgX -= Integer.parseInt(st.nextToken());
            avgY -= Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            avgX += Integer.parseInt(st.nextToken());
            avgY += Integer.parseInt(st.nextToken());
        }

        System.out.print((avgX / N) + " " + (avgY / N));
    }
}