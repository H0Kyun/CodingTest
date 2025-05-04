class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        int block = brown / 2 + 2;
        for (int i = 3; i <= block - i; ++i) {
            if ((block - i - 2) * (i - 2) == yellow) {
                answer[0] = block - i;
                answer[1] = i;
                return answer;
            }
        }
        
        return answer;
    }
}