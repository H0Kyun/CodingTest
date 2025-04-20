import java.util.*;

class Job {
    private int onRequest;
    private int id;
    private int timeRequired;
    private int startTime;
    
    Job(int id, int onRequest, int timeRequired) {
        this.id = id;
        this.onRequest = onRequest;
        this.timeRequired = timeRequired;
    }
    
    int getOnRequest() {
        return this.onRequest;
    }
    
    int getTimeRequired() {
        return this.timeRequired;
    }
    
    int getId() {
        return this.id;
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
        PriorityQueue<Job> pq = new PriorityQueue<Job>((job1, job2) -> {
            if (job1.getTimeRequired() - job2.getTimeRequired() == 0) {
                if (job1.getOnRequest() - job2.getOnRequest() == 0) {
                    return job1.getId() - job2.getId();
                } else {
                    return job1.getOnRequest() - job2.getOnRequest();
                }
            } else {
                return job1.getTimeRequired() - job2.getTimeRequired();
            }
        });
        PriorityQueue<Job> onRequestPQ = new PriorityQueue<Job>((job1, job2) -> {
            if (job1.getOnRequest() - job2.getOnRequest() == 0) {
                if (job1.getTimeRequired() - job2.getTimeRequired() == 0) {
                    return job1.getId() - job2.getId();
                } else {
                    return job1.getTimeRequired() - job2.getTimeRequired();
                }
            } else {
                return job1.getOnRequest() - job2.getOnRequest();
            }
        });
        
        for (int i = 0; i < jobs.length; ++i) {
            onRequestPQ.offer(new Job(i, jobs[i][0], jobs[i][1]));
        }
        
        pq.offer(onRequestPQ.poll());
        int answer = 0;
        int startTime = pq.peek().getOnRequest();
        
        while(!(pq.isEmpty() && onRequestPQ.isEmpty())) {
            if (!pq.isEmpty()) {
                Job currentJob = pq.poll();
                currentJob.setStartTime(startTime);
                int returnTime = currentJob.getStartTime() + currentJob.getTimeRequired();
                
                answer += returnTime - currentJob.getOnRequest();
                startTime = returnTime;
                
                while(!onRequestPQ.isEmpty() && onRequestPQ.peek().getOnRequest() <= returnTime) {
                    pq.offer(onRequestPQ.poll());
                }
            } else if (!onRequestPQ.isEmpty()) {
                pq.offer(onRequestPQ.poll());
                startTime = pq.peek().getOnRequest();
            }
        }
        
        return answer / jobs.length;
    }
}