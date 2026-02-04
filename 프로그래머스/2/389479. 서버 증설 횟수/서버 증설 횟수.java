class Solution {
    public int solution(int[] players, int m, int k) {
        int answer = 0;
        
        // 1. default limit
        int limit = m - 1;
        
        // 2. 언제 증설된 서버가 감소되는지
        int[] decreaseServerCount = new int[24];
        
        // 3. 얼마나 증설해야되는지
        for (int i = 0; i < 24; i++) {
            limit -= decreaseServerCount[i] * m;
            int extraPlayers = players[i] - limit;
            int expansionServerCount = 0;
            
            if (extraPlayers > 0) {
                expansionServerCount = (extraPlayers / m) + (extraPlayers % m > 0 ? 1 : 0);
                answer += expansionServerCount;
                
                limit += m * expansionServerCount;
                if (i + k <= 23) {
                    decreaseServerCount[i+k] = expansionServerCount;
                }
            }
        }
        
        return answer;
    }
}