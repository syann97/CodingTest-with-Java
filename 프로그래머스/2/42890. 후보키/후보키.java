import java.util.*;

class Solution {
    public int solution(String[][] relation) {
        int colCount = relation[0].length;
        int rowCount = relation.length;
        
        // 1. 모든 속성 조합을 탐색하며 유일성을 만족하는 조합(키)들을 찾는다.
        List<Integer> uniqueKeys = new ArrayList<>();
        // 비트마스크를 이용해 모든 속성 조합 생성 (1부터 2^colCount - 1 까지)
        for (int i = 1; i < (1 << colCount); i++) {
            Set<String> keySet = new HashSet<>();
            
            // 모든 행에 대해 해당 조합으로 키를 생성
            for (int j = 0; j < rowCount; j++) {
                StringBuilder keyBuilder = new StringBuilder();
                // 현재 조합(i)에 포함된 속성(컬럼)들을 찾는다
                for (int k = 0; k < colCount; k++) {
                    if ((i & (1 << k)) != 0) { // k번째 비트가 켜져 있으면 k번째 컬럼을 포함
                        keyBuilder.append(relation[j][k]).append(",");
                    }
                }
                keySet.add(keyBuilder.toString());
            }
            
            // 생성된 키의 개수가 전체 행의 개수와 같으면 유일성을 만족
            if (keySet.size() == rowCount) {
                uniqueKeys.add(i);
            }
        }
        
        // 2. 유일성을 만족하는 키들 중에서 최소성을 만족하는 후보 키를 걸러낸다.
        List<Integer> candidateKeys = new ArrayList<>();

        for (int uniqueKey : uniqueKeys) {
            boolean isMinimal = true;
            // 이미 찾은 후보 키들 중에 현재 키의 부분집합이 있는지 확인
            for (int candidateKey : candidateKeys) {
                if ((uniqueKey & candidateKey) == candidateKey) {
                    // 현재 키가 기존 후보 키를 포함하면 최소성 위배
                    isMinimal = false;
                    break;
                }
            }
            
            if (isMinimal) {
                candidateKeys.add(uniqueKey);
            }
        }
        
        return candidateKeys.size();
    }
}