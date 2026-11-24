import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {
	static StringTokenizer st;
	static final int RANGE = 1000000;
	static final int L = 1048576;
	static long[] tree = new long[L<<1];
	static int n;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		n = Integer.parseInt(br.readLine());
		
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			if (A == 2) {
				int C = Integer.parseInt(st.nextToken());
				update(L+B-1, C);
			}
			else {
				sb.append(search(1, B)).append("\n");
			}
		}
		
		System.out.println(sb);
	}
	
	static long search(int index, int target){
		while (index < L) {
			tree[index] -= 1;
			
			long left = tree[index<<1];
			
			if (left < target) {
				target -= left;
				index = (index<<1)|1;
			}
			else {
				index = index<<1;
			}
		}
		
		tree[index] -= 1;
		
		return index - L + 1;
	}
	
	static void update(int index, int value) {
		while (index >= 1) {
			tree[index] += value;
			index >>= 1;
		}
	}
}
