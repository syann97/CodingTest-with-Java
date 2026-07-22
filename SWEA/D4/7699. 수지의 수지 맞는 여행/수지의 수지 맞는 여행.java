import java.io.*;
import java.util.*;


public class Solution {
	static StringTokenizer st;
	static int[] dy = {-1, 0, 1, 0};
	static int[] dx = {0, -1, 0, 1};
	static int[][] area;
	static int answer;
	static int R;
	static int C;
	public static void main(String[] args) throws Exception {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		int T = Integer.parseInt(br.readLine());
		
		for (int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			
			answer = 0;
			area = new int[R][C];
			
			for (int i = 0; i < R; i++) {
				String s = br.readLine();
				
				for (int j = 0; j < C; j++) {
					area[i][j] = s.charAt(j) - 'A';
				}
			}
			
			int mask = 1 << area[0][0];
			dfs(0, 0, 1, mask);
			
			sb.append("#").append(t).append(" ").append(answer).append("\n");
		}
		
		System.out.println(sb);
	}
	
	static void dfs(int y, int x, int count, int mask) {
		for (int d = 0; d < 4; d++) {
			int ny = y + dy[d];
			int nx = x + dx[d];
			
			if (ny < 0 || ny >= R || nx < 0 || nx >= C) continue;
			
			int bit = 1 << area[ny][nx];
			
			if ((mask & bit) != 0) continue;
		
			dfs(ny, nx, count + 1, mask | bit);
		}
		
		answer = Math.max(answer, count);
	}
}
