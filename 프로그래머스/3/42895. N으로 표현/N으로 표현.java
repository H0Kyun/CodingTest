import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        
        List<Set<Integer>> numbers = init(N);

        for (int i = 2; i <= 8; ++i) {
            numbers.add(new HashSet<Integer>());

            Set<Integer> currentNumbers = numbers.get(i);
            currentNumbers.add(this.createConsecutiveEqualNumber(i, N));
            
            // 아래 처럼 각 연산 조합으로 나오는 수를 모두 구하기 위해 반복문 수행
            // 1 | 2   | 3         | 4
            // 1 | 1 1 | 2 1 / 1 2 | 3 1 / 1 3 / 2 2
            for (int j = 1; j < i; ++j) {
                Set<Integer> x = numbers.get(j);
                Set<Integer> y = numbers.get(i - j);
                
                this.calculate(x, y, currentNumbers);
            }
            
            
            if (numbers.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
    
    private List<Set<Integer>> init(int N) {
        List<Set<Integer>> numbers = new ArrayList<Set<Integer>>();
        numbers.add(new HashSet<Integer>());
        numbers.add(new HashSet<Integer>());
        numbers.get(1).add(N);
        
        return numbers;
    }
    
    private void calculate(Set<Integer> x, Set<Integer> y, Set<Integer> currentNumbers) {
        for(int xValue : x) {
            for (int yValue : y) {
                currentNumbers.add(xValue + yValue);
                currentNumbers.add(xValue * yValue);
            
                if (xValue - yValue > 0) {
                    currentNumbers.add(xValue - yValue);
                }

                if (xValue != 0) {
                    currentNumbers.add(yValue / xValue);
                }
            }
        }
    }
    
    private int createConsecutiveEqualNumber(int index, int N) {
        int temp = N;
        
        for(int i = 1; i < index; ++i) {
            temp *= 10;
            temp += N;
        }
        
        return temp;
    }
}