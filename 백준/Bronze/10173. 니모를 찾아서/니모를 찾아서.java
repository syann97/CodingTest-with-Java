import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String s;

        while (true) {
            s = br.readLine();

            if (s.equals("EOI")) break;

            if (s.toLowerCase().contains("nemo")) sb.append("Found");
            else sb.append("Missing");
            sb.append("\n");
        }

        System.out.println(sb);
    }
}
