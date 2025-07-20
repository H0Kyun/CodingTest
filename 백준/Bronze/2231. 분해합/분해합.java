import java.io.BufferedReader;
import java.io.InputStreamReader;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int number = Integer.parseInt(br.readLine());
        
        for (int i = 1; i < number; ++i) {
            String constructorCandidate = Integer.toString(i);
            
            int candidateNumber = i;
            for (int j = 0; j < constructorCandidate.length(); ++j) {
                candidateNumber += Character.getNumericValue(constructorCandidate.charAt(j));
            }
            
            if (candidateNumber == number) {
                System.out.println(constructorCandidate);
                return;
            }
        }
        
        System.out.println(0);
    }
}