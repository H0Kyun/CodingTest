import java.lang.StringBuilder;

class Solution {
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++) {
            
            while(numbers[i] != 0) {
                sb.insert(0, numbers[i] % 2);
                numbers[i] /= 2;
            }
            
            int treeLen = 0;
            int exp = 1;
            while(true) {
                treeLen = (int)Math.pow(2, exp++) - 1;
                if (treeLen >= sb.length()) break;
            }
            
            int len = sb.length();
            for(int j = 0; j < treeLen - len; j++) {
                sb.insert(0, '0');
            }
            
            
            answer[i] = dfs(sb.toString());
            
            sb.setLength(0);
            
        }
        return answer;
    }
    
    private int dfs(String sb) {
        if(sb.length() == 1) {
            return 1;
        }
        
        String left = sb.substring(0, sb.length() / 2);
        String right = sb.substring(sb.length() / 2 + 1);
        
        if((left.charAt(left.length() / 2) == '1' || right.charAt(right.length() / 2) == '1') && sb.charAt(sb.length() / 2) == '0') return 0;
            if(dfs(left) == 0) return 0;
            if(dfs(right) == 0) return 0;    

        return 1;
    }
}