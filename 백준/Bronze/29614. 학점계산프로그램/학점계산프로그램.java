import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int length = s.length();
        int index = 0;
        double total = 0;
        int count = 0;

        while (index < length) {
            char c = s.charAt(index);
            if (c == '+') total += 0.5;
            else {
                if (c == 'A') total += 4;
                else if (c == 'B') total += 3;
                else if (c == 'C') total += 2;
                else if (c == 'D') total += 1;
                count++;
            }
            index++;
        }
        System.out.println(total / count);
    }
}