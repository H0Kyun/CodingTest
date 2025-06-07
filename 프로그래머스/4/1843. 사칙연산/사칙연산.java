import java.util.*;

class Solution {
    public int solution(String arr[]) {
        int totalOperatorCount = arr.length / 2 + arr.length % 2;
        
        int[][] min = new int[totalOperatorCount][totalOperatorCount];
        int[][] max = new int[totalOperatorCount][totalOperatorCount];
        
        for (int i = 0; i < totalOperatorCount; ++i) {
            for (int j = 0; j < totalOperatorCount; ++j) {
                max[i][j] = Integer.MIN_VALUE;
                min[i][j] = Integer.MAX_VALUE;
            }
        }
        
        for (int i = 0; i < totalOperatorCount; ++i) {
            min[i][i] = Integer.parseInt(arr[i * 2]);
            max[i][i] = Integer.parseInt(arr[i * 2]);
        }
        
        for(int operatorCount = 1; operatorCount < totalOperatorCount; ++operatorCount) {
            int diff = totalOperatorCount - operatorCount;
            
            
            for(int i = 0; i < diff; ++i) {
                int j = i + operatorCount;
                
                for(int k = i; k < j; ++k) {
                    if (arr[k * 2 + 1].equals("+")) {
                        max[i][j] = Math.max(max[i][j], max[i][k] + max[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] + min[k + 1][j]);
                    } else {
                        max[i][j] = Math.max(max[i][j], max[i][k] - min[k + 1][j]);
                        min[i][j] = Math.min(min[i][j], min[i][k] - max[k + 1][j]);
                    }
                }
            }
        }
  
        return max[0][totalOperatorCount - 1];
    }
}