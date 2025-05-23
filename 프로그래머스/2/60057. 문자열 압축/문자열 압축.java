class Solution {
    public int solution(String s) {
        int min = s.length();
        int stack = 1;
        
        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String base = s.substring(0, i);
            
            for (int j = i; j <= s.length(); j += i) {
                int end = Math.min(j + i, s.length());
                String target = s.substring(j, end);
                if (base.equals(target)) {
                    stack++;
                }
                else {
                    if (stack >= 2) {
                        sb.append(stack);
                    }
                    sb.append(base);
                    base = target;
                    stack = 1;
                }
            }
            sb.append(base);
            min = Math.min(min, sb.length());
            
        }
        return min;
    }
}