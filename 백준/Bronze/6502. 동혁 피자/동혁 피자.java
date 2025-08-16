import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = 1;
        while (true) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken());
            if (r == 0) break;

            int w = Integer.parseInt(st.nextToken());
            int l = Integer.parseInt(st.nextToken());

            boolean isFit = isPizzaFitOnTable(r, w, l);

            sb.append("Pizza " + T + (isFit ? " fits on the table." : " does not fit on the table.")).append("\n");
            T++;
        }
        System.out.println(sb);
    }


    private static boolean isPizzaFitOnTable(int r, int w, int l) {
        return Math.sqrt(w * w + l * l) <= 2 * r;
    }
}