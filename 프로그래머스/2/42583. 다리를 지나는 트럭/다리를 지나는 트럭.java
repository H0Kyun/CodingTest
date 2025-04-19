import java.util.*;

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitingTrucks = new ArrayDeque();
        Queue<Integer> crossingTrucks = new ArrayDeque();
        Queue<Integer> crossedTrucks = new ArrayDeque();
        
        for (int truck : truck_weights) {
            waitingTrucks.offer(truck);
        }
        
        int time = 0;
        int totalWeights = 0;
        
        while(true) {
            ++time;
            
            if (!crossingTrucks.isEmpty() && crossingTrucks.peek() + bridge_length == time) {
                crossingTrucks.poll();
                if (!crossedTrucks.isEmpty()) {
                    totalWeights -= crossedTrucks.poll();    
                }
                
                if (waitingTrucks.isEmpty() && crossingTrucks.isEmpty()) {
                    break;
                }
            };
            
            if (!waitingTrucks.isEmpty() &&totalWeights + waitingTrucks.peek() <= weight && crossingTrucks.size() + 1 <= bridge_length) {
                    int currentTruckWeight = waitingTrucks.poll();
                    crossedTrucks.offer(currentTruckWeight);
                    totalWeights += currentTruckWeight;
                    crossingTrucks.offer(time);
                
            }
        }
        
        
        
        
        return time;
    }
}