class Solution {
    public int[] solution(String s) {
        int[] answer = {};
        
        int removeZeroCount = 0;
        int parseCount = 0;
        
        while (!s.equals("1")) {
            int size = s.length();
            
            s = s.replaceAll("0", "");
            int resize = s.length();
            
            removeZeroCount += size - resize;
            s = sizeParseBinary(resize);
            parseCount++;
        }
        return new int[] {parseCount, removeZeroCount};
    }
    
    static String sizeParseBinary(int size) {
        StringBuilder sb = new StringBuilder();
        while (size > 0) {
            sb.append(size % 2 == 0 ? "0" : "1");
            size >>= 1;
        }
        
        System.out.println(sb.toString());
        return sb.toString();
    }
}