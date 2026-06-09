class Solution {
    public int solution(int[] arr) {
        int current = arr[0];
        
        for (int i = 1; i < arr.length; i++) {
            current = lcm(current, arr[i]);
        }
        
        return current;
    }
    
    static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }
    
    static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }
}