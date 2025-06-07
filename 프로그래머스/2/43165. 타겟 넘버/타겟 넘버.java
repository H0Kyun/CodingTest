class Solution {
    private int[] numbers;
    private int target;
    
    public int solution(int[] numbers, int target) {
        this.numbers = numbers;
        this.target = target;
        
        return dfs(0, 0);
    }
    
    public int dfs(int index, int number) {
        if (index == this.numbers.length) {
            if (number == this.target) {
                return 1;
            } else {
                return 0;
            }
        }
        
        int nextIndex = index + 1;
        
        return dfs(nextIndex, number + numbers[index]) + dfs(nextIndex, number - numbers[index]);
    }
}