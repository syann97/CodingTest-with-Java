import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	static StringTokenizer st;
	static int N;
	static int L;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int d = 0;
		int p = 0;
	
		for (int i = 0; i < N; i++) {
			String s = br.readLine();
			
			if (s.equals("D")) {
				d++;
			}
			else {
				p++;
			}
			
			if (Math.abs(d-p) >= 2) {
				break;
			}
		}
		
		System.out.println(d +":" + p);
		
	}
}
