import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

class User implements Comparable<User> {
    private final int age;
    private final String name;

    User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    @Override
    public int compareTo(User o) {
        return this.age - o.getAge();
    }
}

public class Main {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        List<User> users = new ArrayList<>();

        for (int i = 0; i < n; ++i) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int age = Integer.parseInt(st.nextToken());
            String name =st.nextToken();

            users.add(new User(age, name));
        }

        Collections.sort(users);

        StringBuilder sb = new StringBuilder();
        
        for (User user : users) {
            sb.append(user.getAge()).append(" ").append(user.getName()).append("\n");
        }
        
        System.out.println(sb);
    }
}