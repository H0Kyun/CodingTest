class Solution {
    public int solution(String name) {
        int answer = 0;
        
        int aCount = 0;
        int minMovement = name.length() - 1;
        for(int i = 0; i < name.length(); i++) {
            
            answer += Math.min(name.charAt(i) - 'A', 'Z' - name.charAt(i) + 1);
            
            aCount = i + 1;
            while(aCount < name.length() && name.charAt(aCount) == 'A') {
                aCount++;
            }
            minMovement = Math.min(minMovement, i * 2 + (name.length() - aCount));
            minMovement = Math.min(minMovement, i + (name.length() - aCount) * 2);
        }
        
        return answer + minMovement;
    }
}