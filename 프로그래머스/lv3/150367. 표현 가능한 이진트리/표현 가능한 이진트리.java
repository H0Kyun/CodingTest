import java.lang.StringBuilder;

class Solution {
    
    public int[] solution(long[] numbers) {
        int[] answer = new int[numbers.length];
        
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < numbers.length; i++) {
            // 이진수로 만들면서 StringBuilder에 insert한다.
            while(numbers[i] != 0) {
                sb.insert(0, numbers[i] % 2);
                numbers[i] /= 2;
            }
            
            // 포화 이진트리 높이 구하기
            int height = 1;
            while(2 * height - 1 < sb.length()) {
                height *= 2;
            }
            
            /* 포화 이진트리 제작 
               0을 앞에 추가할 때마다 StringBuilder의 길이가 늘어나는데
               그걸 망각하고 풀어서 런타임 에러가 발생했다.
               위 원인을 너무 늦게 발견했다. */
            int len = sb.length();
            for(int j = 0; j < 2 * height - 1 - len; j++) {
                sb.insert(0, '0');
            }
            
            answer[i] = dfs(sb.toString());
            
            sb.setLength(0);
        }
        return answer;
    }
    
    // 이진트리 유효성 검사하는 dfs
    private int dfs(String sb) {
        if(sb.length() == 1) {
            return 1;
        }
        
        String left = sb.substring(0, sb.length() / 2);
        String right = sb.substring(sb.length() / 2 + 1);
        
        // 왼쪽이나 오른쪽 자식이 1이지만 부모가 0이면 문제 조건을 만족할 수 없다.
        if((left.charAt(left.length() / 2) == '1' || right.charAt(right.length() / 2) == '1') && sb.charAt(sb.length() / 2) == '0') return 0;
        if(dfs(left) == 0) return 0;
        if(dfs(right) == 0) return 0;    

        return 1;
    }
}
