import java.util.Arrays;

class Solution {
    public int solution(int[][] routes) {
        // 차량이 나간 시점 순으로 정렬
        Arrays.sort(routes, (o1, o2) -> Integer.compare(o1[1], o2[1]));
        
        // 제일 먼저 나간 차량 위치에 카메라 설치
        int cameraPosition = routes[0][1];
        int answer = 1;
        
        for (int[] entryAndExistRecords : routes) {
            // 차량이 들어오고 나간 시점 사이에 카메라가 있는 경우
            if (entryAndExistRecords[0] <= cameraPosition && entryAndExistRecords[1] >= cameraPosition) {
                continue;
            }
            
            // 첫 차량 나가고 난 후 들어온 차량이 나간 위치에 카메라 설치 
            cameraPosition = entryAndExistRecords[1];
            ++answer;
        }
        
        return answer;
    }
}