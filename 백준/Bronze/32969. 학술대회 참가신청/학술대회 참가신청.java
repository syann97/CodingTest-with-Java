import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    static String[] dh = {"social", "history", "language", "literacy"};
    static String[] bd = {"bigdata", "public", "society"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");

        int dhCount = 0;
        int bdCount = 0;
        boolean flag = false;
        for (String word : words) {
            for (String target : dh) {
                if (word.equals(target)) {
                    flag = true;
                    dhCount++;
                    break;
                }
            }

            for (String target : bd) {
                if (word.equals(target)) {
                    flag = true;
                    bdCount++;
                    break;
                }
            }

            if (flag) break;
        }

        System.out.println(dhCount >= bdCount ? "digital humanities" : "public bigdata");
    }
}