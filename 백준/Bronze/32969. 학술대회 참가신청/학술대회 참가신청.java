import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    static String[] dh = {"social", "history", "language", "literacy"};
    static String[] bd = {"bigdata", "public", "society"};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] words = br.readLine().split(" ");

        boolean flag = false;
        for (String word : words) {
            for (String target : dh) {
                if (word.equals(target)) {
                    System.out.println("digital humanities");
                    flag = true;
                    break;
                }
            }

            for (String target : bd) {
                if (word.equals(target)) {
                    System.out.println("public bigdata");
                    flag = true;
                    break;
                }
            }

            if (flag) break;
        }
    }
}