import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String a = br.readLine();
        String b = br.readLine();

        int[] born = new int[3];
        int[] day = new int[3];

        int i = 0;
        for (String s : a.split(" ")) {
            born[i] = Integer.parseInt(s);
            i++;
        }

        i = 0;
        for (String s : b.split(" ")) {
            day[i] = Integer.parseInt(s);
            i++;
        }

        int ans1 = ans1(born, day);
        int ans2 = day[0] - born[0] + 1;

        System.out.println(ans1);
        System.out.println(ans2);
        System.out.println(ans2 - 1);
    }

    private static int ans1(int[] born, int[] day) {
        int age = day[0] - born[0];
        if (age == 0) return 0;
        else if (born[1] > day[1] || (born[1] == day[1] && born[2] > day[2])) {
            return age - 1;
        }
        else return age;
    }
}
