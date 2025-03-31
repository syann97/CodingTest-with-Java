import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st;
    static String[] operation = {"ADD", "SUB", "MOV", "AND", "OR", "NOT", "MULT", "LSFTL", "LSFTR", "ASFTR", "RL", "RR"};
    static String opBinary;
    static String opcode;
    static boolean isC;
    static int rD;
    static int rA;
    static int rB;
    static int N;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            opcode = st.nextToken();
            rD = Integer.parseInt(st.nextToken());
            rA = Integer.parseInt(st.nextToken());
            rB = Integer.parseInt(st.nextToken());
            logic();
        }
        System.out.println(sb);
    }

    static void logic() {
        for (int i = 0; i < operation.length; i++) {
            if (opcode.equals(operation[i]) || opcode.equals(operation[i] + "C")) {
                opBinary = String.format("%4s", Integer.toBinaryString(i)).replace(' ', '0');
                sb.append(opBinary);

                // idx 0 ~ 4
                if (opcode.charAt(opcode.length() - 1) == 'C') {sb.append(1); isC=true;}
                else {sb.append(0); isC = false;};

                // idx 5
                sb.append(0);

                // idx 6 ~ 8
                sb.append(String.format("%3s", Integer.toBinaryString(rD)).replace(' ', '0'));

                // idx 9 ~ 11
                if (opBinary.equals("0010") || opBinary.equals("0101")) sb.append("000");
                else sb.append(String.format("%3s", Integer.toBinaryString(rA)).replace(' ', '0'));

                // idx 12 ~ 15
                if (isC) {
                    sb.append(String.format("%4s", Integer.toBinaryString(rB)).replace(' ', '0'));
                }
                else sb.append(String.format("%3s", Integer.toBinaryString(rB)).replace(' ', '0')).append('0');
                sb.append('\n');
                return;
            }
        }
    }
}
