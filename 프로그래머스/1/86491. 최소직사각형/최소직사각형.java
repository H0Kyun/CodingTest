class Solution {
    public int solution(int[][] sizes) {
        int maxWidth = 0;
        int maxHeight = 0;
        
        for (int[] size : sizes) {
            if (size[1] > size[0]) {
                int temp = size[0];
                size[0] = size[1];
                size[1] = temp;
            }
            
            if (size[0] > maxWidth) {
                maxWidth = size[0];
            }
            
            if (size[1] > maxHeight) {
                maxHeight = size[1];
            }
        }
        
        
        
        return maxWidth * maxHeight;
    }
}