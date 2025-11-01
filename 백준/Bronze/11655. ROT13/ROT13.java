import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();
        
        for (char c : s.toCharArray()) {
            int tmp = c + 13;
            if (Character.isUpperCase(c)) sb.append(tmp <= 'Z' ? (char)tmp : (char)(tmp - 26));
            else if (Character.isLowerCase(c)) sb.append(tmp <= 'z' ? (char)tmp : (char)(tmp - 26));
            else sb.append(c);
        }
        System.out.println(sb);
    }
}
