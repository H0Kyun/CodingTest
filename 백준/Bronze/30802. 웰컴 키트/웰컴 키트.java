import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        int numberOfParticipaints = Integer.parseInt(br.readLine());
        
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        
        int[] numberOfSizes = new int[6];
        
        for(int i = 0; st.hasMoreTokens(); ++i) {
            numberOfSizes[i] = Integer.parseInt(st.nextToken());
        }
        
        st = new StringTokenizer(br.readLine(), " ");
        
        int tShirtsOrderQuantity = Integer.parseInt(st.nextToken());
        int penOrderQuantity = Integer.parseInt(st.nextToken());
        
        int numberOfTShirtsBundles = 0;
        
        for(int i = 0; i < numberOfSizes.length; ++i) {
            numberOfTShirtsBundles += numberOfSizes[i] / tShirtsOrderQuantity;
            
            if (numberOfSizes[i] % tShirtsOrderQuantity > 0) {
                ++numberOfTShirtsBundles;
            }
        }
        
        System.out.println(numberOfTShirtsBundles);
        
        int numberOfPenBundles = numberOfParticipaints / penOrderQuantity;
        int numberOfPensPurchasedIndividually = numberOfParticipaints % penOrderQuantity;
        
        System.out.println(numberOfPenBundles + " " + numberOfPensPurchasedIndividually);
        
    }
}