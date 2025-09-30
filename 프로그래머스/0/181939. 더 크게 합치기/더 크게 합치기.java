class Solution {
    public int solution(int a, int b) {
        String strA = Integer.toString(a);
        String strB = Integer.toString(b);
        
        return Math.max(Integer.parseInt(strA + strB), Integer.parseInt(strB + strA));
    }
}