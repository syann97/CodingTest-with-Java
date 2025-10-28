import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] input = br.readLine().split(" ");

        int m = Integer.parseInt(input[1]);
        int k = Integer.parseInt(input[2]);

        System.out.println((long) (k + 1) * m);
    }
}