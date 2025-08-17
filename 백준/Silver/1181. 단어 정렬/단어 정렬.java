import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        Set<String> stringSet = new HashSet<String>();

        for (int i = 0; i < n; ++i) {
            stringSet.add(br.readLine());
        }

        String[] strings = new String[stringSet.size()];

        stringSet.toArray(strings);

        Arrays.sort(strings, (s1, s2) -> {
            if (s1.length() == s2.length()) {
                return s1.compareTo(s2);
            } else {
                return s1.length() - s2.length();
            }
        });

        for (int i = 0; i < stringSet.size(); ++i) {
            System.out.println(strings[i]);
        }
    }
}