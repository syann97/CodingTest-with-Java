class Solution {
    boolean solution(String s) {
        int left = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c == '(') left++;
            else {
                if (left == 0) return false;
                left--;
            }
        }

        return left == 0;
    }
}