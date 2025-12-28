import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(br.readLine());

        int rest = sb.length() % 3;
        
        if (rest != 0) {
            for (int i = 0; i < 3 - rest; i++) {
                sb.insert(0, "0");
            }
        }

        String s = sb.toString();
        sb.setLength(0);

        char[] bin = s.toCharArray();

        for (int i = 0; i < bin.length; i+= 3) {
            sb.append(binaryToOctal(i, bin));
        }
        System.out.println(sb);
    }

    static int binaryToOctal (int i, char[] bin) {
        return (bin[i] - 48) * 4 + (bin[i+1] - 48) * 2 + (bin[i+2] - 48) * 1;
    }
}
