import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        char c = s.charAt(0);

        System.out.println(c == 'F' ? "Foundation" : c == 'C' ? "Claves" : c == 'V' ? "Veritas" : "Exploration");
    }
}
