import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            String s = br.readLine();
            if (s.equals("# 0 0")) break;

            String[] parts = s.split(" ");

            String name = parts[0];
            int age = Integer.parseInt(parts[1]);
            int weight = Integer.parseInt(parts[2]);

            sb.append(name).append(" ");
            if (age > 17 || weight >= 80) sb.append("Senior");
            else sb.append("Junior");

            sb.append("\n");
        }
        System.out.print(sb);
    }
}
