import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> primeNumbers = new HashSet();
        
        permutation(new StringBuilder(), new StringBuilder(numbers), primeNumbers);
        
        return primeNumbers.size();
    }
    
    private void permutation(StringBuilder currentNumber, StringBuilder numbers, Set<Integer> primeNumbers) {
        
        if (currentNumber.length() > 0) {
            int number = Integer.parseInt(currentNumber.toString());
        
            if (isPrimeNumber(number)) {
                primeNumbers.add(number);
            }
        }
        
        for(int i = 0; i < numbers.length(); ++i) {
            StringBuilder nextNumber = new StringBuilder(currentNumber.toString()).append(numbers.charAt(i));
            StringBuilder remainingNumbers = new StringBuilder(numbers.toString()).deleteCharAt(i);
            
            permutation(nextNumber, remainingNumbers, primeNumbers);
        }
    }
    
    private boolean isPrimeNumber(int number) {
        if (number <= 1 || (number != 2 && number % 2 == 0)) {
            return false;
        }
        
        for (int i = 3; i <= (int)Math.sqrt(number); i += 2) {
            if (number % i == 0) {
                return false;
            }
        }
        
        return true;
    }
}