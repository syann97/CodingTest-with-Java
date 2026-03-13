import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;


public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            st = new StringTokenizer(br.readLine());
            char baseChar = Character.toUpperCase(st.nextToken().charAt(0));

            if (baseChar == '*') break;

            boolean isTautogram = true;
            while (st.hasMoreTokens()) {
                if (baseChar != Character.toUpperCase(Character.toUpperCase(st.nextToken().charAt(0)))) {
                    isTautogram = false;
                    break;
                }
            }
            sb.append(isTautogram ? "Y" : "N").append("\n");
        }

        System.out.print(sb);
    }
}
