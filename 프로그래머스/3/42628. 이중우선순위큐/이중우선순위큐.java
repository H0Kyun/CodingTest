import java.util.*;

class DualPriorityQueue {
    private Deque<Integer> deque;
    
    DualPriorityQueue() {
        this.deque = new ArrayDeque<Integer>();
    }
    
    public void insert(Integer value) {
        this.deque.add(value);
        
        Integer[] sortedArray = deque.toArray(new Integer[deque.size()]);
        Arrays.sort(sortedArray);
        deque.clear();
        
        for (Integer number : sortedArray) {
            this.deque.add(number);
        }
    }
    
    public void removeMax() {
        if (this.deque.isEmpty()) {
            return;
        }
        
        this.deque.removeLast();
    }
    
    public void removeMin() {
        if (this.deque.isEmpty()) {
            return;
        }
        
        this.deque.removeFirst();
    }
    
    public Integer getMax() {
        if (this.deque.isEmpty()) {
            return 0;
        }
        
        return this.deque.peekLast();
    }
    
    public Integer getMin() {
        if (this.deque.isEmpty()) {
            return 0;
        }
        
        return this.deque.peekFirst();
    }
}

class Solution {
    public int[] solution(String[] operations) {
        DualPriorityQueue dualPQ = new DualPriorityQueue();
        
        for (String operation : operations) {
            if (operation.equals("D 1")) {
                dualPQ.removeMax();
            } else if (operation.equals("D -1")) {
                dualPQ.removeMin();
            } else {
                dualPQ.insert(Integer.parseInt(operation.split(" ")[1]));
            }
        }
        
        int[] answer = { dualPQ.getMax(), dualPQ.getMin() };
        
        return answer;
    }
}