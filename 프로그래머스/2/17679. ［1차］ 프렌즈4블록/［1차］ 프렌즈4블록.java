import java.util.*;

class Solution {
    static int point;
    static char[][] grid;
    static int R;
    static int C;
    public int solution(int m, int n, String[] board) {
        point = 0;
        grid = new char[m][];
        R = m;
        C = n;
        
        for (int i = 0; i < board.length; i++) {
            grid[i] = board[i].toCharArray();
        }
        
        while (isExplode()) {
            setBoard();
        }
        
        return point;
    }
    
    static boolean isExplode() {
        Set<List<Integer>> set = new HashSet<>();
        
        for (int i = 0; i < R-1; i++) {
            for (int j = 0; j < C-1; j++) {
                char c = grid[i][j];
                if (c == ' ') continue;
                
                if (c == grid[i][j+1] && c == grid[i+1][j] && c == grid[i+1][j+1]) {
                    set.add(Arrays.asList(i, j));
                    set.add(Arrays.asList(i, j+1));
                    set.add(Arrays.asList(i+1, j));
                    set.add(Arrays.asList(i+1, j+1));
                }
            }
        }
        
        if (set.isEmpty()) return false;
        point += set.size();
        
        for (List<Integer> pos : set) {
            System.out.println(pos);
            grid[pos.get(0)][pos.get(1)] = ' ';
        }
        
        return true;
    }
    
    static void setBoard() {
        ArrayDeque<Character> stack = new ArrayDeque<>();
        for (int col = 0; col < C; col++) {
            for (int row = 0; row < R; row++) {
                if (grid[row][col] != ' ') {
                    stack.offerLast(grid[row][col]);
                }
                grid[row][col] = ' ';
            }
            
            int row = R-1;
            
            while(!stack.isEmpty()) {
                grid[row][col] = stack.pollLast();
                row--;
            }
        }
    }
}