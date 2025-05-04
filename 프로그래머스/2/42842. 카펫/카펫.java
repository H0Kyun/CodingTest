class Solution {
    public int[] solution(int brown, int yellow) {
        // 2 * 가로 + 2 * (세로 - 2)
        // 가로 * 2 는 위아래, 2 * (세로 - 2)는 좌우 -2 하는 이유는 위아래에서 구한 값을 빼기 위함
        int sumOfWidthAndhHeight = (brown + 4) / 2;
        int productOfWidthAndhHeight = brown + yellow; // 전체 면적
        
        return rootFormulas(sumOfWidthAndhHeight, productOfWidthAndhHeight);
    }
    
    public int[] rootFormulas(int a, int b) {
        // 합과 곱을 알면 이차방정식으로 근을 구할 수 있음
        // (x - alpha)(x - beta) = 0
        // x^2 - (합)x + 곱 = 0
        int discriminant = (int)Math.sqrt(a * a - 4 * b);
        int[] answer = {(a + discriminant) / 2, (a - discriminant) / 2};
        
        return answer;
    }
}