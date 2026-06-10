class Solution {
    public int solution(int n) {
        int nCount = countOne(n);
        int answer = n;
        
        while (countOne(++answer) != nCount) {}   
        
        return answer;
    }
    
    static int countOne(int n) {
        int count = 0;
        
        while (n > 0) {
            if (n % 2 == 1) {
                count++;
            }
            n >>= 1;
        }
        
        return count;
    }
}