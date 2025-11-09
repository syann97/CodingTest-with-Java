import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();
        String answer;


        if (s.equals("fdsajkl;") || s.equals("jkl;fdsa")) answer = "in-out";
        else if (s.equals("asdf;lkj") || s.equals(";lkjasdf")) answer = "out-in";
        else if (s.equals("asdfjkl;")) answer = "stairs";
        else if (s.equals(";lkjfdsa")) answer = "reverse";
        else answer = "molu";

        System.out.println(answer);
    }
}