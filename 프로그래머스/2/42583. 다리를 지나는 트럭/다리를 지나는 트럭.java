import java.util.*;

class Truck {
    private int weight;
    private int time;
    
    Truck(int weight, int time) {
        this.weight = weight;
        this.time = time;
    }
    
    int getWeight() {
        return this.weight;
    }
    
    int getTime() {
        return this.time;
    }
}

class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Queue<Integer> waitingTrucks = new ArrayDeque();
        Queue<Truck> crossingTrucks = new ArrayDeque();
        
        for (int truck : truck_weights) {
            waitingTrucks.offer(truck);
        }
        
        int time = 0;
        int totalWeights = 0;
        
        while(!(waitingTrucks.isEmpty() && crossingTrucks.isEmpty())) {
            ++time;
            
            if (!crossingTrucks.isEmpty() && crossingTrucks.peek().getTime() + bridge_length == time) {
                totalWeights -= crossingTrucks.poll().getWeight();
            };
            
            if (!waitingTrucks.isEmpty() 
                && totalWeights + waitingTrucks.peek() <= weight 
                && crossingTrucks.size() + 1 <= bridge_length
            ) {
                int currentTruckWeight = waitingTrucks.poll();
                totalWeights += currentTruckWeight;
                crossingTrucks.offer(new Truck(currentTruckWeight, time));
            }
        }
        
        return time;
    }
}