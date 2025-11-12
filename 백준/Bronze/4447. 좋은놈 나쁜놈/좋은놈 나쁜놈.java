import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
     public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());

        while (N-->0) {
            String s = br.readLine();
            String lower = s.toLowerCase();

            int gCount = 0;
            int bCount = 0;
            for (char c : lower.toCharArray()) {
                if (c == 'g') gCount++;
                else if (c == 'b')bCount++;
            }

            sb.append(s).append(" is ").append(gCount == bCount ? "NEUTRAL" : gCount > bCount ? "GOOD" : "A BADDY").append("\n");
        }
         System.out.print(sb);
    }
}