import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String tmp = br.readLine();

        String[] sub = tmp.split("-");

        int result = 0;
        String[] first = sub[0].split("\\+");
        for (String s : first) result += Integer.parseInt(s);

        for (int i = 1; i < sub.length; i++) {
            String[] nums = sub[i].split("\\+");
            for (String s : nums) result -= Integer.parseInt(s);
        }

        System.out.println(result);
    }
}
