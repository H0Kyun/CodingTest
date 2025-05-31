import java.util.*;

class Solution {
    public int solution(int N, int number) {
        if (N == number) {
            return 1;
        }
        
        List<Set<Integer>> numbers = new ArrayList<Set<Integer>>();
        numbers.add(new HashSet<Integer>());
        numbers.get(0).add(N);
        numbers.add(new HashSet<Integer>());
        numbers.get(1).add(N);

        for (int i = 2; i <= 8; ++i) {
            numbers.add(new HashSet<Integer>());

            Set<Integer> currentNumbers = numbers.get(i);
            currentNumbers.add(this.createConsecutiveEqualNumber(i, N));
            
            for (int j = 1; j < i; ++j) {
                Set<Integer> x = numbers.get(j);
                Set<Integer> y = numbers.get(i - j);
                
                calculate(x, y, currentNumbers);
            }
            
            
            if (numbers.get(i).contains(number)) {
                return i;
            }
        }
        
        return -1;
    }
    
    public void calculate(Set<Integer> x, Set<Integer> y, Set<Integer> currentNumbers) {
        for(int xValue : x) {
            for (int yValue : y) {
                currentNumbers.add(xValue + yValue);
                currentNumbers.add(xValue * yValue);
            
                if (xValue - yValue > 0) {
                    currentNumbers.add(xValue - yValue);
                }

                if (yValue - xValue > 0) {
                    currentNumbers.add(yValue - xValue);   
                }

                if (xValue != 0) {
                    currentNumbers.add(yValue / xValue);
                }

                if (yValue != 0) {
                    currentNumbers.add(xValue / yValue);
                }
            }
        }
    }
    
    public void calculate(List<Set<Integer>> numbers, int index, int N) {
        Set<Integer> previousNumbers = numbers.get(index - 1);
        Set<Integer> currentNumbers = numbers.get(index);
        
        currentNumbers.add(this.createConsecutiveEqualNumber(index, N));
        
        Iterator<Integer> iter = previousNumbers.iterator();

        while(iter.hasNext()) {
            int temp = iter.next();
            
            currentNumbers.add(temp + N);
            currentNumbers.add(temp * N);
            currentNumbers.add(temp / N);
            
            if (temp - N > 0) {
                currentNumbers.add(temp - N);
            }
            
            if (N - temp > 0) {
                currentNumbers.add(N - temp);   
            }
            
            if (temp != 0) {
                currentNumbers.add(N / temp);
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