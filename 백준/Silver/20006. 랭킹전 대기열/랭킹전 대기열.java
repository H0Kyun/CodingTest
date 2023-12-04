import java.io.*;
import java.util.*;

public class Main {
    static class User {
        int level;
        String nickname;

        public User(int level, String nickname) {
            this.level = level;
            this.nickname = nickname;
        }
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        int p = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        List<List<User>> roomList = new ArrayList<>();

        for(int i = 0; i < p; ++i) {
            st = new StringTokenizer(br.readLine(), " ");

            User user = new User(Integer.parseInt(st.nextToken()), st.nextToken());
            boolean isEntered = false;
            
            // 들어갈 수 있는 방 확인
            for (List<User> room : roomList) {
                if (room.get(0).level - 10 <= user.level && user.level <= room.get(0).level + 10) {
                    if (room.size() < m) {
                        room.add(user);
                        isEntered = true;
                        break;
                    }
                }
            }

            // 들어갈 방 없으면 생성후 추가
            if (!isEntered) {
                roomList.add(new ArrayList<User>());
                roomList.get(roomList.size() - 1).add(user);
            }
        }

        for (List<User> room : roomList) {
            if (room.size() == m) {
                System.out.println("Started!");
            } else {
                System.out.println("Waiting!");
            }

            // 정렬 후 출력
            room.sort(Comparator.comparing(user -> user.nickname));
            room.forEach(user -> System.out.println(user.level + " " + user.nickname));
        }

        br.close();
    }
}