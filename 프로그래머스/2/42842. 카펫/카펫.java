class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = {};
        int area = brown + yellow;
        for (int row = brown; row >= 2; row--) {
            if (area % row == 0) {
                int col = area / row;
                int inner = (row - 2) * (col - 2);
                if (inner == yellow) {
                    return new int[]{row, col};
                }
            }
        }
        
        return answer;
    }
}