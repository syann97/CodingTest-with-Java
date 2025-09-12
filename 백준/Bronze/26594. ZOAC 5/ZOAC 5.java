import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char target = s.charAt(0);
        int count = 0;

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != target) break;
            count++;
        }
        
        System.out.println(count);
    }
}