import java.io.*;
import java.util.*;

class Solution {
	static StringTokenizer st;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        
        for (int t = 1; t <= T; t++) {
        	int N = Integer.parseInt(br.readLine());
        	int[] arr = new int[N];
        	
        	int max = 0;
        	st = new StringTokenizer(br.readLine());
        	for (int i = 0; i < N; i++) {
        		arr[i] = Integer.parseInt(st.nextToken());
        		max = Math.max(max, arr[i]);
        	}
        	
        	int even = 0;
        	int odd = 0;
        	for (int i = 0; i < N; i++) {
        		int rest = max - arr[i];
        	
        		even += rest / 2;
        		odd += rest % 2;
        	}
        	
        	int diff = even - odd;
        	if (diff > 1) {
        	    int change = (diff + 1) / 3;

        	    even -= change;
        	    odd += change * 2;
        	}
        	
        	int answer = Math.max(even * 2, odd * 2 - 1);
        	
        	sb.append("#").append(t).append(" ").append(answer).append("\n");
        }
        System.out.print(sb);
    }
}
