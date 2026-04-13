import java.util.*;

class Solution {
    static int count;
    static int N;
    static int M;
    static boolean[][] isMatching;
    static Set<Integer> set;
    public int solution(String[] user_id, String[] banned_id) {
        count = 0;
        N = user_id.length;
        M = banned_id.length;
        isMatching = new boolean[N][M];
        set = new HashSet<>();
        
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                setMatching(i, j, user_id[i], banned_id[j]);
            }
            System.out.println(Arrays.toString(isMatching[i]));
        }
        
        dfs(0, 0, new boolean[M], 1);
        
        
        // 1. 하나의 아이디가 여러 banned_id의 공통사항에 해당될 때
        // 2. 여러 아이디가 하나의 banned_id의 공통사항에 해당할 때
        // 문제를 잘 읽자
        // 순서와 관계없이 -> 순열 문제
        // 중복되면 안됨 단 한명의 사람은 단 하나의 밴에 매핑 되도록 구현
        // dfs를 통해서 매칭되는지 확인하고 매핑되는 순서대로 dfs 수행해보기
    
        
        return count;
    }
    
    static void setMatching(int i, int j, String user_id, String banned_id) {
        if (user_id.length() != banned_id.length()) {
            return;
        }
        
        for (int k = 0; k < user_id.length(); k++) {
            char banChar = banned_id.charAt(k);            
            char userChar = user_id.charAt(k); 
            if (banChar == '*') continue;            
            if (userChar != banChar) return;
        }
        
        isMatching[i][j] = true;
    }
    
    static void dfs (int user, int idx, boolean[] isUsed, int hash) {
        if (idx == M) {
            if (!set.contains(hash)) {
                set.add(hash);
                count++;
            }
            return;
        }
        
        if (user >= N) return;
        
        // 문제 어떤 banned_id에도 매칭되어야 함
        
        boolean flag = false;
        
        // 해당 유저의 매핑되는 banned_id 탐색
        for (int i = 0; i < M; i++) {
            if (isMatching[user][i] && !isUsed[i]) {
                isUsed[i] = true;
                dfs(user + 1, idx + 1, isUsed, (hash << 3) + user);
                isUsed[i] = false;
            }
        }
        
        if (!flag) dfs(user+1, idx, isUsed, hash);
    }
}