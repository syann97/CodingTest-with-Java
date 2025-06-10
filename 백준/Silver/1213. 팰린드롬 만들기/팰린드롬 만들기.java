import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        int[] count = new int[26];

        for (char c : s.toCharArray()) {
            count[c - 'A']++;
        }


        int odd = 0;

        for (int cnt : count) {
            if (cnt % 2 == 1) odd++;
        }

        StringBuilder sb = new StringBuilder();
        ArrayDeque<Character> back = new ArrayDeque<>();

        char center = ' ';

        if (odd <= 1) {
            for (int i = 0; i < count.length; i++) {
                int num = count[i];
                if (num > 0) {
                    char c = (char)('A' + i);
                    if (num % 2 == 1) center = c;
                    for (int j = 0; j < num / 2; j++) {
                        sb.append(c);
                        back.offer(c);
                    }
                }
            }
            if (odd == 1) sb.append(center);
            while (!back.isEmpty()) {
                char c = back.pollLast();
                sb.append(c);
            }
            System.out.println(sb);
        }
        else {
            System.out.println("I'm Sorry Hansoo");
        }
    }
}