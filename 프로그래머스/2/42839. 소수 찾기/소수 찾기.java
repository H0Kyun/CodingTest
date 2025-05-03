import java.util.*;

class Solution {
    public int solution(String numbers) {
        Set<Integer> primeNumbers = new HashSet();
        for(int i = 0; i < numbers.length(); ++i) {
            dfs(i, new boolean[numbers.length()], new StringBuilder().append(numbers.charAt(i)), numbers, primeNumbers);
        }
        
        return primeNumbers.size();
    }
    
    private void dfs(int index, boolean[] visited, StringBuilder currentNumber, String numbers, Set<Integer> primeNumbers) {
        
        visited[index] = true;
        int number = Integer.parseInt(currentNumber.toString());
        
        if (isPrimeNumber(number)) {
            primeNumbers.add(number);
        }
        
        for(int i = 0; i < numbers.length(); ++i) {
            if (visited[i]) {
                continue;
            }
            
            dfs(i, Arrays.copyOf(visited, visited.length), new StringBuilder(currentNumber.toString()).append(numbers.charAt(i)), numbers, primeNumbers);
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