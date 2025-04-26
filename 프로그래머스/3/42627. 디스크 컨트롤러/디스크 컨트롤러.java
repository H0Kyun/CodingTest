import java.util.*;

class Job {
    static Comparator<Job> byDuration = Comparator
        .comparingInt(Job::getDuration)
        .thenComparingInt(Job::getRequestTime)
        .thenComparingInt(Job::getId);
    
    static Comparator<Job> byRequestTime = Comparator
        .comparingInt(Job::getRequestTime)
        .thenComparingInt(Job::getDuration)
        .thenComparingInt(Job::getId);  
    
    
    private int id;
    private int requestTime;
    private int duration;
    private int startTime;
    
    Job(int id, int requestTime, int duration) {
        this.id = id;
        this.requestTime = requestTime;
        this.duration = duration;
    }
    
    int getId() {
        return this.id;
    }
    
    int getRequestTime() {
        return this.requestTime;
    }
    
    int getDuration() {
        return this.duration;
    }
    
    int getStartTime() {
        return this.startTime;
    }
    
    void setStartTime(int value) {
        this.startTime = value;
    }
}

class Solution {
    public int solution(int[][] jobs) {
        PriorityQueue<Job> scheduledQueue = new PriorityQueue<Job>(Job.byDuration);
        PriorityQueue<Job> waitingQueue = new PriorityQueue<Job>(Job.byRequestTime);
        
        for (int i = 0; i < jobs.length; ++i) {
            waitingQueue.offer(new Job(i, jobs[i][0], jobs[i][1]));
        }
        
        int answer = 0;
        int currentTime = 0;
        
        while(!(scheduledQueue.isEmpty() && waitingQueue.isEmpty())) {
            while(!waitingQueue.isEmpty() && waitingQueue.peek().getRequestTime() <= currentTime) {
                scheduledQueue.offer(waitingQueue.poll());
            }
            
            if (!scheduledQueue.isEmpty()) {
                Job job = scheduledQueue.poll();
                job.setStartTime(currentTime);
                int finishTime = job.getStartTime() + job.getDuration();
                
                answer += finishTime - job.getRequestTime();
                currentTime = finishTime;
            } else {
                currentTime = waitingQueue.peek().getRequestTime();
            }
        }
        
        return answer / jobs.length;
    }
}