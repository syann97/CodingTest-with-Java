import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int D = Integer.parseInt(br.readLine());

        String s;

        if (M == 2) {
            if (D == 18) s = "Special";
            else if (D > 18) s = "After";
            else s = "Before";
        }
        else if (M > 2) s = "After";
        else s = "Before";

        System.out.println(s);
    }
}